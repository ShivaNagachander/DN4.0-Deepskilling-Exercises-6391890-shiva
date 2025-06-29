-- Step 1: Drop and recreate Accounts table
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE Accounts (
  AccountID   NUMBER PRIMARY KEY,
  AccountType VARCHAR2(20),
  Balance     NUMBER
);

-- Step 2: Insert data
INSERT INTO Accounts VALUES (101, 'Savings', 10000);
INSERT INTO Accounts VALUES (102, 'Savings', 5000);
COMMIT;

-- Step 3: Create procedure
CREATE OR REPLACE PROCEDURE TransferFunds (
  fromAccID IN NUMBER,
  toAccID IN NUMBER,
  amount IN NUMBER
) AS
  insufficient_balance EXCEPTION;
BEGIN
  -- Check if source has enough balance
  DECLARE
    fromBal NUMBER;
  BEGIN
    SELECT Balance INTO fromBal FROM Accounts WHERE AccountID = fromAccID;

    IF fromBal < amount THEN
      RAISE insufficient_balance;
    END IF;

    -- Deduct and add
    UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = fromAccID;
    UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = toAccID;

  EXCEPTION
    WHEN insufficient_balance THEN
      DBMS_OUTPUT.PUT_LINE('Insufficient balance for transfer.');
  END;
END;
/

-- Step 4: Call procedure
BEGIN
  TransferFunds(101, 102, 2000);  -- Transfer ₹2000 from 101 to 102
END;
/

-- Step 5: View output
SELECT * FROM Accounts;
