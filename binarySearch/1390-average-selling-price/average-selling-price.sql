# Write your MySQL query statement below
WITH Table1 AS (SELECT A.product_id,A.price * B.units as Total,B.units AS units
FROM UnitsSold AS B
RIGHT JOIN Prices AS A
    ON B.product_id = A.product_id AND B.purchase_date BETWEEN A.start_date AND A.end_date)
SELECT product_id,ifnull(ROUND(SUM(Total)/SUM(units),2),0) AS average_price
FROM Table1
GROUP BY product_id
ORDER BY product_id ASC;