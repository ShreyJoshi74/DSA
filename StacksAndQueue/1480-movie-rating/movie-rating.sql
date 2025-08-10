WITH Table1 AS (
    SELECT 
        b.name as name,
        COUNT(*) AS rating_count,
        ROW_NUMBER() OVER (ORDER BY COUNT(*) DESC, b.name ASC) AS row_num
    FROM MovieRating A
    LEFT JOIN Users B
        ON A.user_id = B.user_id
    GROUP BY A.user_id, b.name
),
Table2 AS (
    SELECT 
        B.title AS title,
        AVG(rating) AS avg_rating,
        ROW_NUMBER() OVER (ORDER BY AVG(rating) DESC, B.title ASC) AS row_num
    FROM MovieRating A
    LEFT JOIN Movies B
        ON A.movie_id = B.movie_id
    WHERE YEAR(created_at) = 2020 
      AND MONTH(created_at) = 2
    GROUP BY A.movie_id, B.title
)
SELECT DISTINCt name as results
FROM Table1
WHERE row_num = 1
UNION ALL
SELECT title 
FROM Table2
WHERE row_num = 1;