package springexamples.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springexamples.database.entity.Employee;

@SpringBootTest
public class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void findWithOfficeNameTest() {
        employeeDAO.findWithOfficeName();
    }

    @Test
    public void findByIdTest() {
        Employee e = employeeDAO.findById(1002);

        Assertions.assertEquals(e.getFirstName(), "Diane");
        Assertions.assertEquals(e.getLastName(), "Murphy");

    }
}
