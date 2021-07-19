package com.web.demo.service;

import java.util.List;

import com.web.demo.entity.ReplyCommentGame;

public interface ReplyCommentGameServicePD {
	public ReplyCommentGame addReplyCommentGame(int idCommentGame, int idUser, String repCmt);
	public List<ReplyCommentGame> getReplyCommentGame(int idGame);
}
