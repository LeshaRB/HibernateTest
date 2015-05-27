package by.test.hibernatetest.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import by.test.hibernatetest.dao.WebsiteDAO;
import by.test.hibernatetest.logic.Website;
import by.test.hibernatetest.util.HibernateUtil;

public class WebsiteDAOImpl implements WebsiteDAO {

	public void addWebsite(Website website) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(website);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	public void updateWebsite(Website website) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(website);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	public Website getWebsiteById(Long websiteID) throws SQLException {
		Session session = null;
		Website website = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			website = (Website) session.get(Website.class, websiteID);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return website;
	}

	public List<Website> getAllWebsites() throws SQLException {
		Session session = null;
		List<Website> websites = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			websites = session.createCriteria(Website.class).list();
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return websites;
	}

	public void deleteWebsite(Website website) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(website);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

}
