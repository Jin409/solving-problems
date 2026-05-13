-- out 에는 있는데 in 에는 없는 동물들의 id 와 이름

select a.animal_id, a.name
from animal_outs a
left join animal_ins b on a.animal_id = b.animal_id
where b.animal_id is null
order by animal_id, name;