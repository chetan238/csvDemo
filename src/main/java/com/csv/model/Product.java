package com.csv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Product")
@Data
public class Product {
	
	@Id
	private long id;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="price")
	private Double price;

}
