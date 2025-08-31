package com.Observer.ecom;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private final ApplicationEventPublisher eventPublisher;
	private final Map<String, ProductModal> products;

	public ProductService( ApplicationEventPublisher eventPublisher ) {
		this.eventPublisher = eventPublisher;
		this.products = new HashMap<>();
		// Initialize sample products
		products.put("PROD001", new ProductModal("PROD001", "Laptop", 1000.00, true));
		products.put("PROD002", new ProductModal("PROD002", "Smartphone", 800.00, false));
		products.put("PROD003", new ProductModal("PROD003", "Headphones", 150.00, true));
	}

	public ProductModal getProduct(String productId) {
		return products.get(productId);
	}

	public void updatePrice(String productId, double newPrice) {
		ProductModal product = products.get(productId);
		if (product == null) {
			throw new IllegalArgumentException("Product with ID " + productId + " not found");
		}
		double oldPrice = product.getPrice();
		product.setPrice(newPrice);
		String description = String.format("Price changed from $%.2f to $%.2f", oldPrice, newPrice);
		eventPublisher.publishEvent(new ProductUpdateEvent(this, product, description));
	}

	public void updateStock(String productId, boolean inStock) {
		ProductModal product = products.get(productId);
		if (product == null) {
			throw new IllegalArgumentException("Product with ID " + productId + " not found");
		}
		boolean oldStockStatus = product.isInStock();
		if (oldStockStatus != inStock) {
			product.setInStock(inStock);
			String description = inStock ? "Product is back in stock" : "Product is out of stock";
			eventPublisher.publishEvent(new ProductUpdateEvent(this, product, description));
		}
	}
}
