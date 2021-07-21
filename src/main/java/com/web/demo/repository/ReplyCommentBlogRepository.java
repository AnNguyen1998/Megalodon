package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.ReplyCommentBlog;

@Repository
public interface ReplyCommentBlogRepository extends JpaRepository<ReplyCommentBlog, Integer>{

}
