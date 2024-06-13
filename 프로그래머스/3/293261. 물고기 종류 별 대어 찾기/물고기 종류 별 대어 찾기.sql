-- 종류별로 가장 큰 물고기의 길이
with l as (
    select fish_type, max(length) as length
    from fish_info
    group by fish_type
), i as (
    select id, i.fish_type, fish_name, length
    from fish_info as i inner join fish_name_info as n on i.fish_type = n.fish_type
)

select id, fish_name, i.length
from l inner join i on l.fish_type = i.fish_type
where l.fish_type = i.fish_type and l.length = i.length
order by id asc