package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.CommentBlog;

@Repository
public interface BlogCommentDatHa extends JpaRepository<CommentBlog, Integer>{

}
