package com.web.demo.controller;
import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
/**
 * @author An Nguyen
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.demo.config.WebUtilsAn;
import com.web.demo.entity.Bill;
import com.web.demo.entity.Category;
import com.web.demo.entity.Games;
import com.web.demo.entity.Systems;
import com.web.demo.service.AdminBillServiceAn;
import com.web.demo.service.AdminGameServiceAn;
import com.web.demo.service.AdminUserServiceAn;
import com.web.demo.service.CategoryService;
import com.web.demo.service.SystemsService;

@Controller
public class AdminControllerAn {
	
	@Autowired
	AdminGameServiceAn gameService;
	
	@Autowired
	AdminUserServiceAn userService;
	
	@Autowired
	AdminBillServiceAn billService;
	
	@Autowired
	SystemsService systemService;
	
	@GetMapping("admin")
	public String adminindex(Model model, Principal principal) {
		List<Games> topgame = gameService.findAllTop();
		model.addAttribute("topgame", topgame);
		List<Bill> topuser = billService.findAllTop();
		model.addAttribute("topuser", topuser);
		for(Bill b:topuser) {
			System.out.println(b.getUsers().getNameUsers());
		}
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtilsAn.toStringManager(loginedUser);
			model.addAttribute("userInfo", userInfo);
		}
		//access page times
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
			LocalDate localDate = LocalDate.now();
			String date = dtf.format(localDate);
			Systems sys = systemService.findByDateLike(date);
			model.addAttribute("date", sys);
			//get yesterday
			LocalDate previous = localDate.minus(Period.ofDays(1));
			System.out.println(dtf.format(previous));
			String yesterday = dtf.format(previous);
			Systems yes = systemService.findByDateLike(yesterday);
			if(yes != null) {
				model.addAttribute("yesterday", yes);
			}else {
				Systems ye = new Systems();
				ye.setDowloadSystem(0);
				ye.setViewsSystem(0);
				model.addAttribute("yesterday",ye);
			}
			
		return "admin/index";
	}
	//Users
	@GetMapping("admin/listusers")
	public String userlist(Model model, Principal principal) {
		System.out.println("Admin/listuser");
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtilsAn.toStringManager(loginedUser);
			model.addAttribute("userInfo", userInfo);
		}
		return "admin/listuser";
	}
	@GetMapping("admin/listcustomers")
	public String listcustomer(Model model, Principal principal) {
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtilsAn.toStringManager(loginedUser);
			model.addAttribute("userInfo", userInfo);
		}
		return "admin/customer";
	}
}
