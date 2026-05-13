select a.product_id, a.product_name, amount_total * price as total_sales
from food_product a
join (
    select product_id, sum(amount) as amount_total
    from food_order
    where extract(year from produce_date) = 2022 and extract(month from produce_date) = 5
    group by product_id
) b on a.product_id = b.product_id
order by total_sales desc, product_id asc;