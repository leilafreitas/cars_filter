package com.carros.filtrarcarros.model;

public class PartList {

	private String part;
	private int quantity;

	public PartList(String part, int quantity) {
		super();
		this.part = part;
		this.quantity = quantity;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
