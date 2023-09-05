package com.mvc.prodycat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.prodycat.models.Categories;
import com.mvc.prodycat.models.Products;
import com.mvc.prodycat.models.ProductsCategories;
import com.mvc.prodycat.services.MainService;

import jakarta.validation.Valid;

@Controller
public class ProductCategoryController {
	private final MainService mainSer;
	public ProductCategoryController(MainService m) {
		this.mainSer=m;
	}
	
	@PostMapping("/prodcat/{id}")
	public String prodcat(@Valid @PathVariable("id") Long id,
			@ModelAttribute("prodcat") ProductsCategories prodcat, BindingResult result) {
		if(result.hasErrors()) {
			return "showProduct.jsp";
		}
		else {
			if(prodcat.getProduct().getCategories().size()>0) {
				Categories cate = prodcat.getCategory();
				prodcat.getProduct().setCategories(cate);
			}
			mainSer.createProdcat(prodcat);
			return "redirect:/products/"+id;
		}
	}
	
	@PostMapping("/prodcat/{id}/del")
	public String prodcatDel(@Valid @PathVariable("id") Long id,
			@ModelAttribute("prodcat") ProductsCategories prodcat, BindingResult result) {
		if(result.hasErrors()) {
			return "showProduct.jsp";
		}
		else {
			mainSer.deleteCat(prodcat.getCategory().getId());
			return "redirect:/products/"+id;
		}
	}
	
	@PostMapping("/catprod/{id}")
	public String catprod(@Valid @PathVariable("id") Long id,
			@ModelAttribute("catprod") ProductsCategories catprod, BindingResult result) {
		if(result.hasErrors()) {
			return "showCategory.jsp";
		}
		else {
			if(catprod.getCategory().getProducts().size()>0) {
				Products prod = catprod.getProduct();
				catprod.getCategory().setProducts(prod);
			}
			mainSer.createProdcat(catprod);
			return "redirect:/categories/"+id;
		}
	}
	
	@PostMapping("/catprod/{id}/del")
	public String catprodDel(@Valid @PathVariable("id") Long id,
			@ModelAttribute("catprod") ProductsCategories catprod, BindingResult result) {
		if(result.hasErrors()) {
			return "showCategory.jsp";
		}
		else {
			mainSer.deleteProd(catprod.getProduct().getId());
			return "redirect:/categories/"+id;
		}
	}
}
