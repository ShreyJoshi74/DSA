# Write your MySQL query statement below
WITH Table1 AS (SELECT customer_id,
    CASE
        WHEN order_date = customer_pref_delivery_date THEN "IMMEDIATE"
        ELSE "SCHEDULED"
    END AS TYPE,
    ROW_NUMBER() OVER(PARTITION BY customer_id ORDER BY order_date ASC ) AS id
FROM Delivery),
TABLE2 AS
(SELECT customer_id,
     TYPE
FROM Table1
WHERE id = 1
)
SELECT ROUND((SELECT COUNT(*) FROM TABLE2 WHERE TYPE = "IMMEDIATE")*100/(SELECT COUNT(*) FROM TABLE2) ,2) AS Immediate_Percentage;

