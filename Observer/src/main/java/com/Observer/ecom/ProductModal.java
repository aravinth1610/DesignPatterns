package com.Observer.ecom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModal {

	private String productId;
	private String name;
	private double price;
	private boolean inStock;

}
