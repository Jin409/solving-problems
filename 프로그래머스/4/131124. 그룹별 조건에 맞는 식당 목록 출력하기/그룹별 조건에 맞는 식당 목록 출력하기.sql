SELECT b.member_name, a.review_text, TO_CHAR(a.review_date, 'YYYY-MM-DD') AS review_date
FROM rest_review a
JOIN member_profile b ON a.member_id = b.member_id
WHERE a.member_id IN (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    HAVING COUNT(*) = (
        SELECT MAX(COUNT(*))
        FROM rest_review
        GROUP BY member_id
    )
)
ORDER BY a.review_date ASC, a.review_text ASC;