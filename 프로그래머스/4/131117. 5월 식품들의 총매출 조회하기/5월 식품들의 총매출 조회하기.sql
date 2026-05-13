select a.product_id, a.product_name, total_amounts * price as total_sales -- amount 모두 더하고 price 와 곱하기
from food_product a
join (
    select sum(amount) as total_amounts, product_id
    from food_order
    where extract(year from produce_date) = 2022 and extract(month from produce_date) = 5 
    group by product_id
) b
on a.product_id = b.product_id
order by total_sales desc, product_id asc