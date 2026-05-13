select a.animal_id, name
from animal_outs a
left join (
    select animal_id
    from animal_ins
) b
on a.animal_id = b.animal_id
where b.animal_id is null
order by animal_id;