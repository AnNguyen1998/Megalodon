package com.web.demo.controller;
/**
 * @author An Nguyen
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminControllerAn {
	
	@GetMapping("admin")
	public String adminindex() {
		return "admin/index";
	}
	@GetMapping("admin/listusers")
	public String userlist() {
		System.out.println("Admin/listuser");
		return "admin/listuser";
	}
	@GetMapping("admin/listcustomers")
	public String listcustomer() {
		return "admin/customer";
	}
	@GetMapping("admin/addgame")
	public String addgame() {
		return "admin/newgame";
	}
	@GetMapping("admin/listgame")
	public String listgame() {
		return "admin/Listofgame";
	}
}
