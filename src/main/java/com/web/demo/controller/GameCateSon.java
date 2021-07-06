package com.web.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.demo.entity.Category;
import com.web.demo.entity.GameCategory;
import com.web.demo.entity.Games;
import com.web.demo.service.CategortyServiceSon;
import com.web.demo.service.GameCategortyServiceSon;
import com.web.demo.service.GamesServiceSon;



@Controller
public class GameCateSon {
	@Autowired
	GameCategortyServiceSon gamecate;
	@Autowired
	GamesServiceSon game;
	@Autowired
	CategortyServiceSon cate;
	
	@GetMapping("gamecate")
	public String gamecate(Model model) {
		List<Category> listcate=cate.findAll();
		for(Category c:listcate) {
			System.out.println(c.getNameCategory());
		}
		model.addAttribute("listcate", listcate);
 		
		model.addAttribute("game", new Games());
		return "admin/gamecate";
		
	}
	@GetMapping("edit/{id}")
	public String find(Model model,@PathVariable Integer id) {
		Games gm=new Games();
		gm.setIdGame(id);
		
		List<Category> listcate=cate.findAll();
		model.addAttribute("listcate", listcate);
		List<GameCategory> listcates=gamecate.findByGames(gm);
		Games gameid= listcates.get(0).getGames();
		System.out.println("2"+gameid.getNameGame());
		model.addAttribute("game", gameid);
		for(GameCategory gc:listcates) {
			//System.out.println(gc.getCategory().getNameCategory()); 
		}
		model.addAttribute("gamecate", gamecate);
		
		
		return "admin/gamecate";
		
	}
	
}
