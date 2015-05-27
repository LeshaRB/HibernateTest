package by.test.hibernatetest.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import by.test.hibernatetest.dao.AuthorDAO;
import by.test.hibernatetest.logic.Author;
import by.test.hibernatetest.util.HibernateUtil;

public class AuthorDAOImpl implements AuthorDAO {

	public void addAuthor(Author author) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(author);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	public void updateAuthor(Author author) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(author);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	public Author getAuthorById(Long authorID) throws SQLException {
		Session session = null;
		Author author = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			author = (Author) session.load(Author.class, authorID);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return author;
	}

	public List<Author> getAllAuthors() throws SQLException {
		Session session = null;
		List<Author> authors = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			authors = session.createCriteria(Author.class).list();
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return authors;
	}

	public void deleteAuthor(Author author) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(author);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

}
