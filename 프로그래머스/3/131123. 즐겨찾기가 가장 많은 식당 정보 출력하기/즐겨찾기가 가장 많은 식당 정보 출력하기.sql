select a.food_type, a.rest_id, a.rest_name, a.favorites
from rest_info a
join (
    select max(favorites) as max_fav, food_type
    from rest_info
    group by food_type
) b
on a.food_type = b.food_type and b.max_fav = a.favorites
order by food_type desc