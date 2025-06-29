-- Scenario 1: Apply 1% interest discount for customers aged > 60

-- Step 2: Create Tables
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Step 3: Insert Data
INSERT INTO Customers VALUES (1, 'Shiva', TO_DATE('1950-01-01', 'YYYY-MM-DD'));
INSERT INTO Customers VALUES (2, 'Anita', TO_DATE('1995-06-15', 'YYYY-MM-DD'));
INSERT INTO Customers VALUES (3, 'Ravi', TO_DATE('1955-03-20', 'YYYY-MM-DD'));

INSERT INTO Loans VALUES (101, 1, 10.5);
INSERT INTO Loans VALUES (102, 2, 11.0);
INSERT INTO Loans VALUES (103, 3, 12.0);

COMMIT;

-- Step 4: PL/SQL Block
BEGIN
  FOR c IN (SELECT CustomerID, DOB FROM Customers) LOOP
    IF MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate * 0.99
      WHERE CustomerID = c.CustomerID;
    END IF;
  END LOOP;
END;
/

-- Step 5: Output
SELECT
  C.CustomerID,
  C.Name,
  C.DOB,
  FLOOR(MONTHS_BETWEEN(SYSDATE, C.DOB)/12) AS Age,
  L.InterestRate AS UpdatedInterestRate
FROM Customers C
JOIN Loans L ON C.CustomerID = L.CustomerID;
