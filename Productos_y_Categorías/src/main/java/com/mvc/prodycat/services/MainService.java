package com.mvc.prodycat.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.prodycat.models.Categories;
import com.mvc.prodycat.models.Products;
import com.mvc.prodycat.models.ProductsCategories;
import com.mvc.prodycat.repositories.CategoriesRepository;
import com.mvc.prodycat.repositories.ProductCategoryRepository;
import com.mvc.prodycat.repositories.ProductsRepository;

@Service
public class MainService {
	private final ProductsRepository proRep;
	private final CategoriesRepository catRep;
	private final ProductCategoryRepository pcRep;
	public MainService(ProductsRepository p,CategoriesRepository c, ProductCategoryRepository pc) {
		this.proRep=p;
		this.catRep=c;
		this.pcRep=pc;
	}
	
	public Products createProduct(Products p) {
		return proRep.save(p);
	}
	
	public Products findProduct(Long id) {
		return proRep.findById(id).orElse(null);
	}
	
    public void deleteProd(Long id) {
    	proRep.deleteById(id);
    }
	
	public List<Products> findallProducts() {
		return proRep.findAll();
	}
	public List<Products> categoryNotProduct(Categories category){
		return proRep.findByCategoriesNotContains(category);
	}
	
	public Categories createCategory(Categories c) {
		return catRep.save(c);
	}
	public Categories findCategory(Long id) {
		return catRep.findById(id).orElse(null);
	}
	
    public void deleteCat(Long id) {
    	catRep.deleteById(id);
    }
	
	public List<Categories> findallCategories() {
		return catRep.findAll();
	}
	
	public List<Categories> productNotCategory(Products product){
		return catRep.findByProductsNotContains(product);
	}
	
	public ProductsCategories createProdcat(ProductsCategories prodcat) {
		return pcRep.save(prodcat);
	}
}
