package by.test.hibernatetest.dao;

import java.sql.SQLException;
import java.util.List;

import by.test.hibernatetest.logic.Website;

public interface WebsiteDAO {
	public void addWebsite(Website Website) throws SQLException;

	public void updateWebsite(Website Website) throws SQLException;

	public void deleteWebsite(Website Website) throws SQLException;

	public Website getWebsiteById(Long WebsiteID) throws SQLException;

	public List<Website> getAllWebsites() throws SQLException;
}
