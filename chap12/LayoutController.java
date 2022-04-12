package com.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController
@RequestMapping("/layout")
public class LayoutController {
	
	@GetMapping("/lay")
	public String layout() {
		
//		return "Layout Test";
		return "layout/lay";
	}
	
	
	
	
	
}
