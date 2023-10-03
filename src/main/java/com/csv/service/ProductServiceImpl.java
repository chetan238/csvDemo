package com.csv.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csv.helper.MyExcelHelper;
import com.csv.model.Product;
import com.csv.repo.ProductRepo;

import lombok.experimental.Helper;


@Service
public class ProductServiceImpl  implements ProductService {

	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public void save(MultipartFile file) {
		// TODO Auto-generated method stub
		
		
		
		try {
			List<Product>	convertExcelToList = MyExcelHelper.convertExcelToList(file.getInputStream());
			productRepo.saveAll(convertExcelToList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
		}

}
