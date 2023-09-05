package com.mvc.prodycat.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.prodycat.models.Categories;
import com.mvc.prodycat.models.Products;
import com.mvc.prodycat.models.ProductsCategories;
import com.mvc.prodycat.services.MainService;

import jakarta.validation.Valid;

@Controller
public class ProductsController {
	private final MainService mainSer;
	public ProductsController(MainService m) {
		this.mainSer=m;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Products> products = mainSer.findallProducts();
		model.addAttribute("products",products);
		List<Categories> categories = mainSer.findallCategories();
		model.addAttribute("categories",categories);
		return "index.jsp";
	}
	
    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Products product) {
        return "newProduct.jsp";
    }
    
    @PostMapping("/products/new")
    public String create(@Valid @ModelAttribute("product") Products product, BindingResult result) {
        if (result.hasErrors()) {
            return "newProduct.jsp";
        } else {
            mainSer.createProduct(product);
            return "redirect:/products/new";
        }
    }
    
	@GetMapping("/products/{id}")
	public String showProducto(@PathVariable("id") Long id,
			@ModelAttribute("prodcat") ProductsCategories prodcat,
			Model model) {
		Products product = mainSer.findProduct(id);
		model.addAttribute("categories", mainSer.productNotCategory(product));	
		model.addAttribute("product",product);
		return "showProduct.jsp";
	}
}
