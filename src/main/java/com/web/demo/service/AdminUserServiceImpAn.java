package com.web.demo.service;
/**
 * @author An Nguyen
 */
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.demo.entity.Users;
import com.web.demo.repository.AdminUserRepoAn;

@Service
public class AdminUserServiceImpAn implements AdminUserServiceAn {

	@Override
	public void deleteById(Integer id) {
		user.deleteById(id);
	}

	AdminUserRepoAn user;

	public AdminUserServiceImpAn(AdminUserRepoAn users) {
		super();
		this.user = users;
	}

	@Override
	public List<Users> findAll() {

		return user.findAll();
	}

	@Override
	public <S extends Users> S save(S entity) {
		return user.save(entity);
	}

	@Override

	public Users getById(Integer id) {
		return user.getById(id);
	}
}
