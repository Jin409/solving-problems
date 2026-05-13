-- 아직 입양 못감 + 가장 오래 있었던 동물 3마리

select a.name, a.datetime
from animal_ins a
left join animal_outs b
on a.animal_id = b.animal_id
where b.animal_id is null
order by a.datetime
fetch first 3 rows only;