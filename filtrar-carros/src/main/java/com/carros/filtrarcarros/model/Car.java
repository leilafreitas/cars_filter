package com.carros.filtrarcarros.model;

import java.util.Comparator;
import java.util.List;

public class Car {

	private String brand;
	private String model;
	private int year;
	private List<Part> parts;

	Car() {
	}

	Car(String brand, String model, int year, List<Part> parts) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.parts = parts;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	// Odenar pelo valor total das peças
	public float valueDamaged() {
		float value = 0;
		for (Part part : parts) {
			if (part.isDamaged()) {
				value = value + part.getValue();
			}

		}
		return value;
	}

	public int parts() {
		int value = 0;
		for (Part part : parts) {
			if (part.isDamaged()) {
				value = value + 1;
			}
		}
		return value;
	}

	public float value() {
		float value = 0;
		for (Part part : parts) {

			value = value + part.getValue();
		}
		return value;
	}

	public static Comparator<Car> getPartsValue = new Comparator<Car>() {

		@Override
		public int compare(Car e1, Car e2) {
			if (e1.value() - e2.value() == 0) {
				return 0;
			} else if ((e1.value() - e2.value() >= 1)) {
				return -1;
			}
			return 1;
		}
	};

	public static Comparator<Car> getDamagedPartsValue = new Comparator<Car>() {

		@Override
		public int compare(Car e1, Car e2) {
			if (e1.valueDamaged() - e2.valueDamaged() == 0) {
				return 0;
			} else if ((e1.valueDamaged() - e2.valueDamaged() >= 1)) {
				return -1;
			}
			return 1;
		}
	};

	public static Comparator<Car> sortDamagedParts = new Comparator<Car>() {

		@Override
		public int compare(Car e1, Car e2) {
			if (e1.parts() - e2.parts() == 0) {
				return 0;
			} else if ((e1.parts() - e2.parts() >= 1)) {
				return -1;
			}
			return 1;
		}
	};

}
