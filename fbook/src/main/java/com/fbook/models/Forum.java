package com.fbook.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Forum {
	
	@Id
	@SequenceGenerator(name="frum_seq", initialValue=1001, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="frum_seq")
	private int forumId;
	@Column(name="forumName")
	private String forumName;
	@Column(name="forumData")
	private String forumData;
	@Column(name="createdDate")
	private Date createdDate;
	@Column(name="author")
	private String author;
	
	public Forum(int forumId, String forumName, Date createdDate, String author) {
		super();
		this.forumId = forumId;
		this.forumName = forumName;
		this.createdDate = createdDate;
		this.author = author;
	}
	public Forum(){}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getForumData() {
		return forumData;
	}

	public void setForumData(String forumData) {
		this.forumData = forumData;
	}
	
	
}
