package com.codingdojo.devon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	// listen for requests!
	// localhost:8080
	@RequestMapping("")
	public String helloWorld() {
		// RESPONSE!!
		return "index.jsp";
	}
	
	@RequestMapping("/message")
	public String message(@RequestParam(value="mood") String mood, Model model) {
		// RESPONSE!!
		model.addAttribute("mood", mood);
		System.out.println(mood);
		return "message.jsp";
	}
	
	
	// localhost:8080/message/happy
	// localhost:8080/message/sad
//	@RequestMapping("/message/{mood}")
//	public String message(@PathVariable String mood) {
//		// RESPONSE!!
//		return String.format("A %s message to all of you!", mood);
//	}
}
