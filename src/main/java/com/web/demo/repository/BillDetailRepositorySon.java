package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.BillDetail;

@Repository
public interface BillDetailRepositorySon extends JpaRepository<BillDetail, Integer>{

	
}
