-- Scenario 1: Handle exceptions during fund transfers between accounts
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
) AS
    l_balance NUMBER;
BEGIN
    -- Check if the from_account has sufficient balance
    SELECT Balance INTO l_balance FROM Accounts WHERE AccountID = p_from_account;
    IF l_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
    END IF;
    
    -- Perform the transfer
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

-- Scenario 2: Manage errors when updating employee salaries
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id NUMBER,
    p_percentage NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found');
    END IF;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

-- Scenario 3: Ensure data integrity when adding a new customer
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id NUMBER,
    p_name VARCHAR2,
    p_dob DATE,
    p_balance NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        ROLLBACK;
END;
/
