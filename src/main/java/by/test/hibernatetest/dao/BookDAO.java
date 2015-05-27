package by.test.hibernatetest.dao;

import java.sql.SQLException;
import java.util.List;

import by.test.hibernatetest.logic.Book;

public interface BookDAO {
	public void addBook(Book book) throws SQLException;

	public void updateBook(Book book) throws SQLException;

	public void deleteBook(Book book) throws SQLException;

	public Book getBookById(Long bookID) throws SQLException;

	public List<Book> getAllBooks() throws SQLException;
}
