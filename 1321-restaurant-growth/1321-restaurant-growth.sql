# Write your MySQL query statement below
WITH DailySum AS (
    SELECT 
        visited_on, 
        SUM(amount) AS daily_amount
    FROM Customer
    GROUP BY visited_on
),
MovingAvg AS (
    SELECT 
        visited_on,
        SUM(daily_amount) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        ROUND(AVG(daily_amount) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ), 2) AS average_amount,
        MIN(visited_on) OVER () AS first_date
    FROM DailySum
)
SELECT 
    visited_on, 
    amount, 
    average_amount
FROM MovingAvg
WHERE DATEDIFF(visited_on, first_date) >= 6
ORDER BY visited_on;