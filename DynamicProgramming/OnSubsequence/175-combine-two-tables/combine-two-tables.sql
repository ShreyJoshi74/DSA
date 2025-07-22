# Write your MySQL query statement below
Select firstName,lastName,city,state
From Person as P
left Join Address as A
    On P.personId = A.personID;