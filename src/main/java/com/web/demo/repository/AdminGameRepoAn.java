package com.web.demo.repository;
/**
 * @author An Nguyen
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.web.demo.entity.Games;

public interface AdminGameRepoAn extends JpaRepository<Games, Integer>{

}
