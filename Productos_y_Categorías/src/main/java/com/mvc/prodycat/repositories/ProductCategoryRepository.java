package com.mvc.prodycat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.prodycat.models.ProductsCategories;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductsCategories,Long>{
	List<ProductsCategories> findAll();
}
