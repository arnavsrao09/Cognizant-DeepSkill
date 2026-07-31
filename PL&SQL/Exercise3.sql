SET SERVEROUTPUT ON;

-- ============================================================
-- SCENARIO 1
-- Process Monthly Interest
-- Apply 1% interest to all Savings Accounts
-- ============================================================

PROMPT ======================================================
PROMPT SCENARIO 1 : Process Monthly Interest
PROMPT ======================================================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');

END;
/

-- Execute Procedure
BEGIN
    ProcessMonthlyInterest;
END;
/

PROMPT Updated Account Details

SELECT *
FROM Accounts;


-- ============================================================
-- SCENARIO 2
-- Update Employee Bonus
-- Increase salary of employees in a department
-- by a given bonus percentage.
-- ============================================================

PROMPT
PROMPT ======================================================
PROMPT SCENARIO 2 : Employee Bonus
PROMPT ======================================================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
)
AS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Bonus applied successfully to Department : '
        || p_Department
    );

END;
/

-- Execute Procedure
BEGIN
    UpdateEmployeeBonus('IT',10);
END;
/

PROMPT Updated Employee Details

SELECT *
FROM Employees;

-- ============================================================
-- SCENARIO 3
-- Transfer Funds
-- Transfer amount from one account to another
-- after checking sufficient balance.
-- ============================================================

PROMPT
PROMPT ======================================================
PROMPT SCENARIO 3 : Transfer Funds
PROMPT ======================================================

CREATE OR REPLACE PROCEDURE TransferFunds
(
    p_FromAccount IN NUMBER,
    p_ToAccount   IN NUMBER,
    p_Amount      IN NUMBER
)
AS

    v_Balance NUMBER;

BEGIN

    -- Get source account balance
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    -- Check sufficient balance
    IF v_Balance >= p_Amount THEN

        -- Debit source account
        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        -- Credit destination account
        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund Transfer Successful.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

    END IF;

EXCEPTION

    WHEN NO_DATA_FOUND THEN

        DBMS_OUTPUT.PUT_LINE('Invalid Account Number.');

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(SQLERRM);

END;
/


BEGIN
    TransferFunds(1,2,500);
END;
/

PROMPT Updated Account Details

SELECT *
FROM Accounts;
