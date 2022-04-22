package com.tjoeun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjoeun.svc.CartSVC;
import com.tjoeun.vo.BookItem;

@Controller
@RequestMapping("/shop")
public class CartController {
	
	@Autowired
	private CartSVC svc;
	
	@GetMapping("/book")
	public String showBook(HttpSession session) {
		svc.setSession(session);
		return "/cart/book";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String, Boolean> cartAdd(BookItem book, HttpServletRequest request) {
		boolean added = svc.addItem(book, request);
		Map<String,Boolean> map = new HashMap<>();
		map.put("added", added);
		return map;
	}
	
	@GetMapping("/list")
	public String showCart(Model model, HttpServletRequest request) {
		model.addAttribute("list", svc.getCart(request));
		model.addAttribute("total", svc.getTotalPrice(request));
		return "/cart/showList";
	}
	
	@PostMapping("/order")
	@ResponseBody
	public Map<String, Boolean> orderBook(HttpServletRequest request) {
		boolean ordered = svc.order(request);
		Map<String,Boolean> map = new HashMap<>();
		map.put("ordered", ordered);
		return map;
	}
}
