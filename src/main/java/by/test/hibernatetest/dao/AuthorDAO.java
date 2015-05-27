package by.test.hibernatetest.dao;

import java.sql.SQLException;
import java.util.List;

import by.test.hibernatetest.logic.Author;

public interface AuthorDAO {
	public void addAuthor(Author author) throws SQLException;

	public void updateAuthor(Author author) throws SQLException;

	public void deleteAuthor(Author author) throws SQLException;

	public Author getAuthorById(Long authorID) throws SQLException;

	public List<Author> getAllAuthors() throws SQLException;
}
