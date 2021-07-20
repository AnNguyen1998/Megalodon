package com.web.demo.service;

import java.util.List;

import com.web.demo.entity.Bill;

public interface AdminBillServiceAn {
	List<Bill> findAllTop();

	long findCount(String date);

	String findTotalPrice(String date);
}
