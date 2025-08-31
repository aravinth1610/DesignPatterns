package com.Observer.ecom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModal> getProduct(@PathVariable String productId) {
	    ProductModal product = productService.getProduct(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{productId}/{newPrice}/price")
    public ResponseEntity<String> updatePrice(@PathVariable String productId, @PathVariable Double newPrice) {
        try {
            productService.updatePrice(productId, newPrice);
            return ResponseEntity.ok("Price updated successfully for product " + productId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{productId}/stock")
    public ResponseEntity<String> updateStock(@PathVariable String productId, @RequestBody boolean inStock) {
        try {
            productService.updateStock(productId, inStock);
            return ResponseEntity.ok("Stock status updated successfully for product " + productId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
