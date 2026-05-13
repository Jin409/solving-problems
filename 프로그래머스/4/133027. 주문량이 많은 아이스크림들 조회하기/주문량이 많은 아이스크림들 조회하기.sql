select a.flavor
from (
    select flavor, sum(total_order) as amount
    from first_half
    group by flavor
) a
join (
    select flavor, sum(total_order) as amount
    from july
    group by flavor
) b
on a.flavor = b.flavor
order by a.amount + b.amount desc
fetch first 3 rows only;