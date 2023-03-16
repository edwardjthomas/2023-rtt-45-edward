package jpa.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import jpa.entitymodels.Student;

public class StudentDAOTest {

	private static StudentDAO studentDao;

	// you probably wouldn't just create an object like this in a beforeall. only if
	// you're looking to use the same word or object to test.
	@BeforeAll
	public static void setUp() {
		studentDao = new StudentDAO();
	}

	@Test
	public void getStudentByEmailTest() {
		// you wouldn't need it any more because it's being definied inside private
		// static above
		// CustomerDAO customerDao = new CustomerDAO();

		// given
		Student expected = new Student();
		expected.setEmail("boy@yahoo.com");

		// when
		Student actual = studentDao.getStudentByEmail("boy@yahoo.com");

		// then
		Assertions.assertEquals(expected.getEmail(), actual.getEmail());
	}

	@ParameterizedTest
	@CsvSource({ "1,boy@yahoo.com,Boy Howdy,123456" })
	public void findByIdParameterizedTest(ArgumentsAccessor args) {

		// given
		Student expected = new Student();
		expected.setEmail(args.getString(1));
		expected.setName(args.getString(2));
		expected.setPassword(args.getString(3));

		// when
		Student actual = studentDao.findById(args.getInteger(0));

		// then
		Assertions.assertEquals(expected.getEmail(), actual.getEmail());
		Assertions.assertEquals(expected.getName(), actual.getName());
		Assertions.assertEquals(expected.getPassword(), actual.getPassword());

	}

}
