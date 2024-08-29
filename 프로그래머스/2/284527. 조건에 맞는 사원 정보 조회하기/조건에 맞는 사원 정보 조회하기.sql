with info as (
    select emp_no, emp_name, position, email
    from hr_employees as e inner join hr_department as d
    on e.dept_id = d.dept_id
), s as (
    select emp_no, sum(score) as score
    from hr_grade
    where year = 2022
    group by emp_no
    order by score desc limit 1
)

select score, s.emp_no, emp_name, position, email
from s inner join info as i on s.emp_no = i.emp_no
