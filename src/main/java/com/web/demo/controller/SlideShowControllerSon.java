package com.web.demo.controller;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.demo.dto.SlideShowDTO;
import com.web.demo.entity.Games;
import com.web.demo.entity.SlideShow;
import com.web.demo.service.SlideShowService;



@Controller
public class SlideShowControllerSon {
@Autowired
private SlideShowService slideshowservice;

@GetMapping("admin/slide")
public String index(SlideShowDTO slide,Model model) {
	model.addAttribute("slidedto", new SlideShowDTO());
	
	return "admin/slideshowSon";
	
}
@PostMapping("slide/add")
public String AddorUpdate(Model model,@ModelAttribute("slidedto")SlideShowDTO slide) {
	Path path=Paths.get("images/");
	try(InputStream inputstream=slide.getImage().getInputStream()) {
		String filename=slide.getImage().getOriginalFilename();
		Files.copy(inputstream, path.resolve(filename),StandardCopyOption.REPLACE_EXISTING);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	SlideShow slideshow=new SlideShow();
	Games game=new Games();
	game.setIdGame(1);
	slide.setGames(game );
	if(!slide.getImage().isEmpty()&&slide.getImage().getOriginalFilename()!=null) {
		slideshow.setImage(slide.getImage().getOriginalFilename());
	}else {
		Optional<SlideShow> sl=slideshowservice.findById(slide.getIdSlideShow());
		if(sl.isPresent()) {
			slideshow.setImage(sl.get().getImage());
		}
	}
	slideshowservice.save(slideshow);
	model.addAttribute("slidedto", slide);
	
	
	return "redirect:/admin/slide";
	
}

}
