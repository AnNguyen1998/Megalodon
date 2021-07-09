package com.web.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.repository.DiscountRepositoryAn;

@Service
public class DiscountServiceImpAn implements DiscountServiceAn{
	
	@Autowired
	DiscountRepositoryAn discountRepository;
	
}
