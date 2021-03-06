package com.carros.filtrarcarros.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.carros.filtrarcarros.model.Car;
import com.google.gson.Gson;

public class CarController {

	private static CarController instance;

	public static CarController newInstance() {

		if (instance == null) {
			instance = new CarController();
		}
		return instance;

	}
	
	private List<Car> cars = getCars();

	public List<Car> findCars() {
		
		Gson gson = new Gson();
		
		try {
			Path paths = Paths.get("vehicles.json");
			String content = new String(Files.readAllBytes(paths));
			Car[] car = gson.fromJson(content, Car[].class);
			cars = Arrays.asList(car);
			return cars;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/** 
	 * Ordenar veiculos por valor das pecas
	 */
	public List<Car> sordByTotal() {
		List<Car> auxiliar = new ArrayList<>(getCars());
		Collections.sort(auxiliar, Car.getPartsValue);
		
		return auxiliar;

	}

	/**
	 * Ordenar veiculos que precisam de reparo pelo valor das pecas danificadas
	*/
	public List<Car> damagedCars() {
		
		List<Car> auxiliar = getCars().stream().filter(car -> car.parts() > 0).collect(Collectors.toList());
		Collections.sort(auxiliar, Car.getDamagedPartsValue);
		
		return auxiliar;

	}

	public List<Car> getCars() {
		
		if (cars != null) {
			return cars;
		}

		cars = findCars();
		
		return cars;
	}

}
