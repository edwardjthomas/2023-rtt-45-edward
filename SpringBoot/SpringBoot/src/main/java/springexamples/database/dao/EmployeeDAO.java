package springexamples.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springexamples.database.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    // this is a JPA hibernate query

    @Query("FROM Employee e")
    List<Employee> getAllEmployees();

    // let's hook a search
    // we're going to use a native query here
    // the name of the String firstName has to match the one in Employee
    // springboot will sort out all the rest
    // do you see how long this is? and how little we've typed?

    List<Employee> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName);

    List<Employee> findByFirstNameContainingIgnoreCase(String firstsearch);

    List<Employee> findByLastNameContainingIgnoreCase(String lastsearch);



    // challenges because of course
    // write a native query in workbench that will be
    // findByFirstNameContainingOrLastNameContainingIgnoreCase
    // Change your Controller to use your native query
    // if you're in a team where the database will not change, it's okay to use a
    // native query

    // challenge one
    @Query(value = "SELECT * FROM employees WHERE lower(firstname) LIKE %:firstName% OR lower(lastname) LIKE %:lastName% ;", nativeQuery = true)
    List<Employee> usingNativeQuery(String firstName, String lastName);

    // same challenge above but make a JPA query
    @Query(value = "SELECT e FROM Employee e WHERE lower(e.firstName) LIKE %:firstName% OR lower(e.lastName) LIKE %:lastName% ")
    List<Employee> usingJPAQuery(String firstName, String lastName);

}
