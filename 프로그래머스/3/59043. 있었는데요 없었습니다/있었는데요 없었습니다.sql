-- in 의 날짜보다 out 의 날짜가 더 빠른 경우를 찾기

select a.animal_id, a.name
from animal_ins a
join animal_outs b
on a.animal_id = b.animal_id
where a.datetime > b.datetime
order by a.datetime