
with p as (
    select t.item_id
    from item_info as i inner join item_tree as t on i.item_id = t.parent_item_id
    where i.rarity = 'RARE'
)

select i.item_id, i.item_name, i.rarity
from item_info as i inner join p on i.item_id = p.item_id
order by i.item_id desc
