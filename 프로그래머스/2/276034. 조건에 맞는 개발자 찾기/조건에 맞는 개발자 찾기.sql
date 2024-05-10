with s as (
    select code
    from skillcodes
    where name = 'C#' or name = 'Python'
)
select id, email, first_name, last_name
from developers 
where exists (
    select 1
    from s
    where skill_code & s.code
)
order by id asc;