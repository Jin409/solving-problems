select e.emp_no, e.emp_name, case 
    when avg(score) >= 96 then 'S'
    when avg(score) >= 90 then 'A'
    when avg(score) >= 80 then 'B'
    else 'C' end as grade, case
    when avg(score) >= 96 then sal * 0.2
    when avg(score) >= 90 then sal * 0.15
    when avg(score) >= 80 then sal * 0.1
    else 0 end as bonus
from hr_grade as g inner join hr_employees as e on g.emp_no = e.emp_no
group by e.emp_no
order by e.emp_no
