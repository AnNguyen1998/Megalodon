package com.web.demo.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.demo.config.WebUtils;
import com.web.demo.entity.Category;
import com.web.demo.entity.CommentGame;
import com.web.demo.entity.Games;
import com.web.demo.entity.ImageData;
import com.web.demo.entity.Users;
import com.web.demo.service.CategoryService;
import com.web.demo.service.DiscountServicePD;
import com.web.demo.service.GameImageServiceSon;
import com.web.demo.service.GamesServicePD;
import com.web.demo.service.ImageDataServicePD;
import com.web.demo.service.UserCommentGameServicePD;
import com.web.demo.service.UserServiceSon;

/**
 * @author PhatDat get list of games and search display detailed info of a game
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
	private UserCommentGameServicePD commentService;

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

	@RequestMapping(value = "/shop/detailgame")
	public String gameDetail1(Model model, @RequestParam("id") Integer idGame,
			@ModelAttribute("comment") CommentGame comment, HttpServletRequest request) {
		// String username = comment.getUsers().getUsernameUsers();
		// Integer idGame = Integer.parseInt(params.get("id"));
		String url = request.getRequestURL().toString() + "?id=" + idGame.toString();
		model.addAttribute("URL", url);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userService.findByusernameUsers(username);
		String cmt = comment.getContentCommentGame();
		// String cmt = params.get("cmt");

		if (user != null) {
			Integer idUser = user.getIdUsers();
			model.addAttribute("avatar", user.getImageUsers());
			model.addAttribute("usernameUsers", username);
			if (cmt == null) {
				comment = new CommentGame();
				model.addAttribute("comment", comment);
			} else {
				commentService.addCommentGame(idGame, idUser, cmt);
			}
		} else {
			model.addAttribute("avatar", "img/imgUser/defaultavatar.png");
			model.addAttribute("usernameUsers", "guest");
		}
		
		//model.addAttribute("contentCommentGame", "");
		comment.setContentCommentGame("");
		model.addAttribute("game", gameService.getGame(idGame));
		model.addAttribute("images", imageGameService.getImageDetailGame(idGame));
		model.addAttribute("id", idGame);

		// add comment game
		model.addAttribute("cmts", commentService.getCommentGame(idGame));
		model.addAttribute("recGames", gameService.getRelatedGames(idGame));
		model.addAttribute("recImgGames", imageGameService.getRelatedImageList(idGame));

		/**
		 * @author Dat Ha
		 */
		List<Category> listcate = cateservice.findAll();
		model.addAttribute("listcate", listcate);
		return "shop/gameinfo";
	}

	/*
	 * @PostMapping(value = "/shop/detailgame") public String saveCommentGame(Model
	 * model, // @RequestParam(value = "users.usernameUsers", required = false)
	 * String name, // @RequestParam(value = "contentCommentGame", required = false)
	 * String cmt,
	 * 
	 * @ModelAttribute("comment") CommentGame comment) { Integer idUser, idGame;
	 * idGame = (Integer)model.getAttribute("idGame");
	 * 
	 * if(idGame == null) { idGame = 3; }
	 * 
	 * idUser = comment.getUsers().getIdUsers();
	 * commentService.addCommentGame(idGame, idUser,
	 * comment.getContentCommentGame());
	 * 
	 * 
	 * 
	 * model.addAttribute("game", gameService.getGame(idGame));
	 * model.addAttribute("images", imageGameService.getImageDetailGame(idGame));
	 * //save comment game idUser =
	 * userService.findByusernameUsers(name).getIdUsers();
	 * commentService.addCommentGame(idGame, idUser, cmt);
	 * 
	 * //add comment game model.addAttribute("cmts",
	 * commentService.getCommentGame(idGame)); model.addAttribute("recGames",
	 * gameService.getRelatedGames(idGame)); model.addAttribute("recImgGames",
	 * imageGameService.getRelatedImageList(idGame));
	 * 
	 * 
	 * return "redirect:/shop/detailgame"; }
	 */

	@GetMapping(value = { "/shop/{pageNo}", "/shop" })
	public String shop1(Model model, @PathVariable(value = "pageNo", required = false) Integer pageNo,
			@Param("keyword") String keyword, Principal principal, @RequestParam(required = false) String message,
			Users user, HttpSession session) {

		// Regis
		model.addAttribute("user", user);

		//
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
				session.removeAttribute("userinfoname");
				session.removeAttribute("userinfoemail");
				session.removeAttribute("userinfoid");
				session.removeAttribute("userinfophone");

			}
			if (message.equals("loginreq")) {
				model.addAttribute("message", "Please Login");
			}

		}
		System.out.println(message);
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			Users us = userService.findByusernameUsers(loginedUser.getUsername());
			session.setAttribute("userinfoname", us.getNameUsers());
			session.setAttribute("userinfoemail", us.getEmailUsers());
			session.setAttribute("userinfoid", us.getIdUsers());
			session.setAttribute("userinfophone", us.getPhoneUsers());
			System.out.println(session.getAttribute("userinfoname") + "a" + session.getAttribute("userinfoemail"));
			String userInfo = WebUtils.toString(loginedUser);
			model.addAttribute("userInfo", userInfo);
		}

		int pageSize = 12;
		if (pageNo == null) {
			pageNo = 1;
		} else if (pageNo.intValue() == 0) {
			pageNo = 1;
		}

		Page<Games> page = null;
		if (keyword != null && !keyword.isEmpty()) {
			page = gameService.listAllGamesPaginated(keyword, pageNo, pageSize);
		} else {
			page = gameService.findAllPaginated(pageNo, pageSize);
		}

		List<Games> listAllGames = page.getContent();

		model.addAttribute("images1", imageGameService.getImageList());
		model.addAttribute("listAllGames", listAllGames);
		model.addAttribute("countSearch", listAllGames.size());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		System.out.println(imageGameService.getImageList());

		/**
		 * @author Dat Ha
		 */
		List<Category> listcate = cateservice.findAll();
		model.addAttribute("listcate", listcate);

		return "shop/shop1";
	}

	@GetMapping(value = { "/shop/games/{term}/{pageNo}" })
	public String shop2(Model model, @PathVariable(value = "pageNo") int pageNo,
			@PathVariable(value = "term") String term, @RequestParam(value = "size", defaultValue = "4") int pageSize) {
		// pageSize = 5;

		Page<Games> page = gameService.findAllPaginated(pageNo, pageSize);
		List<Games> listAllGames = page.getContent();
		model.addAttribute("term", term);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("images1", imageGameService.getImageList());
		// model.addAttribute("listGames", listEmployees);

		model.addAttribute("images1", imageGameService.getImageList());
		if (term == null || term.isEmpty()) {
			model.addAttribute("listAllGames", listAllGames);
		} else if (term.equalsIgnoreCase("bestSelling")) {
			page = gameService.findGamesByFilterPaginated(pageNo, pageSize, "Count_sell");
			model.addAttribute("listAllGames", page.getContent());
			// model.addAttribute("games1", gameService.getGamesByFilter("Count_sell",
			// Integer.MAX_VALUE));
		} else if (term.equalsIgnoreCase("recommended")) {
			page = gameService.findGamesByFilterPaginated(pageNo, pageSize, "Rate_game");
			model.addAttribute("listAllGames", page.getContent());
			// model.addAttribute("games1", gameService.getGamesByFilter("Rate_game",
			// Integer.MAX_VALUE));
		} else if (term.equalsIgnoreCase("newRelease")) {
			page = gameService.findGamesByFilterPaginated(pageNo, pageSize, "ReleaseYear_game");
			model.addAttribute("listAllGames", page.getContent());
			// model.addAttribute("games1", gameService.getGamesByFilter("ReleaseYear_game",
			// Integer.MAX_VALUE));
		}

		/**
		 * @author Dat Ha
		 */
		List<Category> listcate = cateservice.findAll();
		model.addAttribute("listcate", listcate);

		return "shop/shop1";
	}

	@GetMapping(value = "/shop/categories/{cate}/{pageNo}")
	public String shopCategory(Model model, @PathVariable(value = "pageNo") Integer pageNo,
			@PathVariable(value = "cate") int idCate) {
		// model.addAttribute("img", imageGameService.getImageGame(1));
		// model.addAttribute("game", gameService.getGame(1));
		// model.addAttribute("discount", discountService.getDiscount(1));
		// System.out.println(imageGameService.getImageGame(1));
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
		model.addAttribute("listcate", listcate);

		return "shop/shop1";
	}

}
