package jpa.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourse;

public class StudentCourseDAO {

	public void insert(StudentCourse studentCourse) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		try {
			session.save(studentCourse);
			session.getTransaction().commit();
			session.close();
		} catch (NoResultException nre) {
			System.out.println("That is not a valid course id. Please try again.");
		} catch (NonUniqueObjectException nuoe) {
			System.out.println("You're already registered for this course.");
		}
	}

	public void update(StudentCourse studentCourse) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(studentCourse);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(StudentCourse studentCourse) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(studentCourse);
		session.getTransaction().commit();
		session.close();
	}

	public StudentCourse findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM StudentCourse sc where sc.id = :idParam";

		TypedQuery<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
		query.setParameter("idParam", id);

		// when we know we are getting 1 record we use getSingleList (i guess that's
		// what he typed)
		StudentCourse result = query.getSingleResult();

		session.close();

		return result;
	}

	public List<StudentCourse> getAllStudentCourses(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM StudentCourse where studentid = :idParam";

		TypedQuery<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
		query.setParameter("idParam", id);
		List<StudentCourse> results = query.getResultList();

		session.close();

		return results;
	}

	public List<StudentCourse> getAllStudentCourse() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM StudentCourse";

		TypedQuery<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
		List<StudentCourse> results = query.getResultList();

		session.close();

		return results;
	}

	public void registerStudentToCourse(Student student, Course course) {
		StudentCourse sc = new StudentCourse();

		sc.setStudent(student);
		sc.setCourse(course);

		insert(sc);

		student.getStudentcourse().add(sc);
		course.getStudentcourse().add(sc);

	}

	public void deleteById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "delete FROM StudentCourse sc where sc.id = :idParam";

		Query query = session.createQuery(hql);
		query.setParameter("idParam", id);

		// when we are doing an update delete insert to the database with HTL
		// we use query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();

	}

}
