package by.test.hibernatetest.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import by.test.hibernatetest.dao.BookDAO;
import by.test.hibernatetest.logic.Book;
import by.test.hibernatetest.util.HibernateUtil;

public class BookDAOImpl implements BookDAO {
	public void addBook(Book book) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	public void updateBook(Book book) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(book);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	public Book getBookById(Long bookID) throws SQLException {
		Session session = null;
		Book book = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			book = (Book) session.load(Book.class, bookID);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return book;
	}

	public List<Book> getAllBooks() throws SQLException {
		Session session = null;
		List<Book> books = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			books = session.createCriteria(Book.class).list();
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return books;
	}

	public void deleteBook(Book book) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(book);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}
