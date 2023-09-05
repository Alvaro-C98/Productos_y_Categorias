package com.mvc.prodycat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.prodycat.models.Categories;
import com.mvc.prodycat.models.ProductsCategories;
import com.mvc.prodycat.services.MainService;

import jakarta.validation.Valid;

@Controller
public class CategoriesController {
	private final MainService mainSer;
	public CategoriesController(MainService m) {
		this.mainSer=m;
	}
	
    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Categories category) {
        return "newCategory.jsp";
    }
    
    @PostMapping("/categories/new")
    public String create(@Valid @ModelAttribute("category") Categories category, BindingResult result) {
        if (result.hasErrors()) {
            return "newCategory.jsp";
        } else {
            mainSer.createCategory(category);
            return "redirect:/categories/new";
        }
    }
    
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id,
			@ModelAttribute("catprod") ProductsCategories prodcat,
			Model model) {
		Categories category = mainSer.findCategory(id);
		model.addAttribute("products", mainSer.categoryNotProduct(category));	
		model.addAttribute("category",category);
		return "showCategory.jsp";
	}
}
