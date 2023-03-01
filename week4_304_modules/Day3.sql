-- from eric's aggregate-queries file (which is from 304.2.3 - 304.3.1 slides)

SELECT customerName, country, salesrepemployeenumber
FROM   classicmodels.customers
WHERE salesrepemployeenumber IS NULL
ORDER BY customerName; 

SELECT customerName, country, salesrepemployeenumber
FROM classicmodels.customers
WHERE salesrepemployeenumber IS NOT NULL
ORDER BY customerName;

SELECT customerNumber, customerName, country,
IF(state IS NULL, 'N/A', state) as state 
FROM classicmodels.customers;

select * from customers where customerNumber in ( 121, 125, 128, 141, 144);

select * from orderdetails;
SELECT   orderLineNumber, 
    CASE od.orderLineNumber
        WHEN 1  THEN 'NYC Warehouse'
        WHEN 2 THEN 'NJ Warehouse'
        WHEN 3 THEN 'CA Warehouse'
        WHEN 4 THEN 'PA Warehouse'
        ELSE   'ML warehouse'
    END AS Product_status    
FROM classicmodels.orderdetails od;

-- create a case statement if the price Each < 50 then print low, price < 100 print medium, price >= 100 then high
-- so from copying the example from the slide, we had to not put a variable next to CASE solved the issue of only returning the else statement

SELECT   priceEach, 
    CASE 
        WHEN priceEach < 50  THEN 'Low'
        WHEN priceEach < 100 THEN 'Medium'
        WHEN priceEach >= 100 THEN 'High'
        ELSE   'Not Priced'
    END AS Product_status    
FROM classicmodels.orderdetails od;

-- Custom HW's from Day2
-- HW #1 of all the customer that have made orders, I want to see the customer name, first order date, month of the first order, the last order date, 
-- year of the last order, and how long this customer has been a customer ( last - first ) in days
-- this was going to involve the customers, the orders
-- the minimum order date "For Each Customer"?
-- what does it trigger?
-- use group by
-- group by the customer id
-- subtract the max order date from min order date to get the amount of days this person has been a customer FOR EACH CUSTOMER
-- you can also use MONTH & YEAR to find the month and year of the order date
select customerName, min(o.orderDate), month(min(o.orderDate)), max(o.orderDate), year(max(o.orderDate)), datediff( now() , min(o.orderDate) )
from customers c, orders o
where c.customerNumber = o.customerNumber
group by c.customerNumber -- because you want it sorted to be "for each number"
order by o.customerNumber; -- so this would show only the customers that have made an order and omit any customer that hasn't

-- HW #2 I want to know the average margin for all orders sorted by the order with the highest margin first. This includes the margin on the quantity of products sold
select o.orderNumber, avg(MSRP - buyPrice) as avg_margin -- you can no longer get * or EVERYTHING from a table and you have to remove those that are aggrigated pretty much?
from orders o, orderdetails od, products p 
where o.orderNumber = od.orderNumber
and od.productCode = p.productCode
group by o.orderNumber -- using aggrigate functions like avg() or things that put two numbers together MAKES US USE GROUP BY
order by avg_margin desc;

-- HW #3 - Extra Hard :/ - I want to see my most profitable customers by the average profit margin of all their orders (kinda builds on HW# 2)
-- IN THIS JOB, YOU'RE GOING TO GET REQUIREMENTS/SENTENCES LIKE THIS AND YOU HAVE TO TURN THAT INTO CODE
-- he has a lil more to add
-- I only care about my customers that have an average margin greater than 1800
select c.customerNumber, c.customerName, avg((MSRP - buyPrice)*quantityOrdered) as avg_margin
from orders o, orderdetails od, products p, customers c
where o.orderNumber = od.orderNumber
and od.productCode = p.productCode
and o.customerNumber = c.customerNumber -- think about how when you see the EER Diagram, you can see what variables are connecting them and link them in WHERE
group by c.customerNumber
-- the lil more part
having avg((MSRP - buyPrice)*quantityOrdered) > 1800
-- this way helps you limit something that is aggrigated rather than using GROUP BY
order by avg_margin desc;

-- 304.3.1 Slides Now
-- 32
SELECT m.employeeNumber AS ManagerID, m.lastName AS Manager,  e.lastName AS 'employee', e.employeeNumber AS EmployeeID
FROM    employees e
INNER JOIN employees m ON m.employeeNumber = e.reportsTo
ORDER BY m.employeeNumber;

-- self join
select e.lastName as employeeLastName, e.firstName as employeeFirstName, rt.lastName as reportToLastName, rt.firstName as reportToFirstName
from employees e, employees rt
where e.reportsTo is null or e.reportsTo = rt.employeeNumber;

-- fixing classicmodels to be more in line with how we will work with them
select * from payments;