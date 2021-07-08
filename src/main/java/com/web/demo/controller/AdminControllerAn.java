package com.web.demo.controller;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

import com.web.demo.config.WebUtils;
import com.web.demo.config.WebUtilsAn;
import com.web.demo.entity.Bill;
import com.web.demo.entity.Category;
import com.web.demo.entity.Games;
import com.web.demo.entity.Users;
import com.web.demo.service.AdminBillServiceAn;
import com.web.demo.service.AdminGameServiceAn;
import com.web.demo.service.AdminUserServiceAn;
import com.web.demo.service.CategoryService;

@Controller
public class AdminControllerAn {
	
	@Autowired
	AdminGameServiceAn gameService;
	
	@Autowired
	CategoryService cate;
	
	@Autowired
	AdminUserServiceAn userService;
	
	@Autowired
	AdminBillServiceAn billService;
	
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
		return "admin/index";
	}
	//Users
	@GetMapping("admin/listusers")
	public String userlist() {
		System.out.println("Admin/listuser");
		return "admin/listuser";
	}
	@GetMapping("admin/listcustomers")
	public String listcustomer() {
		return "admin/customer";
	}
	//Games
	@GetMapping("admin/addgame")
	public String addgame(Model model) {
		model.addAttribute("game", new Games());
		List<Category> listcate = cate.findAll();
		model.addAttribute("listcate", listcate);
		return "admin/newgame";
	}
	@GetMapping("editgame/{id}")
	public String editgame(@PathVariable(name="id") Integer id, Model model) {
		//get game
		Games game = gameService.getById(id);	
		model.addAttribute("game", game);
		//get category
		List<Category> listcate = cate.findAll();
		model.addAttribute("listcate", listcate);
		return "admin/newgame";
	}
	@RequestMapping(value = "/savegame", method = RequestMethod.POST)
	public String savegame(@ModelAttribute("game") Games game) {
		gameService.save(game);
		return "admin/Listofgame";
	}
	@GetMapping("admin/listgame")
	public String listgame() {
		return "admin/Listofgame";
	}

}
