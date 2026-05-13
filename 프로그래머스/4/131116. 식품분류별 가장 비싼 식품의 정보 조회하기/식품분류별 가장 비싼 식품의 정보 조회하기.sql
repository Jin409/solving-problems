select a.category, max_price, product_name
from food_product a
join (
    select category, max(price) as max_price
    from food_product 
    group by category
    having category in ('과자', '국', '김치', '식용유')
) b
on a.category = b.category and price = max_price
order by max_price desc;