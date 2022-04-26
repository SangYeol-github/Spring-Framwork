package com.tjoeun.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tjoeun.mapper.CartMapper;
import com.tjoeun.svc.CartSVC;
import com.tjoeun.vo.BookItem;
import com.tjoeun.vo.Product;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class CartController {
	@Autowired
	private CartSVC svc;
	
	@Autowired
	private CartMapper cartMapper;

	@GetMapping("/book")
	public String showBook(Model model, 
			@SessionAttribute(value="cart", required=false) List<BookItem> cart) {
		// cart를 생성하여 model에 저장하면 @SessionAttributes("cart")에 "cart" 란 이름을
		// 지정했기 때문에 HttpSession에도 자동으로 저장된다
		if(cart==null) // 아직 세션에 cart 가 생성되어 있지 않은 경우에만 cart를 생성한다
		{
			model.addAttribute("cart", new ArrayList<BookItem>());
		}
		return "/cart/book";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String, Boolean> cartAdd(BookItem book, 
			@SessionAttribute("cart") List<BookItem> cart) {
		boolean added = svc.addItem(book, cart);
		Map<String,Boolean> map = new HashMap<>();
		map.put("added", added);
		return map;
	}
	
	@GetMapping("/list")
	public String showCart(Model model, @SessionAttribute("cart") List<BookItem> cart) {
		model.addAttribute("list", cart);
		model.addAttribute("total", svc.getTotalPrice(cart));
		return "/cart/showList";
	}
	
	@PostMapping("/order")
	@ResponseBody
	public Map<String, Boolean> orderBook(@SessionAttribute("cart") List<BookItem> cart) {
		boolean ordered = svc.order(cart);
		Map<String,Boolean> map = new HashMap<>();
		map.put("ordered", ordered);
		return map;
	}
	
	@GetMapping("/showcart")
	@ResponseBody
	public String showCart() {
		List<Product> cart = new ArrayList<>();
		cart.add(new Product(1));
		cart.add(new Product(2));
		
		List<Product> list = cartMapper.getCartProd(cart);
		return list.toString();
	}
}
