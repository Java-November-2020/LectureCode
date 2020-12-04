package com.matthew.cars.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.cars.models.Car;
import com.matthew.cars.models.Title;
import com.matthew.cars.services.CarService;
import com.matthew.cars.services.TitleService;

@Controller
public class CarController {
	@Autowired
	private CarService cService;
	@Autowired
	private TitleService tService;
	
//	@RequestMapping("/", method=RequestMethod.GET)
//	@RequestMapping("/")
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Car> allCars= this.cService.getAllCars();
		viewModel.addAttribute("allCars", allCars);
		return "index.jsp";
	}
	
	@GetMapping("/add")
	public String addCar(@ModelAttribute("car") Car car) {
		return "add.jsp";
	}
	
	@PostMapping("/add")
	public String addC(@Valid @ModelAttribute("car") Car car, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		this.cService.createCar(car);
		return "redirect:/";
	}
	
	@PostMapping("/addOldWay")
	public String addCarToDB(@RequestParam("make") String make, @RequestParam("model") String model, @RequestParam("color") String color, @RequestParam("year") int year, @RequestParam("transmission") String transmission, RedirectAttributes redirectAttr ) {
		ArrayList<String> errors = new ArrayList<String>();
		if(make.equals("")) {
			errors.add("Hey there, you forgot to add a make!");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		this.cService.createCarOldway(make, model, color, year, transmission);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String updateCar(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("title") Title title, @ModelAttribute("car") Car car) {
		viewModel.addAttribute("car", cService.getSingleCar(id));
		return "show.jsp";
	}
	
	@PostMapping("/addTitle")
	public String addTitle(@Valid @ModelAttribute("title") Title title, BindingResult result, Model viewModel) {
		Long carId = title.getCar().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("car", cService.getSingleCar(carId));
			return "show.jsp";
		} else {
			this.tService.create(title);
			return "redirect:/" + carId;
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCar(@PathVariable("id") Long id) {
		this.cService.deleteCar(id);
		return "redirect:/";
	}
	
	// Process Editing Car Details
	@PostMapping("/edit/{id}")
	public String editCar(@Valid @ModelAttribute("car") Car car, BindingResult result, @PathVariable("id") Long id, Model viewModel, @ModelAttribute("title") Title title) {
		Long carId = car.getId();
		if(result.hasErrors()) {			
			System.out.println(result);
			viewModel.addAttribute("car", cService.getSingleCar(carId));
			return "show.jsp";
		}
		this.cService.updateCar(car);
		return "redirect:/" + carId;
	}
	
	
	
}
