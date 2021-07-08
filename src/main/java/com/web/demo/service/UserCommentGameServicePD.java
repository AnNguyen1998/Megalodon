package com.web.demo.service;
import java.util.List;

import com.web.demo.entity.CommentGame;
import com.web.demo.entity.ReplyCommentGame;

public interface UserCommentGameServicePD {
	public List<CommentGame> getCommentGame(int idGame);
	public List<ReplyCommentGame> getUserReplyComment(int idCommentGame);
}
