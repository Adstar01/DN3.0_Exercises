-- Scenario 1: Generate monthly statements for all customers
DECLARE
    CURSOR cur_statements IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE t.TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);
BEGIN
    FOR rec IN cur_statements LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' | Date: ' || rec.TransactionDate || ' | Amount: ' || rec.Amount || ' | Type: ' || rec.TransactionType);
    END LOOP;
END;
/

-- Scenario 2: Apply annual fee to all accounts
DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance FROM Accounts;
    l_fee NUMBER := 50; -- Annual fee
BEGIN
    FOR rec IN cur_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - l_fee
        WHERE AccountID = rec.AccountID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Update the interest rate for all loans based on a new policy
DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, InterestRate FROM Loans;
    l_new_rate NUMBER := 7; -- New interest rate
BEGIN
    FOR rec IN cur_loans LOOP
        UPDATE Loans
        SET InterestRate = l_new_rate
        WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
END;
/
