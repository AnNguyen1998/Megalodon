package com.web.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.demo.entity.Bill;
import com.web.demo.entity.BillDetail;
import com.web.demo.service.BillDetailServiceSon;
import com.web.demo.service.BillServiceSon;

@Controller
public class BillController {
@Autowired
BillServiceSon billservice;
@Autowired
BillDetailServiceSon billdetailservice;


@GetMapping("/admin/bill")
public String billall(Model model) {
	List<Bill> listbill=billservice.findAll();
	model.addAttribute("listbill", listbill);
	
	
	
	return "admin/bill";
	
}
@GetMapping("/admin/billdetail/{id}")
public String billdetail(@PathVariable("id") int id,Model model) {
	Optional<Bill> billop=billservice.findById(id);
	List<BillDetail> listbilldetail=billdetailservice.findByBill(billop.get());
	model.addAttribute("billdetail", listbilldetail);
	
	return "admin/bill";
	
}
}
