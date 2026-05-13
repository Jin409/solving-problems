-- 가장 많이 작성한 회원들의 리뷰 조회

select b.member_name, a.review_text, TO_CHAR(a.review_date, 'YYYY-MM-DD') as review_date
from rest_review a
join (
    select member_id, member_name
    from member_profile
) b
on a.member_id = b.member_id
where a.member_id in (
    select member_id
    from rest_review
    group by member_id
    having count(*) = (
        select max(count(*))
        from rest_review
        group by member_id
    )
)
order by a.review_date asc, review_text asc
