package by.test.hibernatetest;

import java.sql.SQLException;
import java.util.List;

import by.test.hibernatetest.dao.AuthorDAO;
import by.test.hibernatetest.dao.BookDAO;
import by.test.hibernatetest.dao.WebsiteDAO;
import by.test.hibernatetest.logic.Author;
import by.test.hibernatetest.logic.Book;
import by.test.hibernatetest.logic.Website;
import by.test.hibernatetest.util.HibernateUtil;

public class App {
	private static void addROWS(AuthorDAO authorDAO, BookDAO bookDAO) throws SQLException {
		for (int i = 0; i < 5; i++) {
			Book book = new Book();
			book.getBookinfo().setDescription("Description " + i);
			book.getBookinfo().setTitle("Title " + i);
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
		WebsiteDAO websiteDAO = factory.getWebsiteDAO();

		try {
			// addROWS(authorDAO, bookDAO);
			readROWS(authorDAO, bookDAO, websiteDAO);

			System.out.println("===========================================");
			Author author = authorDAO.getAuthorById(Long.valueOf("1"));
			System.out.println(author.getWebsite().getUrl());
			for (Book book : author.getBooks()) {
				System.out.println(book.getBookinfo().getTitle());
			}

			System.out.println("===========================================");
			Book book = bookDAO.getBookById(Long.valueOf("2"));
			System.out.println(book.getBookinfo().getTitle());
			for (Author authorN : book.getAuthors()) {
				System.out.println(authorN.getFio());
			}

			System.out.println("===========================================");
			Website website = websiteDAO.getWebsiteById(Long.valueOf("1"));
			System.out.println(website.getAuthor().getFio());

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		HibernateUtil.closeSessionFactory();
	}

	private static void readROWS(AuthorDAO authorDAO, BookDAO bookDAO, WebsiteDAO websiteDAO) throws SQLException {
		System.out.println("===========================================");
		List<Author> authors = authorDAO.getAllAuthors();
		for (Author author : authors) {
			System.out.println("ID = " + author.getId() + " FIO = " + author.getFio());
		}
		System.out.println("===========================================");
		List<Book> books = bookDAO.getAllBooks();
		for (Book book : books) {
			System.out.println("ID = " + book.getId() + " TITLE = " + book.getBookinfo().getTitle() + " DESCRIPTION = "
					+ book.getBookinfo().getDescription());
		}
		System.out.println("===========================================");
		List<Website> websites = websiteDAO.getAllWebsites();
		for (Website website : websites) {
			System.out.println("ID = " + website.getId() + " URL = " + website.getUrl());
		}
	}
}
