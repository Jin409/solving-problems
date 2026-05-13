select a.hour, count(animal_id) as count
from (
    select level - 1 as hour
    from dual
    connect by level <= 24
) a
left join (
    select animal_id, extract(hour from cast(datetime as timestamp)) as hour
    from animal_outs
) b
on a.hour = b.hour
group by a.hour
order by a.hour