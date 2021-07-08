package com.web.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.demo.entity.ReplyCommentGame;

/*
 * 
 * @author PhatDat
 */
@Repository
public interface ReplyCommentGameRepoPD extends JpaRepository<ReplyCommentGame,Integer>{

}
