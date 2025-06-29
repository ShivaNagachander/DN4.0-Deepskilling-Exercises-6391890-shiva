-- ✅ Step 1: Drop the Customers table if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

-- ✅ Step 2: Create table with correct structure
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name       VARCHAR2(100),
    Balance    NUMBER,
    IsVIP      VARCHAR2(5)
);

-- ✅ Step 3: Insert test data using column names
INSERT INTO Customers (CustomerID, Name, Balance, IsVIP)
VALUES (1, 'Shiva', 15000, NULL);

INSERT INTO Customers (CustomerID, Name, Balance, IsVIP)
VALUES (2, 'Anita', 8000, NULL);

INSERT INTO Customers (CustomerID, Name, Balance, IsVIP)
VALUES (3, 'Ravi', 11000, NULL);

COMMIT;

-- ✅ Step 4: Update VIP status using PL/SQL
BEGIN
  FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF c.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = c.CustomerID;
    ELSE
      UPDATE Customers
      SET IsVIP = 'FALSE'
      WHERE CustomerID = c.CustomerID;
    END IF;
  END LOOP;
END;
/

-- ✅ Step 5: Show the final result
SELECT * FROM Customers;
