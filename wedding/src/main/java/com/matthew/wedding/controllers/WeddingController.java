package com.matthew.wedding.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.wedding.modlels.User;
import com.matthew.wedding.modlels.Wedding;
import com.matthew.wedding.services.UserService;
import com.matthew.wedding.services.WeddingService;

@Controller
@RequestMapping("/weddings")
public class WeddingController {
	@Autowired
	private WeddingService wService;
	@Autowired
	private UserService uService;
	
	@GetMapping("")
	public String landing(Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");
		// Check for user in session, if not redirect
		viewModel.addAttribute("user", this.uService.getById(userId));
		viewModel.addAttribute("weddings", this.wService.getWeddings());
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newWedding(@ModelAttribute("wedding") Wedding wedding) {
		return "new.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("wedding") Wedding wedding, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		Long userID = (Long)session.getAttribute("user_id");
		User userCreatedWedding = this.uService.getById(userID);
		wedding.setPlanner(userCreatedWedding);
		this.wService.create(wedding);
		return "redirect:/weddings";
	}
	
	@GetMapping("{id}")
	public String display(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("wedding", this.wService.getById(id));
		return "show.jsp";
		
	}
	
	@GetMapping("/rsvp/{id}")
	public String attendWedding(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Wedding weddingRSVP = this.wService.getById(id);
		User userToAttend = this.uService.getById(userId);
		this.wService.addGuest(weddingRSVP, userToAttend);
		return "redirect:/weddings";
	}
	
	@GetMapping("/unrsvp/{id}")
	public String leaveWedding(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Wedding weddingRSVP = this.wService.getById(id);
		User userToAttend = this.uService.getById(userId);
		this.wService.removeGuest(weddingRSVP, userToAttend);
		return "redirect:/weddings";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.wService.delete(id);
		return "redirect:/weddings";
	}
	
	
}
