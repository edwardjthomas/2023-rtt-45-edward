package hibernate;

import java.util.List;

public class OneToManyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();

		Employee e = employeeDao.findById(1166);
		System.out.println(e);

		for (Customer customer : e.getCustomers()) {
			System.out.println(customer);
		}
		
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate customer");
		customer.setContactFirstName("First Name");
		customer.setContactLastName("Last Name");
		customer.setPhone("555-555-1212");
		customer.setAddressLine1("Address Line 1");
		customer.setCity("Denver");
		customer.setState("CO");
		customer.setCountry("USA");
		customer.setEmployee(e);
		//customerDao.insert(customer);
		
		e.getCustomers().add(customer);
		employeeDao.update(e);
	}
}
