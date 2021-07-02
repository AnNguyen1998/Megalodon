package com.web.demo.controller;
/**
 * @author An Nguyen
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminUserControllerAn {
	
	@GetMapping("admin")
	public String adminindex() {
		return "admin/index";
	}
	@GetMapping("admin/listuser")
	public String userlist() {
		System.out.println("Admin/listuser");
		return "admin/listuser";
	}
}
