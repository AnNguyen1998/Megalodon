package com.web.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Bill;
import com.web.demo.repository.AdminBillRepoAn;

@Service
public class AdminBillServiceImpAn implements AdminBillServiceAn {
	@Autowired
	AdminBillRepoAn bill;
	
	@Override
	public List<Bill> findAllTop() {
		
		return bill.findAllTop();
	}
	
}
