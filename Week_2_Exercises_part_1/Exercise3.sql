-- Scenario 1: Process monthly interest for all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    
    COMMIT;
END;
/

-- Scenario 2: Implement a bonus scheme for employees based on performance
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department VARCHAR2,
    p_bonus_percentage NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;

    COMMIT;
END;
/

-- Scenario 3: Transfer funds between customer accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
) AS
    l_balance NUMBER;
BEGIN
    SELECT Balance INTO l_balance FROM Accounts WHERE AccountID = p_from_account;
    IF l_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/
