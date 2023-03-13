package hibernate;

// this shows us how to do a JUnit test
// these tests technically suck but it shows us the BASICS and that's what we need to know

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class CustomerDAOTest {

	private static CustomerDAO customerDao;

	// you probably wouldn't just create an object like this in a beforeall. only if
	// you're looking to use the same word or object to test.
	@BeforeAll
	public static void setUp() {
		customerDao = new CustomerDAO();
	}

	@Test
	public void findByIdTest() {
		// you wouldn't need it any more because it's being definied inside private
		// static above
		// CustomerDAO customerDao = new CustomerDAO();

		// given
		Customer expected = new Customer();
		expected.setCustomerName("Atelier graphique");
		expected.setContactLastName("Schmitt");
		expected.setContactFirstName("Carine");

		// when
		Customer actual = customerDao.findById(103);

		// then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstName(), actual.getContactFirstName());
		Assertions.assertEquals(expected.getContactLastName(), actual.getContactLastName());
	}

	@ParameterizedTest
	@CsvSource({ "103,Atelier graphique,Schmitt,Carine", "112,Signal Gift Stores,King,Jean" })
	public void findByIdParameterizedTest(ArgumentsAccessor args) {
	
		// given
		Customer expected = new Customer();
		expected.setCustomerName(args.getString(1));
		expected.setContactLastName(args.getString(2));
		expected.setContactFirstName(args.getString(3));

		// when
		Customer actual = customerDao.findById(args.getInteger(0));

		// then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstName(), actual.getContactFirstName());
		Assertions.assertEquals(expected.getContactLastName(), actual.getContactLastName());
	}

	@Test
	public void checkinTest() {
		// given
		// MovieRental record with the correct values set

		// when
		// query for the user
		// query for the movie
		// run the checkin function returns the movie record that was created

		// then
		// assert the movie record = expected
	}
}
