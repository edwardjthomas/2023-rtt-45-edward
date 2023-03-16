package jpa.entitymodels;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import jpa.dao.CourseDAO;
import jpa.dao.StudentCourseDAO;
import jpa.dao.StudentDAO;

public class SMSRunner {
	StudentDAO studentDao = new StudentDAO();
	CourseDAO courseDao = new CourseDAO();
	StudentCourseDAO studentCourseDao = new StudentCourseDAO();

	private Scanner sin;
	private StringBuilder sb;

	private Student student;

	public SMSRunner() {
		sin = new Scanner(System.in);
		sb = new StringBuilder();
	}

	public static void main(String[] args) {
		SMSRunner sms = new SMSRunner();
		sms.run();
	}

	private void run() {
		// Login or quit
		switch (menu1()) {
		case 1:
			if (studentLogin()) {
				registerMenu();
			}
			break;
		case 2:
			out.println("Goodbye!");
			break;

		default:

		}
	}

	private int menu1() {
		sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		return sin.nextInt();
	}

	private boolean studentLogin() {

		boolean retValue = false;
		out.print("Enter your email address: ");
		String email = sin.next();
		out.print("Enter your password: ");
		String password = sin.next();

		if (email != null) {
			student = studentDao.validateStudent(email, password);
		}

		if (student != null & student.getPassword().equals(password)) {
			out.println("MyClasses");

			displayStudentCourses();

			retValue = true;
		} else {
			out.println("User Validation failed. GoodBye!");
		}
		return retValue;
	}

	// this is how i got the student courses to play nice and display depending on
	// the student id
	public void displayStudentCourses() {
		List<StudentCourse> studentcourses = studentCourseDao.getAllStudentCourses(student.getId());
		for (StudentCourse sc : studentcourses) {
			if (sc.getStudentId() == student.getId()) {
				Course course = courseDao.findById(sc.getCourseId());
				System.out.println(course.getId() + " " + course.getName() + " " + course.getInstructor());
			}

		}
	}

	@SuppressWarnings("unlikely-arg-type")
	private void registerMenu() {

		sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		switch (sin.nextInt()) {
		case 1:
			List<Course> allCourses = courseDao.getAllCourses();
			List<StudentCourse> studentCourses = studentDao.getStudentCourses(student.getId());
			allCourses.removeAll(studentCourses);
			out.printf("%5s%30S%30s\n", "ID", "Course", "Instructor");
			for (Course course : allCourses) {
				out.printf("%5d%30s%30s\n", course.getId(), course.getName(), course.getInstructor());
			}
			out.println();
			out.print("Enter Course Number: ");
			int number = sin.nextInt();
			Course newCourse = courseDao.findById(number);

			if (newCourse != null) {

				studentCourseDao.registerStudentToCourse(student, newCourse);

				out.println("MyClasses");
				displayStudentCourses();

				out.println("You have been signed out.");
			}
			break;

		case 2:
		default:
			out.println("Goodbye!");
		}

	}
}
