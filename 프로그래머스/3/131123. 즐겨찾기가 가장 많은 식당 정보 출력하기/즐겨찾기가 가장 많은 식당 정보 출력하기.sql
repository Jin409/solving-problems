-- 음식 종류별로 즐겨찾기 수가 가장 많

with f as (
    select food_type, max(favorites) as max_favorites
    from rest_info
    group by food_type
)

select r.food_type, rest_id, rest_name, favorites
from rest_info as r join f
where r.favorites = f.max_favorites and r.food_type = f.food_type
order by food_type desc