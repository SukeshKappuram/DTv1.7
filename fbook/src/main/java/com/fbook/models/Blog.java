package com.fbook.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Blog {
	
	@Id
	@SequenceGenerator(name="blog_seq", initialValue=1001, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="blog_seq")
	private int blogId;
	@NotNull
	@Size(min = 6, max = 14, message="can not be Empty")
	@Pattern(regexp="[A-Za-z]+", message="Should only contain Alpha")
	@Column(name="blogName")
	private String blogName;
	@NotNull
	@Size(min = 20, max = 160, message="can not be Empty")
	@Column(name="blogData")
	private String blogData;
	@NotNull
	@Size(min = 6, max = 14, message="can not be Empty")
	@Column(name="blogType")
	private String blogType;
	@NotNull
	@Column(name="createdDate")
	private Date createdDate;
	@NotNull
	@Column(name="author")
	private Integer authorId;
	
	public Blog(int blogId, String blogName, Date createdDate, int authorId) {
		super();
		this.blogId = blogId;
		this.blogName = blogName;
		this.createdDate = createdDate;
		this.authorId = authorId;
	}
	
	public Blog(){}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getBlogType() {
		return blogType;
	}

	public void setBlogType(String blogType) {
		this.blogType = blogType;
	}

	public String getBlogData() {
		return blogData;
	}

	public void setBlogData(String blogData) {
		this.blogData = blogData;
	}
	
	

}
