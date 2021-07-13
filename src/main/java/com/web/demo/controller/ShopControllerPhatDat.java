package com.web.demo.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.demo.entity.Category;
import com.web.demo.entity.CommentGame;
import com.web.demo.entity.Games;
import com.web.demo.entity.ImageData;
import com.web.demo.service.CategoryService;
import com.web.demo.service.DiscountServicePD;
import com.web.demo.service.GameImageServiceSon;
import com.web.demo.service.GamesServicePD;
import com.web.demo.service.ImageDataServicePD;
import com.web.demo.service.UserCommentGameServicePD;
import com.web.demo.service.UserServiceSon;

/**
 * @author PhatDat
 * get list of games and search
 * display detailed info of a game
 */
@Controller
public class ShopControllerPhatDat {
	@Autowired
	private DiscountServicePD discountService;
	
	@Autowired
	private ImageDataServicePD imageGameService;
	
	
	@Autowired
	private GamesServicePD gameService;
	
	@Autowired
	CategoryService cateService;
	
	@Autowired
	private UserCommentGameServicePD comment;
	
	@Autowired
	CategoryService cateservice;
	@Autowired
	GameImageServiceSon idataservice;
	
	@Autowired
	UserServiceSon userService;
	
	/*
	 * @GetMapping(value = "/shoptest/{pageNo}") public String
	 * shop1(@PathVariable(value = "pageNo") int pageNo, Model model) {
	 * //model.addAttribute("img", imageGameService.getImageGame(1));
	 * //model.addAttribute("game", gameService.getGame(1));
	 * //model.addAttribute("discount", discountService.getDiscount(1));
	 * //System.out.println(imageGameService.getImageGame(1)); List<Category>
	 * listcate= cateService.findAll(); model.addAttribute("listcate",listcate); int
	 * pageSize = 4;
	 * 
	 * Page<Games> page = gameService.findAllPaginated(pageNo, pageSize);
	 * List<Games> listAllGames = page.getContent();
	 * model.addAttribute("currentPage", pageNo); model.addAttribute("totalPages",
	 * page.getTotalPages()); model.addAttribute("totalItems",
	 * page.getTotalElements()); //model.addAttribute("listGames", listEmployees);
	 * 
	 * model.addAttribute("images1", imageGameService.getImageList());
	 * model.addAttribute("listAllGames", listAllGames);
	 * 
	 * return "shop/shoptest"; }
	 * 
	 * @RequestMapping(value = "/shoptest/{pageNo}") public String shopSearch(Model
	 * model, @Param("keyword") String keyword, @PathVariable(value = "pageNo") int
	 * pageNo) { int pageSize = 4; Page<Games> page;
	 * 
	 * if(keyword != null && !keyword.isEmpty()) { page =
	 * gameService.listAllGamesPaginated(keyword, pageNo, pageSize); } else { page =
	 * gameService.findAllPaginated(pageNo, pageSize); } List<Games> listAllGames =
	 * page.getContent(); model.addAttribute("listAllGames", listAllGames);
	 * model.addAttribute("keyword", keyword); model.addAttribute("currentPage",
	 * pageNo); model.addAttribute("totalPages", page.getTotalPages());
	 * model.addAttribute("totalItems", page.getTotalElements());
	 * model.addAttribute("images1", imageGameService.getImageList());
	 * 
	 * return "shop/shoptest"; }
	 * 
	 * @RequestMapping(value = "/shop/game") public String gameDetail(Model
	 * model, @RequestParam("id") int id) { List<Category> listcate=
	 * cateService.findAll(); model.addAttribute("listcate",listcate);
	 * model.addAttribute("game", gameService.getGame(id));
	 * model.addAttribute("images", imageGameService.getImageDetailGame(id)); return
	 * "shop/gamedetails"; }
	 */
	
	@GetMapping(value = "/shop1/detailgame")
    public String gameDetail1(Model model, @RequestParam("id") int idGame) {
		model.addAttribute("game", gameService.getGame(idGame));		
		model.addAttribute("images", imageGameService.getImageDetailGame(idGame));
		model.addAttribute("idGame", idGame);

		
		//add comment game
		model.addAttribute("cmts", comment.getCommentGame(idGame));
		model.addAttribute("recGames", gameService.getRelatedGames(idGame));
		model.addAttribute("recImgGames", imageGameService.getRelatedImageList(idGame));
		model.addAttribute("comment", new CommentGame());
		/**
		 * @author Dat Ha
		 */
		List<Category> listcate = cateservice.findAll();
		model.addAttribute("listcate",listcate);
        return "shop/gameinfo";
    }
	
	
	@PostMapping(value = "/shop1/detail")
    public String saveCommentGame(Model model, 
    		@RequestParam("name") String name, 
    		@RequestParam("email") String email, 
    		@RequestParam("cmt") String cmt) {
		int idGame, idUser;
		idGame = (Integer)model.getAttribute("idGame");
		
		model.addAttribute("game", gameService.getGame(idGame));		
		model.addAttribute("images", imageGameService.getImageDetailGame(idGame));
		//save comment game
		idUser = userService.findByusernameUsers(name).getIdUsers();
		comment.addCommentGame(idGame, idUser, cmt);
		
		//add comment game
		model.addAttribute("cmts", comment.getCommentGame(idGame));
		model.addAttribute("recGames", gameService.getRelatedGames(idGame));
		model.addAttribute("recImgGames", imageGameService.getRelatedImageList(idGame));
		
        return "shop/gameinfo";
    }
	
	
	
