select a.hour, count(b.datetime) as count
from (
    select level - 1 as hour
    from dual
    connect by level <= 24
) a
left join (
    select extract (hour from cast(datetime as timestamp)) as hour, datetime
    from animal_outs
) b
on a.hour = b.hour
group by a.hour
order by a.hour