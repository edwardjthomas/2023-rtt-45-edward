package hibernate;

// TODO
//Blockbuster Video Rental
//Create 3 tables each with its own PK and appropriate FKs : User, Movie, and Movie Rental
//create a schema and the tables and FKs using workbench and set hibernate to validate
//use business sense to figure out data types and which columns should be not null and default values
//create a hibernate.cfg.xml
//user table : first name, last name, email, password, create date (TIMESTAMP) @Temporal
//movie table : name, year released, rating, and rental price, late fee
//movie rental table : movie id, user id, checkout date (TIMESTAMP), check in date (TIMESTAMP)
//add 2 movies and 2 users to the database with an SQL insert statement in workbench
//can add another 1 or 2 user and move using hibernate
//create a changePassword( UserId, Password ) function that updates the user ( not in the DAO )
//create a checkOut( Movie, User ) and checkIn ( Movie, User ) ( not in the DAO )
//create a function that will show the list movies that are checked out and the users that have them checked out ( not in the DAO )
//BONUS .. add a due date to the movie rental table and a function double calculateLateFee(User, Movie, FutureDate)
// Something Else: hook it up to a menu with the scanner (kinda like coffee shop?)

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
