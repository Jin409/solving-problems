SELECT count(*) from user_info
where extract (year from joined) = '2021' 
and age between 20 and 29;