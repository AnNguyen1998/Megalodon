package com.web.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.Bill;

@Repository
public interface AdminBillRepoAn extends JpaRepository<Bill, Integer> {
	@Query(value="SELECT *, COUNT(*) FROM bill GROUP BY Id_users ORDER BY COUNT(*) DESC LIMIT 5", nativeQuery = true)
	List<Bill> findAllTop();
}
