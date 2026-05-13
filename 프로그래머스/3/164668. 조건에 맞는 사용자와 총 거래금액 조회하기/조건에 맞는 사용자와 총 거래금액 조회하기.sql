-- 완료된 중고거래의 총금액이 70만원 이상인 사람

select a.user_id, a.nickname, b.total_prices
from USED_GOODS_USER a
join (
    select writer_id, sum(price) as total_prices
    from USED_GOODS_BOARD
    where status = 'DONE'
    group by writer_id
    having total_prices >= 700000
) b
on a.user_id = b.writer_id
order by total_prices asc;
