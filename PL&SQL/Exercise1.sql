SET SERVEROUTPUT ON;

-- ============================================================
-- SCENARIO 1
-- ============================================================

PROMPT ======================================================
PROMPT SCENARIO 1 : Loan Interest Discount for Senior Citizens
PROMPT ======================================================

DECLARE
    CURSOR customerLoanCursor IS
        SELECT
            c.CustomerID,
            c.DOB,
            l.LoanID,
            l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID;
BEGIN

    FOR rec IN customerLoanCursor LOOP

        -- Check whether customer's age is greater than 60
        IF FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Interest Updated for Customer ID '
                || rec.CustomerID
            );

        END IF;

    END LOOP;

    COMMIT;

END;
/

PROMPT
PROMPT Updated Loan Details

SELECT LoanID,
       CustomerID,
       InterestRate
FROM Loans;





-- ============================================================
-- SCENARIO 2
-- Mark customers as VIP if Balance > 10000
-- ============================================================

PROMPT
PROMPT ======================================================
PROMPT SCENARIO 2 : VIP Customers
PROMPT ======================================================

-- Add VIP column only if it does not already exist

DECLARE
    column_exists NUMBER;
BEGIN

    SELECT COUNT(*)
    INTO column_exists
    FROM USER_TAB_COLUMNS
    WHERE TABLE_NAME = 'CUSTOMERS'
    AND COLUMN_NAME = 'ISVIP';

    IF column_exists = 0 THEN
        EXECUTE IMMEDIATE
        'ALTER TABLE Customers ADD IsVIP CHAR(1)';
    END IF;

END;

/


BEGIN

    FOR rec IN
    (
        SELECT CustomerID,
               Balance
        FROM Customers
    )
    LOOP

        IF rec.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer '
                || rec.CustomerID
                || ' promoted to VIP'
            );

        ELSE

            UPDATE Customers
            SET IsVIP = 'N'
            WHERE CustomerID = rec.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

END;
/

PROMPT
PROMPT Customer Details

SELECT CustomerID,
       Name,
       Balance,
       IsVIP
FROM Customers;






-- ============================================================
-- SCENARIO 3
-- Print reminders for loans due within next 30 days
-- ============================================================

PROMPT
PROMPT ======================================================
PROMPT SCENARIO 3 : Loan Due Reminder
PROMPT ======================================================

BEGIN

    FOR rec IN
    (
        SELECT
            c.Name,
            l.LoanID,
            l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder : Loan ID '
            || rec.LoanID
            || ' belonging to '
            || rec.Name
            || ' is due on '
            || TO_CHAR(rec.EndDate,'DD-MON-YYYY')
        );

    END LOOP;

END;
/

PROMPT
PROMPT Loan Details

SELECT LoanID,
       CustomerID,
       EndDate
FROM Loans;
