#1
select FIRST_NAME, orders.*
from orders
join users
on users.USER_ID = orders.USER_ID
where FIRST_NAME = "Marion";

#2
select * from users u where u.USER_ID not in (select USER_ID from orders);

#3
Select name, price from items 
where ITEM_ID in 
(select ITEM_ID from order_items group by ITEM_ID having count(*) >= 2);

#4
/*order_id comes orders & order_items*/
select orders.order_id, items.name, items.price, order_items.quantity 
from orders
join stores on orders.STORE_ID = stores.STORE_ID
join order_items on orders.ORDER_ID = order_items.ORDER_ID
join items on order_items.ITEM_ID = items.ITEM_ID
where stores.city = "New York" 
order by ORDER_ID asc;

#5
select name as ITEM_NAME, sum(price*quantity) as REVENUE
from items
join order_items on items.ITEM_ID = order_items.ITEM_ID
group by name;

#6
SELECT NAME, count(orders.STORE_ID) as ORDER_QUANTITY,
	CASE WHEN count(orders.STORE_ID) > 3 THEN "High"
		WHEN count(orders.STORE_ID) <= 3 AND count(orders.STORE_ID) > 1 THEN "Medium"
        ELSE "Low"
        END "SALES_FIGURE"
FROM stores
JOIN orders ON stores.STORE_ID = orders.STORE_ID
group by name
order by count(orders.STORE_ID) desc;


