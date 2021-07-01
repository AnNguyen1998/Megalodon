package com.web.demo.service;

import com.web.demo.entity.Users;

public interface UserService {

	<S extends Users> S save(S entity);

}
