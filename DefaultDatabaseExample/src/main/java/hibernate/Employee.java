package hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	private Integer id;
	
	private String lastName;
	
	private String firstName;
	
	private String extension;
	
	private String email;
	
	private String officeCode;
	
	private Integer reportsTo;
	
	private String jobTitle;
	
	private Integer vacationHours;


}
