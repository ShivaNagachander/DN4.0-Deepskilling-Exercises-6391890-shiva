-- Step 1: Drop and recreate table
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE Employees (
  EmpID       NUMBER PRIMARY KEY,
  Name        VARCHAR2(100),
  Department  VARCHAR2(50),
  Salary      NUMBER
);

-- Step 2: Sample data
INSERT INTO Employees VALUES (1, 'Alice', 'HR', 50000);
INSERT INTO Employees VALUES (2, 'Bob', 'IT', 60000);
INSERT INTO Employees VALUES (3, 'Carol', 'IT', 70000);
COMMIT;

-- Step 3: Create procedure
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept IN VARCHAR2,
  bonus_percent IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * bonus_percent / 100)
  WHERE Department = dept;
END;
/

-- Step 4: Call procedure
BEGIN
  UpdateEmployeeBonus('IT', 10);  -- 10% bonus for IT dept
END;
/

-- Step 5: View output
SELECT * FROM Employees;
