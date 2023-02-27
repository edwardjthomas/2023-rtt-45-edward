
select * from employees where firstName = "Leslie";

select * from employees where VacationHours < 40;

select lastName, firstName from employees where firstName like "M%";

select e.firstName, e.lastName, c.customerName, c.phone, c.state
from employees e, customers c 
where e.employeeNumber = c.salesRepEmployeeNumber
order by e.firstName, e.lastName;

select * from employees;

update employees set extension = "JJJJ" where firstName like "J%";

insert into employees ( employeeNUmber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle, VacationHours )
			values 	  ( 2023, "Jones", "Bruhman", "ext", "bruh@man.dude", 1, 1002, "TITLE", 500 );
            
delete from employees where employeeNumber = 2023;

select c.customerNumber, c.customerName, o.orderNumber, o.orderDate
from customers c, orders o
where c.customerNumber = o.customerNumber
order by customerName;

select c.customerNumber, c.customerName, count(o.orderNumber) as total_order_count , max(orderDate) as most_recent_order, min(orderDate) as first_order_date
from customers c, orders o
where c.customerNumber = o.customerNumber
group by c.customerNumber
order by customerName;

-- I want to see the customer name, order number, product code, product name and quantity ordered, price of the product and the MSRP
-- now I want to add the total price for each product ordered that the customer paid
-- now I want to see the total margin for the order line item
-- this does not need a group by
select c.customerName, o.orderNumber, od.productCode, p.productName, od.quantityOrdered, p.buyPrice, p.MSRP, (p.MSRP - p.buyPrice) as product_margin,
		(p.MSRP * od.quantityOrdered) as customer_paid, ((p.MSRP - p.buyPrice) * od.quantityOrdered) as total_margin
from orders o, orderdetails od, products p, customers c
where o.orderNumber = od.orderNumber
and od.productCode = p.productCode
and c.customerNumber = o.customerNumber;

-- I want to see the customer name, product code, and the product name
-- and how many times a customer has purchased a particular product (not the number of products purchased)
select c.customerName, p.productCode, p.productName, count(p.productCode)
from customers c, products p, orderdetails od, orders o
where c.customerNumber = o.customerNumber
and o.orderNumber = od.orderNumber
and od.productCode = p.productCode
group by c.customerNumber, p.productCode
order by p.productCode;

-- I want to see all product codes product names and how many times each product has been ordered (not the quantity)
-- now we want to order this by the highest order count and then alphabetically
select p.productCode, p.productName, count(p.productCode) as order_count
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode
order by order_count desc, productName asc;

-- I want to see the productLine and the description and the number of products in that product line
select pl.productLine, pl.textDescription, count(p.productCode)
from productlines pl, products p
where p.productLine = pl.productLine
group by p.productLine;

-- a) I want to see the total profit for each item including the number of items purchased
-- a) so .. if product x was ordered 10 times and had 50 items ordered in each order I want to see the total gross margin
select p.productCode, p.productName, count(quantityOrdered) as quantity_sold, sum(buyPrice * quantityOrdered) as COGS, sum(MSRP * quantityOrdered) as net_sales,
sum(MSRP * quantityOrdered) - sum(buyPrice * quantityOrdered) as total_profit
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode
order by total_profit desc;

-- going over above code step by step
-- I want to see the product code, product name, total quantity ordered, cost of goods sold (COGS), net sales, and total profit for each product that was purchased
-- so .. if product x was ordered 10 times and had 50 items ordered in each order I want to see the total gross margin
select p.productCode, p.productName, od.quantityOrdered
from products p, orderdetails od
where p.productCode = od.productCode;

-- step 2
select p.productCode, p.productName, od.quantityOrdered, p.buyPrice, p.MSRP
from products p, orderdetails od
where p.productCode = od.productCode;

-- step 3
select p.productCode, p.productName, sum(od.quantityOrdered), p.buyPrice, p.MSRP
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode;

-- step 4
select p.productCode, p.productName, sum(od.quantityOrdered) as total_quantity_ordered, p.buyPrice, p.MSRP
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode;

-- step 5
select p.productCode, p.productName, sum(od.quantityOrdered) as total_quantity_ordered, sum(p.buyPrice * od.quantityOrdered) as COGS, p.MSRP
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode;

-- step 6
select p.productCode, p.productName, sum(od.quantityOrdered) as total_quantity_ordered, 
		sum(p.buyPrice * od.quantityOrdered) as COGS, sum(p.MSRP * od.quantityOrdered) as net_sales
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode;

-- step 7
select p.productCode, p.productName, sum(od.quantityOrdered) as total_quantity_ordered, 
		sum(p.buyPrice * od.quantityOrdered) as COGS, sum(p.MSRP * od.quantityOrdered) as net_sales,
        sum((p.MSRP - p.buyPrice) * od.quantityOrdered) as total_profit
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode;

-- now to go further step by step
-- b) now .. lets increase the complexity
-- b) I want to use a subtable to calculate total profit and profit margin percentage and I want to see the lowest margin products first
-- step 1
select subtable.*, subtable.net_sales - subtable.COGS as total_profit
	from
		(
			select p.productCode, p.productName, p.buyPrice, p.MSRP, sum(od.quantityOrdered) as total_quantity_ordered, 
				sum(p.buyPrice * od.quantityOrdered) as COGS, sum(p.MSRP * od.quantityOrdered) as net_sales
			from products p, orderdetails od
			where p.productCode = od.productCode
			group by p.productCode
		) as subtable;

-- step 2        
select subtable.*, subtable.net_sales - subtable.COGS as total_profit, (net_sales - COGS) / net_sales * 100 as profit_margin
	from
		(
			select p.productCode, p.productName, p.buyPrice, p.MSRP, sum(od.quantityOrdered) as total_quantity_ordered, 
				sum(p.buyPrice * od.quantityOrdered) as COGS, sum(p.MSRP * od.quantityOrdered) as net_sales
			from products p, orderdetails od
			where p.productCode = od.productCode
			group by p.productCode
		) as subtable
	order by profit_margin asc;

-- HW #1 of all the customer that have made orders, I want to see the customer name, first order date, month of the first order, the last order date, 
-- year of the last order, and how long this customer has been a customer ( last - first ) in days
-- this was going to involve the customers, the orders
-- the minimum order date "For Each Customer"?
-- what does it trigger?
-- use group by
-- group by the customer id
-- subtract the max order date from min order date to get the amount of days this person has been a customer FOR EACH CUSTOMER
-- you can also use MONTH & YEAR to find the month and year of the order date

-- HW #2 I want to know the average margin for all orders sorted by the order with the highest margin first. This includes the margin on the quantity of products sold

-- HW #3 - Extra Hard :/ - I want to see my most profitable customers by the average profit margin of all their orders (kinda builds on HW# 2)