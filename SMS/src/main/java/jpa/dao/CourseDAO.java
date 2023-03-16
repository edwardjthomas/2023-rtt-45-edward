package jpa.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;

public class CourseDAO {
	/*
	 * getAllCourses();
	 * 
	 * 
	 */

	public void insert(Course course) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(course);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Course course) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(course);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Course course) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(course);
		session.getTransaction().commit();
		session.close();
	}

	public Course findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM Course c where c.id = :idParam";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("idParam", id);

		// when we know we are getting 1 record we use getSingleList (i guess that's
		// what he typed)
		try {
			Course result = query.getSingleResult();

			session.close();

			return result;
		} catch (NoResultException nre) {
			throw new NoResultException("That is not a valid Course Number. Please try again.");
		}
	}

	public void deleteById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "delete FROM Course c where c.id = :idParam";

		Query query = session.createQuery(hql);
		query.setParameter("idParam", id);

		// when we are doing an update delete insert to the database with HTL
		// we use query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();

	}

	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM Course";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		List<Course> results = query.getResultList();

		session.close();

		return results;
	}
}
