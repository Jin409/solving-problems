select year, month, count(user_id) as purchased_users, round( count(user_id) / (
    select count(*)
    from user_info
    where extract(year from joined) = 2021
), 1) as puarchsed_ratio
from (
    select distinct user_id,
    extract(year from SALES_DATE) as year, 
    extract(month from SALES_DATE) as month
    from online_sale
    where user_id in (
        select user_id
        from user_info
        where extract(year from joined) = 2021
    )
)
group by year, month
order by year, month
