package jbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * TODO: make this in a new Homework1 class
 * I want to see a list of all customers that have made a payment larger than <amount> in a particular <state>
 * Print the checkNumber, amount (formatted to $#.00 ), and the customer name ordred by the largest amount first
 * input variables for the scanner are 1) the amount and 2) 2 digit state code.
*/

public class DatabaseHomeWork1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "exppassword";

		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter an amount: ");
			Integer amountLimit = scan.nextInt();
			scan.nextLine();
			String stateInitials = scan.nextLine();
			String SelectSQL = "select p.checkNumber, FORMAT(p.amount, 2) as amount, c.customerName, c.state\r\n"
					+ "from customers c, payments p\r\n"
					+ "where c.customerNumber = p.customerNumber and p.amount > ? and c.state = ?\r\n"
					+ "order by p.amount desc;";

			Connection connection = DriverManager.getConnection(dburl, user, password);

			PreparedStatement stmt = connection.prepareStatement(SelectSQL);

			stmt.setInt(1, amountLimit);
			stmt.setString(2, stateInitials);

			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				String checkNumber = result.getString("checkNumber");
				String amount = result.getString("amount");
				String customerName = result.getString("customerName");
				String state = result.getString("state");
				System.out.println(checkNumber + ": " + amount + " " + customerName + " " + state);

			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
