-- Scenario 1: Apply a discount to loan interest rates for customers above 60 years old
DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID, FLOOR(MONTHS_BETWEEN(SYSDATE, DOB) / 12) AS Age
        FROM Customers;
BEGIN
    FOR customer_rec IN cur_customers LOOP
        IF customer_rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
-- Scenario 2: Promote customers to VIP status based on balance
ALTER TABLE Customers ADD (IsVIP CHAR(1) DEFAULT 'N');

DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    FOR customer_rec IN cur_customers LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days
DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan_rec IN cur_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID || ' for Customer ID ' || loan_rec.CustomerID || ' is due on ' || loan_rec.EndDate);
    END LOOP;
END;
/