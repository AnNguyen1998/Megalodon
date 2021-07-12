package com.web.demo.controller;
/**
 * @author An Nguyen
 */
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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
import com.web.demo.dto.ImageDataMultiAn;
import com.web.demo.dto.SlideShowDTO;
import com.web.demo.entity.Category;
import com.web.demo.entity.Discount;
import com.web.demo.entity.Games;
import com.web.demo.entity.ImageData;
import com.web.demo.entity.SlideShow;
import com.web.demo.service.AdminBillServiceAn;
import com.web.demo.service.AdminGameServiceAn;
import com.web.demo.service.CategoryService;
import com.web.demo.service.DiscountServiceAn;
import com.web.demo.service.ImageServiceAn;
@Controller
public class GameControllerAn {
	
	@Autowired
	AdminGameServiceAn gameService;
	
	@Autowired
	CategoryService cate;
	
	@Autowired
	AdminBillServiceAn billService;
	
	@Autowired
	DiscountServiceAn discount;
	
	@Autowired
	ImageServiceAn imageService;
	
	@GetMapping("admin/addgame")
	public String addgame(Model model, Principal principal) {
		ImageDataMultiAn img = new ImageDataMultiAn();
		model.addAttribute("imgdt", img);
		
		model.addAttribute("game", new Games());
		
		model.addAttribute("discounts", new Discount());
		
		List<Category> listcate = cate.findAll();
		model.addAttribute("listcate", listcate);
		//get discount
		List<Discount> disct = discount.findAll();
		model.addAttribute("discount", disct);
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtilsAn.toStringManager(loginedUser);
			model.addAttribute("userInfo", userInfo);
		}
		return "admin/newgame";
	}
	@GetMapping("editgame/{id}")
	public String editgame(@PathVariable(name="id") Integer id, Model model, Principal principal) {
		//get game
		Games game = gameService.getById(id);	
		model.addAttribute("game", game);
		//get category
		List<Category> listcate = cate.findAll();
		model.addAttribute("listcate", listcate);
		//get discount
		List<Discount> disct = discount.findAll();
		model.addAttribute("discount", disct);
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtilsAn.toStringManager(loginedUser);
			model.addAttribute("userInfo", userInfo);
		}
		return "admin/newgame";
	}
	@RequestMapping(value = "/savegame", method = RequestMethod.POST)
	public String savegame(@ModelAttribute("game") Games game, @RequestParam("files[]") MultipartFile[] images,
			@ModelAttribute("imgdt") ImageDataMultiAn imgdt, Model model ) {
		Games g = gameService.save(game);
		int id = g.getIdGame();
		for(MultipartFile image : images) {
			try {
				if(image.getOriginalFilename().isEmpty()) {
					System.out.println("Empty file name");
					continue;
				}
				imageService.store(image);
				ImageData img = new ImageData();
				img.setGames(game);
				if(!imgdt.getNameImage().isEmpty() && imgdt.getNameImage().getOriginalFilename()!=null) {
					img.setNameImage(imgdt.getNameImage().getOriginalFilename());
					model.addAttribute("message", "Add");
					imageService.save(img);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return "redirect:/admin/Listofgame";
	}
	@GetMapping("admin/listgame")
	public String listgame(Model model, Principal principal) {
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtilsAn.toStringManager(loginedUser);
			model.addAttribute("userInfo", userInfo);
		}
		return "admin/Listofgame";
	}
}
