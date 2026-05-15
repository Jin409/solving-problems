select CAR_ID, case 
    when car_id in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where TO_CHAR(start_date, 'YYYY-MM-DD') <= '2022-10-16' and
        TO_CHAR(end_date, 'YYYY-MM-DD') >= '2022-10-16'
    ) then '대여중'
    else '대여 가능'
    end
    as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by CAR_ID DESC;