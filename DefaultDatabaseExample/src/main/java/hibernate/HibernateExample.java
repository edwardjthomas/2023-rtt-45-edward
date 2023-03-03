package hibernate;

import java.util.List;

public class HibernateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO customerDao = new CustomerDAO();
		// he.insert();
		// he.update();?

		// NOTE: we are not going to set the id column because hibernate / MYSQL will
		// automatically generate it for us
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate customer");
		customer.setContactFirstName("First Name");
		customer.setContactLastName("Last Name");
		customer.setPhone("555-555-1212");
		customer.setAddressLine1("Address Line 1");
		customer.setCity("Denver");
		customer.setState("CO");
		customer.setCountry("USA");
		customerDao.insert(customer);
		
		Customer first = customerDao.findById(497);
		System.out.println(first.toString());

		first.setAddressLine2("This is an update");
		first.setPostalCode("80023");
		first.setCreditLimit(100000.35);

		customerDao.update(first);
		customerDao.delete(first);

		List<Customer> firstNames = customerDao.findByContactFirstName("Leslie");
		for (Customer c : firstNames) {
			System.out.println(c);
		}
	}
	
	

}