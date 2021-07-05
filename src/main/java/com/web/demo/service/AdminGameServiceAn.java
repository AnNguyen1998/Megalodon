package com.web.demo.service;
/**
 * @author An Nguyen
 */
import java.util.List;

import com.web.demo.entity.Games;

public interface AdminGameServiceAn {
	List<Games> findAll();

	<S extends Games> Games save(S entity);

	Games getById(Integer id);

	void deleteById(Integer id);
}
