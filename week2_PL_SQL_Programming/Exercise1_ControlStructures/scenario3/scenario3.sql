-- Step 1: Drop tables if they exist
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Loans';
  EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

-- Step 2: Create Customers table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name       VARCHAR2(100)
);

-- Step 3: Create Loans table
CREATE TABLE Loans (
    LoanID      NUMBER PRIMARY KEY,
    CustomerID  NUMBER,
    DueDate     DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Step 4: Insert sample data
INSERT INTO Customers (CustomerID, Name) VALUES (1, 'Shiva');
INSERT INTO Customers (CustomerID, Name) VALUES (2, 'Anita');
INSERT INTO Customers (CustomerID, Name) VALUES (3, 'Ravi');

INSERT INTO Loans (LoanID, CustomerID, DueDate) VALUES (201, 1, SYSDATE + 10);
INSERT INTO Loans (LoanID, CustomerID, DueDate) VALUES (202, 2, SYSDATE + 45);
INSERT INTO Loans (LoanID, CustomerID, DueDate) VALUES (203, 3, SYSDATE + 5);

COMMIT;

-- Step 5: PL/SQL block to print reminders
BEGIN
  FOR l IN (
    SELECT L.LoanID, C.Name, L.DueDate
    FROM Loans L
    JOIN Customers C ON L.CustomerID = C.CustomerID
    WHERE L.DueDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || l.LoanID || ' for Customer ' || l.Name ||
                         ' is due on ' || TO_CHAR(l.DueDate, 'YYYY-MM-DD'));
  END LOOP;
END;
/

-- Step 6: View table result for screenshot
SELECT
  L.LoanID,
  C.Name AS CustomerName,
  TO_CHAR(L.DueDate, 'YYYY-MM-DD') AS DueDate,
  TRUNC(L.DueDate - SYSDATE) AS DaysLeft
FROM Loans L
JOIN Customers C ON L.CustomerID = C.CustomerID
WHERE L.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