	@GetMapping(value = "/shop1/{pageNo}")
    public String shop1(Model model, 
    		@PathVariable(value = "pageNo") Integer pageNo, 
    		@Param("keyword") String keyword) {
		//model.addAttribute("img", imageGameService.getImageGame(1));
		//model.addAttribute("game", gameService.getGame(1));
		//model.addAttribute("discount", discountService.getDiscount(1));
		//System.out.println(imageGameService.getImageGame(1));
		int pageSize = 12;
		
		Page<Games> page = null;
		if(keyword != null && !keyword.isEmpty()) {
			page = gameService.listAllGamesPaginated(keyword, pageNo, pageSize);
		}
		else {
			page = gameService.findAllPaginated(pageNo, pageSize);
		}
		 
	    List<Games> listAllGames = page.getContent();
	    
	    
		model.addAttribute("images1", imageGameService.getImageList());
		model.addAttribute("listAllGames", listAllGames);
		model.addAttribute("countSearch", listAllGames.size());
		model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    
	    /**
		 * @author Dat Ha
		 */
		List<Category> listcate = cateservice.findAll();
		model.addAttribute("listcate",listcate);
		
        return "shop/shop1";
    }
	

	@GetMapping(value = {"/shop1/games/{term}/{pageNo}"})
    public String shop2(Model model, 
    		@PathVariable(value = "pageNo") int pageNo, 
    		@PathVariable(value = "term") String term,
    		@RequestParam(value = "size", defaultValue = "4") int pageSize) {
		//pageSize = 5;

	    Page<Games> page = gameService.findAllPaginated(pageNo, pageSize);
	    List<Games> listAllGames = page.getContent();
	    model.addAttribute("term", term);
	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("images1", imageGameService.getImageList());
	    //model.addAttribute("listGames", listEmployees);
		
		model.addAttribute("images1", imageGameService.getImageList());
		if( term == null || term.isEmpty()){
			model.addAttribute("listAllGames", listAllGames);               
	     } 
		else if (term.equalsIgnoreCase("bestSelling")){
			 page = gameService.findGamesByFilterPaginated(pageNo, pageSize, "Count_sell");
			 model.addAttribute("listAllGames", page.getContent());
	    	 //model.addAttribute("games1", gameService.getGamesByFilter("Count_sell", Integer.MAX_VALUE));
	     }
		else if (term.equalsIgnoreCase("recommended")){
			 page = gameService.findGamesByFilterPaginated(pageNo, pageSize, "Rate_game");
			 model.addAttribute("listAllGames", page.getContent());
	    	 //model.addAttribute("games1", gameService.getGamesByFilter("Rate_game", Integer.MAX_VALUE));
	     }
		else if (term.equalsIgnoreCase("newRelease")){
			 page = gameService.findGamesByFilterPaginated(pageNo, pageSize, "ReleaseYear_game");
			 model.addAttribute("listAllGames", page.getContent());
	    	 //model.addAttribute("games1", gameService.getGamesByFilter("ReleaseYear_game", Integer.MAX_VALUE));
	    }
	    
	    /**
		 * @author Dat Ha
		 */
		List<Category> listcate= cateservice.findAll();
		model.addAttribute("listcate",listcate);
		
        return "shop/shop1";
    }
	
	
	@GetMapping(value = "/shop1/categories/{cate}/{pageNo}")
    public String shopCategory(Model model, 
    		@PathVariable(value = "pageNo") Integer pageNo, 
    		@PathVariable(value = "cate") int idCate) {
		//model.addAttribute("img", imageGameService.getImageGame(1));
		//model.addAttribute("game", gameService.getGame(1));
		//model.addAttribute("discount", discountService.getDiscount(1));
		//System.out.println(imageGameService.getImageGame(1));
		int pageSize = 12;
		
		Page<Games> page = gameService.findGamesByCategoryPaginated(pageNo, pageSize, idCate);

		
	    List<Games> listAllGames = page.getContent();
		
		model.addAttribute("images1", imageGameService.getImageList());
		model.addAttribute("listAllGames", listAllGames);
		model.addAttribute("countSearch", listAllGames.size());
		model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    
	    /**
		 * @author Dat Ha
		 */
		List<Category> listcate = cateservice.findAll();
		model.addAttribute("listcate",listcate);
		
        return "shop/shop1";
    }

	
}
