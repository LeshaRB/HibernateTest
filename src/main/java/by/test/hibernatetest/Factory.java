package by.test.hibernatetest;

import by.test.hibernatetest.dao.AuthorDAO;
import by.test.hibernatetest.dao.BookDAO;
import by.test.hibernatetest.dao.impl.AuthorDAOImpl;
import by.test.hibernatetest.dao.impl.BookDAOImpl;

public class Factory {

	private static Factory instance;
	private AuthorDAO authorDAO;
	private BookDAO bookDAO;

	private Factory() {
	}

	public static synchronized Factory getInstance() {
		if (instance == null)
			instance = new Factory();
		return instance;
	}

	public AuthorDAO getAuthorDAO() {
		if (authorDAO == null)
			authorDAO = new AuthorDAOImpl();
		return authorDAO;
	}

	public BookDAO getBookDAO() {
		if (bookDAO == null)
			bookDAO = new BookDAOImpl();
		return bookDAO;
	}
}
