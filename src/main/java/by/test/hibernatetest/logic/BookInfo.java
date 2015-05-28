package by.test.hibernatetest.logic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookInfo implements Serializable {

	private static final long serialVersionUID = -5677294360400139156L;

	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
