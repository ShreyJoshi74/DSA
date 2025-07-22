# Write your MySQL query statement below
SELECT emp1.name AS Employee
FROM Employee AS emp1
JOIN Employee emp2
    on emp1.managerID = emp2.id
Where emp1.salary > emp2.salary;