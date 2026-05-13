select year, month, gender, count(a.user_id) as users
from user_info a
inner join (
    select distinct user_id, 
    extract(year from sales_date) as year, 
    extract(month from sales_date) as month
    from online_sale
) b
on a.user_id = b.user_id
where gender is not null
group by year, month, gender
order by year, month, gender;