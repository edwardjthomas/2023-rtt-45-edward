package hibernate;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PaymentDAO {

	public void insert(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(payment);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(payment);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(payment);
		session.getTransaction().commit();
		session.close();
	}

	public Payment findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM Payment p where p.id = :idParam";

		TypedQuery<Payment> query = session.createQuery(hql, Payment.class);
		query.setParameter("idParam", id);

		// when we know we are getting 1 record we use getSingleList (i guess that's
		// what he typed)
		Payment result = query.getSingleResult();

		session.close();

		return result;
	}

	public void deleteById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "delete FROM Payment p where p.id = :idParam";

		Query query = session.createQuery(hql);
		query.setParameter("idParam", id);

		// when we are doing an update delete insert to the database with HTL
		// we use query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();

	}

	public List<Payment> findByCheckNumber(String checkNumber) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// this is HQL which is hibernate query language
		// also referred to as JPA
		String hql = "FROM Payment p where p.checkNumber = :check_number";

		TypedQuery<Payment> query = session.createQuery(hql, Payment.class);
		query.setParameter("check_number", checkNumber);

		// when we know we are getting 0 or more records we use getResultList
		List<Payment> result = query.getResultList();

		session.close();

		return result;
	}

}
