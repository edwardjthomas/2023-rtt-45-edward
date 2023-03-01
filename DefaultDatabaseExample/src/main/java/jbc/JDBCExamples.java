package jbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCExamples {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "exppassword";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		try {
			// TODO: create a new scanner and read the first name into the variable
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter an amount: ");
			Integer amount = scan.nextInt();
			String SelectSQL = "select c.customerNumber, c.customerName, avg((MSRP - buyPrice)*quantityOrdered) as avg_margin\r\n"
					+ "from orders o, orderdetails od, products p, customers c\r\n"
					+ "where o.orderNumber = od.orderNumber\r\n" + "and od.productCode = p.productCode\r\n"
					+ "and o.customerNumber = c.customerNumber -- think about how when you see the EER Diagram, you can see what variables are connecting them and link them in WHERE\r\n"
					+ "group by c.customerNumber\r\n" + "-- the lil more part\r\n"
					+ "having avg((MSRP - buyPrice)*quantityOrdered) > ?\r\n"
					+ "-- this way helps you limit something that is aggrigated rather than using GROUP BY\r\n"
					+ "order by avg_margin desc";

			// smaller string query example
//			System.out.print("Please input a First Name or a Last Name: ");
//			String name = scan.nextLine();
			
			// Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);

			// smaller string query example
//			String SelectSQL = "Select * FROM employees where firstName = ? or lastName = ?";
//
//			// this is a JDBC class that creates the statement which will in turn run the
//			// SQL
//			// you never use this kind of statement
//			// Statement stmt = connection.createStatement();
//			
//			// You'd sooner use this.
//			// using a prepared statement protects and prevents SQL Injection attacks
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);

			// smaller string query example			
			// this is 1 based so the first ? is #1
//			stmt.setString(1, name);
//			stmt.setString(2, name);

			stmt.setInt(1, amount);

			// using the statement to execute a query and put the result into the ResultSet
			// object
			ResultSet result = stmt.executeQuery();

			// loop over the result set.
			while (result.next()) {
				String customerNumber = result.getString("customerNumber");
				String customerName = result.getString("customerName");
				String averageMargin = result.getString("avg_margin");
				
				// smaller string query example
//				String EmployeeID = result.getString("employeeNumber");
//				String fname = result.getString("firstName");
//				String lname = result.getString("lastName");
//				String email = result.getString("email");
//				System.out.println(EmployeeID + " | " + fname + " | " + lname + " | " + email);
				System.out.println(customerNumber + ": " + averageMargin + " " + customerName);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
