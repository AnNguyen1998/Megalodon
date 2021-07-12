package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.ImageData;

@Repository
public interface GameImageRepository extends JpaRepository<ImageData, Integer>{

}
