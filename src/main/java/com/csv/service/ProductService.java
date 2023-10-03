package com.csv.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csv.model.Product;

public interface ProductService {

	 void save(MultipartFile file);
	
	 List<Product> getAllProduct();
	
}
