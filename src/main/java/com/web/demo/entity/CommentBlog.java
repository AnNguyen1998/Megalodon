package com.web.demo.entity;
// Generated Jul 5, 2021, 11:28:02 AM by Hibernate Tools 5.0.6.Final

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

/**
 * CommentBlog generated by hbm2java
 */
@Entity
@Table(name = "comment_blog", catalog = "megalodondb")
public class CommentBlog implements java.io.Serializable {

	private Integer idCommnetBlog;
	private Blog blog;
	private Users users;
	private String contentCommentBlog;
	private String nameUser;
//	private Set<ReplyCommentBlog> replyCommentBlogs = new HashSet<ReplyCommentBlog>(0);

	public CommentBlog() {
	}

	public CommentBlog(Blog blog, String nameUser) {
		this.blog = blog;
		this.nameUser = nameUser;
	}

	public CommentBlog(Blog blog, Users users, String contentCommentBlog, String nameUser) {
		this.blog = blog;
		this.users = users;
		this.contentCommentBlog = contentCommentBlog;
		this.nameUser = nameUser;
//		this.replyCommentBlogs = replyCommentBlogs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id_commnet_blog", unique = true, nullable = false)
	public Integer getIdCommnetBlog() {
		return this.idCommnetBlog;
	}

	public void setIdCommnetBlog(Integer idCommnetBlog) {
		this.idCommnetBlog = idCommnetBlog;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_blog", nullable = false)
	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_users")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "Content_comment_blog", length = 65535)
	public String getContentCommentBlog() {
		return this.contentCommentBlog;
	}

	public void setContentCommentBlog(String contentCommentBlog) {
		this.contentCommentBlog = contentCommentBlog;
	}

	@Column(name = "Name_user", nullable = false, length = 45)
	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commentBlog")
//	public Set<ReplyCommentBlog> getReplyCommentBlogs() {
//		return this.replyCommentBlogs;
//	}
//
//	public void setReplyCommentBlogs(Set<ReplyCommentBlog> replyCommentBlogs) {
//		this.replyCommentBlogs = replyCommentBlogs;
//	}

}
