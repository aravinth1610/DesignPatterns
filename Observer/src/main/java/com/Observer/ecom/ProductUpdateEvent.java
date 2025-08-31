package com.Observer.ecom;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class ProductUpdateEvent extends ApplicationEvent {

	private ProductModal product;
	private String changesDesc;

	public ProductUpdateEvent( Object source, ProductModal product, String changesDesc ) {
		super(source);
		this.product = product;
		this.changesDesc = changesDesc;
	}

}
