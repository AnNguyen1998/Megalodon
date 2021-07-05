package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.demo.entity.Games;


public interface GameRepository extends JpaRepository<Games, Integer>{

}
