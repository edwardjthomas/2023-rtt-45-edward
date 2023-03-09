package hibernate;

import java.util.Calendar;
import java.util.Date;

public class OneToManyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		PaymentDAO paymentDao = new PaymentDAO();
		OrderDAO orderDao = new OrderDAO();
		ProductDAO productDao = new ProductDAO();
		OrderDetailDAO orderDetailDao = new OrderDetailDAO();

		// printing employee 1166 info
//		Employee e = employeeDao.findById(1166);
//		System.out.println(e);
//
//		for (Customer customer : e.getCustomers()) {
//			System.out.println(customer);
//		}

		// adding a customer
//		Customer customer = new Customer();
//		customer.setCustomerName("Hibernate customer");
//		customer.setContactFirstName("First Name");
//		customer.setContactLastName("Last Name");
//		customer.setPhone("555-555-1212");
//		customer.setAddressLine1("Address Line 1");
//		customer.setCity("Denver");
//		customer.setState("CO");
//		customer.setCountry("USA");
//		customer.setEmployee(e);
//		//customerDao.insert(customer);
//		
//		e.getCustomers().add(customer);
//		employeeDao.update(e);

		// an aside of messing around with dates and time
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.add(Calendar.DATE, -30);
//		Date dateBefore30Days = cal.getTime();
//		System.out.println("is date before " + dateBefore30Days.before(new Date()));

//		Payment payment = new Payment();
//		payment.setAmount(5000.00);
//		payment.setPaymentDate(new Date());
//		payment.setCustomer(customer);
//		payment.setCheckNumber("12345");
//		customer.getPayments().add(payment);
//		customerDao.update(customer);

		// find the customer id and print it out
//		System.out.println(productDao.findById(2));
//		Customer c = customerDao.findById(527);
//		System.out.println(c);

//		// for all of order and get orders of the id found, print out all orders
//		for( Order o : c.getOrders()) {
//			System.out.println(o);
//		}

		// insert into order
//		Order order = new Order();
//		order.setOrderDate(new Date());
//		order.setRequiredDate(new Date());
//		order.setStatus("Memed");
//		order.setCustomer(c);
//		order.setComments("You just got memed");
//
//		orderDao.insert(order);
//		c.getOrders().add(order);
//		customerDao.update(c);

		//	inserting for orderdetails
//		OrderDetail od1 = new OrderDetail();
//		Product prod = productDao.findById(111);	// meme car
//		Order ord = orderDao.findById(10426);		// hello
//		od1.setOrderLineNumber(3);
//		od1.setPriceEach(45.00);
//		od1.setQuantityOrdered(75);
//		od1.setProduct(prod);
//		od1.setOrder(ord);
//		od1.setProductId(111);
//		od1.setOrderId(10426);
//		orderDetailDao.insert(od1);
//		
//		prod.getOrderDetail().add(od1);
//		ord.getOrderDetail().add(od1);
//		
//		productDao.update(prod);
//		orderDao.update(ord);
		
		// inserting into product
//		Product product = new Product();
//		product.setProductCode("Hello");
//		product.setProductName("MemeCar");
//		product.setProductLineId(2);
//		product.setProductScale("Big");
//		product.setProductVendor("Pepsi");
//		product.setProductDescription("It's really great");
//		product.setQuantityInStock(1);
//		product.setBuyPrice(69.00);
//		product.setMsrp(420.00);
		
//		productDao.insert(product);
		
//		for (OrderDetail od : order1.getOrderDetail()) {
//			System.out.println(od);
//		}
//		Order o = orderDao.findById(10101);
//		System.out.println(o.toString());

	}
}