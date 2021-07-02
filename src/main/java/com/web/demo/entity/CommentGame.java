package com.web.demo.entity;
// Generated Jun 29, 2021, 8:56:47 AM by Hibernate Tools 5.0.6.Final

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
 * CommentGame generated by hbm2java
 */
@Entity
@Table(name = "comment_game", catalog = "megalodondb")
public class CommentGame implements java.io.Serializable {

	private Integer idCommentGame;
	private Games games;
	private Users users;
	private String contentCommentGame;
	private Set<ReplyCommentGame> replyCommentGames = new HashSet<ReplyCommentGame>(0);

	public CommentGame() {
	}

	public CommentGame(Games games, Users users, String contentCommentGame, Set<ReplyCommentGame> replyCommentGames) {
		this.games = games;
		this.users = users;
		this.contentCommentGame = contentCommentGame;
		this.replyCommentGames = replyCommentGames;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id_comment_game", unique = true, nullable = false)
	public Integer getIdCommentGame() {
		return this.idCommentGame;
	}

	public void setIdCommentGame(Integer idCommentGame) {
		this.idCommentGame = idCommentGame;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_game")
	public Games getGames() {
		return this.games;
	}

	public void setGames(Games games) {
		this.games = games;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_users")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "Content_comment_game", length = 150)
	public String getContentCommentGame() {
		return this.contentCommentGame;
	}

	public void setContentCommentGame(String contentCommentGame) {
		this.contentCommentGame = contentCommentGame;
	}

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "commentGame")
//	public Set<ReplyCommentGame> getReplyCommentGames() {
//		return this.replyCommentGames;
//	}

	public void setReplyCommentGames(Set<ReplyCommentGame> replyCommentGames) {
		this.replyCommentGames = replyCommentGames;
	}

}
