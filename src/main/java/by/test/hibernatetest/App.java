package by.test.hibernatetest;

import java.sql.SQLException;
import java.util.List;

import by.test.hibernatetest.dao.AuthorDAO;
import by.test.hibernatetest.dao.BookDAO;
import by.test.hibernatetest.logic.Author;
import by.test.hibernatetest.logic.Book;
import by.test.hibernatetest.util.HibernateUtil;

public class App {
	private static void addROWS(AuthorDAO authorDAO, BookDAO bookDAO)
			throws SQLException {
		for (int i = 0; i < 5; i++) {
			Book book = new Book();
			book.setDescription("Description " + i);
			book.setTitle("Title " + i);
			bookDAO.addBook(book);
		}
		for (int i = 0; i < 5; i++) {
			Author author = new Author();
			author.setFio("FIO " + i);
			authorDAO.addAuthor(author);
		}
	}

	public static void main(String[] args) {
		Factory factory = Factory.getInstance();
		AuthorDAO authorDAO = factory.getAuthorDAO();
		BookDAO bookDAO = factory.getBookDAO();

		try {
			addROWS(authorDAO, bookDAO);
			readROWS(authorDAO, bookDAO);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		HibernateUtil.closeSessionFactory();
	}

	private static void readROWS(AuthorDAO authorDAO, BookDAO bookDAO)
			throws SQLException {
		System.out.println("===========================================");
		List<Author> authors = authorDAO.getAllAuthors();
		for (Author author : authors) {
			System.out.println("ID = " + author.getId() + " FIO = "
					+ author.getFio());
		}
		System.out.println("===========================================");
		List<Book> books = bookDAO.getAllBooks();
		for (Book book : books) {
			System.out.println("ID = " + book.getId() + " TITLE = "
					+ book.getTitle() + " DESCRIPTION = "
					+ book.getDescription());
		}
	}
}
