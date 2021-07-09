package com.web.demo.controller;
/**
 * @author NguyenHuuSon
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.demo.dto.CartDTOSon;
import com.web.demo.entity.Games;
import com.web.demo.service.AdminGameServiceAn;
import com.web.demo.service.GamesServicePD;
@Controller
public class CartControllerSon {

	@Autowired
	AdminGameServiceAn gameservice;
	@GetMapping("/cart")
	public String indexcart() {
		
		return "shop/cart";
	}
	
	@GetMapping("cart/add/{id}")
	public String  addcart(Model model,HttpSession session,@PathVariable int id) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDTOSon>Cartitems=(HashMap<Integer, CartDTOSon>)session.getAttribute("mycartitem");
		if(Cartitems==null) {
			Cartitems=new HashMap<Integer, CartDTOSon>();
			
		}
		Optional<Games> games=gameservice.findById(id);
		if(games.isPresent()) {
			CartDTOSon cart=new CartDTOSon(games.get());
			
			Cartitems.put(id, cart);
			
		}
		session.setAttribute("mycartitem", Cartitems);
		session.setAttribute("mycarttotal",totalPrice(Cartitems));
		session.setAttribute("mycartnum", Cartitems.size());
		return "redirect:/shop1";
	}
	public double totalPrice(HashMap<Integer, CartDTOSon> cartitems) {
		int count=0;
		for(Map.Entry<Integer,CartDTOSon> list: cartitems.entrySet()) {
			
				count += list.getValue().getGames().getPriceFix();
			
		}
		return count;
	}
	@GetMapping("cart/remove/{id}")
	public String remove(Model model, HttpSession session,@PathVariable("id") Integer id) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDTOSon> cartitems=(HashMap<Integer, CartDTOSon>)session.getAttribute("mycartitem");
		if(cartitems==null) {
			cartitems=new HashMap<>();
		}
		if(cartitems.containsKey(id)) {
			cartitems.remove(id);
		}
		session.setAttribute("mycartitem", cartitems);
		session.setAttribute("mycarttotal",totalPrice(cartitems));
		session.setAttribute("mycartnum", cartitems.size());
		return "redirect:/cart";
	}
}
