package jpa.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourse;

public class StudentDAO {
	/*
	 * getAllStudents();
	 * 
	 * getStudentByEmail();
	 * 
	 * validateStudent();
	 * 
	 * registerStudentToCourse();
	 * 
	 * getStudentCourses();
	 */

	public void insert(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(student);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}

	public Student findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM Student s where s.id = :idParam";

		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("idParam", id);

		// when we know we are getting 1 record we use getSingleList (i guess that's
		// what he typed)
		Student result = query.getSingleResult();

		session.close();

		return result;
	}

	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM Student";

		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		List<Student> results = query.getResultList();

		session.close();

		return results;
	}

	public Student getStudentByEmail(String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM Student s where s.email = :email";

		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("email", email);

		// when we know we are getting 1 record we use getSingleList (i guess that's
		// what he typed)
		Student result = query.getSingleResult();

		session.close();

		return result;
	}

	public Student validateStudent(String email, String password) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM Student s where s.email = :email AND s.password = :password";

		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("email", email);
		query.setParameter("password", password);

		try {
			Student result = query.getSingleResult();

			session.close();

			return result;
		} catch (NoResultException nre) {
			System.out.println("That is not a valid email or password. Please attempt to log in again.");
			throw new NoResultException("That is not a valid email or password. Please attempt to log in again.");
		} catch (NonUniqueResultException nure) {
			return null;
		}
	}

	public List<StudentCourse> getStudentCourses(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM StudentCourse sc where studentid = :idParam";

		TypedQuery<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
		query.setParameter("idParam", id);
		List<StudentCourse> results = query.getResultList();

		session.close();

		return results;
	}

	public void deleteById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "delete FROM Student s where s.id = :idParam";

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
