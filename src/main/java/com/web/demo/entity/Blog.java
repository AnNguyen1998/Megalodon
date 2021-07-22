package com.web.demo.entity;
// Generated Jul 5, 2021, 11:28:02 AM by Hibernate Tools 5.0.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Blog generated by hbm2java
 */
@Entity
@Table(name = "blog", catalog = "megalodondb")
public class Blog implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id_blog", unique = true, nullable = false)
	private Integer idBlog;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Author_blog", nullable = false)
	private Users users;
	@Column(name = "Views")
	private Integer viewBlog;
	@Column(name = "Title_blog", nullable = false, length = 45)
	private String titleBlog;
	@Column(name = "Content_blog", length = 65535)
	private String contentBlog;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_blog", length = 10)
	private Date dateBlog;
	@Column(name = "Image_blog", nullable = false, length = 45)
	private String imageBlog;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "blog")
	private Set<CommentBlog> commentBlogs = new HashSet<CommentBlog>(0);

	public Blog() {
	}

	public Blog(Users users, Integer viewBlog, String titleBlog, String imageBlog) {
		this.users = users;
		this.viewBlog = viewBlog;
		this.titleBlog = titleBlog;
		this.imageBlog = imageBlog;
	}

	public Blog(Users users, Integer viewBlog, String titleBlog, String contentBlog, Date dateBlog, String imageBlog) {
		this.users = users;
		this.viewBlog = viewBlog;
		this.titleBlog = titleBlog;
		this.contentBlog = contentBlog;
		this.dateBlog = dateBlog;
		this.imageBlog = imageBlog;
//		this.commentBlogs = commentBlogs;
	}


	public Integer getIdBlog() {
		return this.idBlog;
	}

	public void setIdBlog(Integer idBlog) {
		this.idBlog = idBlog;
	}


	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	
	public Integer getViewBlog() {
		return this.viewBlog;
	}

	public void setViewBlog(Integer viewBlog) {
		this.viewBlog = viewBlog;
	}

	
	public String getTitleBlog() {
		return this.titleBlog;
	}

	public void setTitleBlog(String titleBlog) {
		this.titleBlog = titleBlog;
	}

	
	public String getContentBlog() {
		return this.contentBlog;
	}

	public void setContentBlog(String contentBlog) {
		this.contentBlog = contentBlog;
	}

	
	public Date getDateBlog() {
		return this.dateBlog;
	}

	public void setDateBlog(Date dateBlog) {
		this.dateBlog = dateBlog;
	}

	
	public String getImageBlog() {
		return this.imageBlog;
	}

	public void setImageBlog(String imageBlog) {
		this.imageBlog = imageBlog;
	}


	public Set<CommentBlog> getCommentBlogs() {
		return this.commentBlogs;
	}

	public void setCommentBlogs(Set<CommentBlog> commentBlogs) {
		this.commentBlogs = commentBlogs;
	}

}
