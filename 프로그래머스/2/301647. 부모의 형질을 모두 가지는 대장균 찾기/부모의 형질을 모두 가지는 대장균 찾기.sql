select e.id, e.genotype, s.genotype as parent_genotype
from ecoli_data as e
inner join ecoli_data as s
on e.parent_id = s.id
WHERE (e.genotype & s.genotype) = s.genotype
order by e.id asc