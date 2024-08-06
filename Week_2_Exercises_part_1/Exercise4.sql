-- Scenario 1: Calculate the age of customers for eligibility checks
CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
    l_age NUMBER;
BEGIN
    l_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN l_age;
END;
/

-- Scenario 2: Compute the monthly installment for a loan
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMBER,
    p_interest_rate NUMBER,
    p_duration_years NUMBER
) RETURN NUMBER IS
    l_monthly_installment NUMBER;
    l_monthly_rate NUMBER;
    l_total_months NUMBER;
BEGIN
    l_monthly_rate := p_interest_rate / 12 / 100;
    l_total_months := p_duration_years * 12;
    l_monthly_installment := p_loan_amount * l_monthly_rate / (1 - POWER(1 + l_monthly_rate, -l_total_months));
    RETURN l_monthly_installment;
END;
/

-- Scenario 3: Check if a customer has sufficient balance before making a transaction
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id NUMBER,
    p_amount NUMBER
) RETURN BOOLEAN IS
    l_balance NUMBER;
BEGIN
    SELECT Balance INTO l_balance FROM Accounts WHERE AccountID = p_account_id;
    RETURN l_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
