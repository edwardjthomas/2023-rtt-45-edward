-- make this in a new Homework1 class
-- I want to see a list of all customers that have made a payment larger than <amount> in a particular <state>
-- Print the checkNumber, amount (formatted to $#.00 ), and the customer name ordred by the largest amount first
-- input variables for the scanner are 1) the amount and 2) 2 digit state code.

select p.checkNumber, FORMAT(p.amount, 2), c.customerName, c.state
from customers c, payments p
where c.customerNumber = p.customerNumber and p.amount > 6000 and c.state = 'CA'
order by p.amount desc;