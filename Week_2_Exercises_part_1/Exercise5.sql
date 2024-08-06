-- Scenario 1: Automatically update the last modified date when a customer's record is updated
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

-- Scenario 2: Maintain an audit log for all transactions
CREATE TABLE AuditLog (
    LogID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LogTimestamp DATE DEFAULT SYSDATE
);

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (AuditLog_SEQ.NEXTVAL, :NEW.TransactionID, :NEW.AccountID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType);
END;
/

-- Scenario 3: Enforce business rules on deposits and withdrawals
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        DECLARE
            l_balance NUMBER;
        BEGIN
            SELECT Balance INTO l_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
            IF l_balance < :NEW.Amount THEN
                RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal');
            END IF;
        END;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive');
        END IF;
    END IF;
END;
/
