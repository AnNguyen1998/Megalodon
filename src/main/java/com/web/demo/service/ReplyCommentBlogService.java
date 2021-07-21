package com.web.demo.service;

import com.web.demo.entity.ReplyCommentBlog;

public interface ReplyCommentBlogService {

	<S extends ReplyCommentBlog> S save(S entity);

}
