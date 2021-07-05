package com.web.demo.service;
/**
 * @author An Nguyen
 */
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.demo.entity.Games;
import com.web.demo.repository.AdminGameRepoAn;

@Service
public class AdminGameServiceImpAn implements AdminGameServiceAn {

	@Override
	public void deleteById(Integer id) {
		game.deleteById(id);
	}

	AdminGameRepoAn game;

	public AdminGameServiceImpAn(AdminGameRepoAn game) {
		super();
		this.game = game;
	}

	@Override
	public List<Games> findAll() {

		return game.findAll();
	}

	@Override
	public <S extends Games> Games save(S entity) {
		return game.save(entity);
	}

	@Override
	public Games getById(Integer id) {
		return game.getById(id);
	}
}
