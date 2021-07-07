package com.web.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.web.demo.entity.Games;
import com.web.demo.service.AdminGameServiceAn;

@Controller
public class AdminControllerAn {
	
	@Autowired
	AdminGameServiceAn gameService;
	
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
	public String addgame(Model model) {
		model.addAttribute("game", new Games());
		return "admin/newgame";
	}
	@GetMapping("editgame/{id}")
	public String editgame(@PathVariable(name="id") Integer id, Model model) {
		Games game = gameService.getById(id);
	//	System.out.println(game.getGameCategories().toString());
		model.addAttribute("game", game);
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
