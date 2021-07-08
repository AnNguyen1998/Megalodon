package com.web.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.demo.entity.CommentGame;
import com.web.demo.entity.ReplyCommentGame;
import com.web.demo.repository.CommentGameRepositoryPD;
import com.web.demo.repository.DiscountRepositoryPD;
import com.web.demo.repository.ReplyCommentGameRepoPD;

/*
 * @author PhatDat
 */
@Service
public class UserCommentGameServiceImpPD implements UserCommentGameServicePD{
	@Autowired
	CommentGameRepositoryPD cmtGameRepo;
	@Autowired
	ReplyCommentGameRepoPD repCmtGameRepo;
	
	@Override
	public List<CommentGame> getCommentGame(int idGame) {
		return cmtGameRepo.findCommentGames(idGame);
	}

	@Override
	public List<ReplyCommentGame> getUserReplyComment(int idCommentGame) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
