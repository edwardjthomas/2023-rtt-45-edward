select p.productName as 'Name', p.productLine as 'Product Line', p.buyPrice as 'Buy Price'
from products p
order by p.buyPrice desc;

select c.contactFirstName as 'First Name', c.contactLastName as 'Last Name', c.city as 'City'
from customers c
order by c.contactLastName asc;

select o.orderDate, o.requiredDate, o.shippedDate, o.status, o.comments, o.customerNumber
from orders o
order by o.orderDate asc;

select *
from payments p
where p.paymentDate >= '2005-01-01'
order by p.paymentDate desc;

select e.lastName, e.firstName, e.email, e.jobTitle
from employees e
where e.officeCode = 1
order by e.lastName;

select productName, productLine, productScale, productVendor
from products
where productLine = "Vintage Cars" or productLine = "Classic Cars"
order by productName asc;