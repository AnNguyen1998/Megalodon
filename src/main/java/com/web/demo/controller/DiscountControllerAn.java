package com.web.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.demo.entity.Discount;
import com.web.demo.entity.Games;
import com.web.demo.service.DiscountServiceAn;

@Controller
public class DiscountControllerAn {
	
	@Autowired
	DiscountServiceAn discounts;
	
	@RequestMapping(value = "/savediscount", method = RequestMethod.POST)
	public String savegame(@ModelAttribute("discount") Discount discount) {
		discounts.save(discount);
		return "redirect:/admin/addgame";
	}
}
