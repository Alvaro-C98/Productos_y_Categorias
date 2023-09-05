package com.mvc.prodycat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.prodycat.models.Categories;
import com.mvc.prodycat.models.Products;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories,Long>{
	List<Categories> findAll();
	
	List<Categories> findByProductsNotContains(Products product);
}
