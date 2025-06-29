

CREATE TABLE Accounts (
  AccountID   NUMBER PRIMARY KEY,
  AccountType VARCHAR2(20),
  Balance     NUMBER
);

-- Step 2: Sample data
INSERT INTO Accounts VALUES (101, 'Savings', 10000);
INSERT INTO Accounts VALUES (102, 'Savings', 20000);
INSERT INTO Accounts VALUES (103, 'Current', 5000);
COMMIT;

-- Step 3: Create procedure
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01)
  WHERE AccountType = 'Savings';
END;
/

-- Step 4: Call procedure
BEGIN
  ProcessMonthlyInterest;
END;
/

-- Step 5: View output
SELECT * FROM Accounts;
