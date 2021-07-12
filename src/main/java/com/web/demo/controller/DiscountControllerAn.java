package com.web.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.web.demo.entity.Discount;
import com.web.demo.service.DiscountServiceAn;

@Controller
public class DiscountControllerAn {
	
	@Autowired
	DiscountServiceAn discounts;
	
	@GetMapping("editdiscount/{id}")
	public String editgame(@PathVariable(name="id") Integer id, Model model) {
		//get discount
		Discount dc = discounts.getById(id);	
		model.addAttribute("discounts", dc);
		return "redirect:/admin/addgame";
	}
	@RequestMapping(value = "/savediscount", method = RequestMethod.POST)
	public String savegame(@ModelAttribute("discount") Discount discount) {
		discounts.save(discount);
		return "redirect:/admin/addgame";
	}
}
