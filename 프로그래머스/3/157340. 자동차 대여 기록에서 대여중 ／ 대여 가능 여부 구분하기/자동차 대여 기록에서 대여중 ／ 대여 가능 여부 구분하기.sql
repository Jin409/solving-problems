select distinct car_id, case
    when car_id in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where start_date <= TO_DATE('2022-10-16', 'YYYY-MM-DD')
        and end_date >= TO_DATE('2022-10-16', 'YYYY-MM-DD')
    ) then '대여중'
    else '대여 가능'
    end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by car_id desc;