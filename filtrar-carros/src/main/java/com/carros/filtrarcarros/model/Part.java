package com.carros.filtrarcarros.model;

public class Part {

	private String name;
	private float value;
	private boolean damaged;

	Part(String name, float value, boolean damaged) {
		this.name = name;
		this.value = value;
		this.damaged = damaged;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

}
