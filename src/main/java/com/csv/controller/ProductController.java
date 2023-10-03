package com.csv.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csv.helper.MyExcelHelper;
import com.csv.model.Product;
import com.csv.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/upload/file")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file)
	{
		if(MyExcelHelper.checkExcelFormate(file)) {
			
			
			productService.save(file);
			return ResponseEntity.ok(Map.of("Message","file uploaded success !!!"));

		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel!!!");
	}
	
	
	@GetMapping("/product")
		
		public List<Product> getAllProduct(){
			
			return productService.getAllProduct();
		}
	}
 