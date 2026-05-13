select EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP)) as hour, count(*) as count
from animal_outs
where EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP)) between 9 and 20
group by EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP))
order by hour;