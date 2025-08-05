# Write your MySQL query statement below
WITH Table1(product_id,Price,change_date,max_date) AS (SELECT product_id, new_price AS Price,change_date , MAX(change_date) OVER(Partition BY product_id)
FROM Products
WHERE change_date <=  '2019-08-16'),
 Table2 AS(
SELECT product_id,10 as price
FROM products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16'
)
SELECT product_id , Price AS price
FROM Table1
where change_date = max_date

UNION 
SELECT product_id,price
FROM Table2
ORDER BY product_id ASC;
