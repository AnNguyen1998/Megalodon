package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.ImageData;

/*
 * 
 * @author PhatDat
 */
@Repository
public interface ImageDataRepositoryPD extends JpaRepository<ImageData, Integer>{

}
