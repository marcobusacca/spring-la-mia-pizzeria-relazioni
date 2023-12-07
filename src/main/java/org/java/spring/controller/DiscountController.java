package org.java.spring.controller;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

import org.java.spring.db.serv.DiscountService;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiscountController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DiscountService discountService;
	
	@GetMapping("/pizzas/discount")
	public String createDiscount(Model model) {
		
		return "";
	}
	@PostMapping("/pizzas/discount")
	public String storeDiscount() {
		
		return "";
	}
}
