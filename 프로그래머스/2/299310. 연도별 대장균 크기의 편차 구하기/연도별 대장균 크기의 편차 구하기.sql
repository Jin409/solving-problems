with m as (
    select year(DIFFERENTIATION_DATE) as year, max(size_of_colony) as size
    from ecoli_data
    group by year(DIFFERENTIATION_DATE)
)

select year(DIFFERENTIATION_DATE) as year, m.size - size_of_colony as year_dev, id
from ecoli_data as e join m on year(e.DIFFERENTIATION_DATE) = m.year
order by year asc, year_dev asc