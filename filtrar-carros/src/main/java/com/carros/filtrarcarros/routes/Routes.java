package com.carros.filtrarcarros.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.filtrarcarros.controllers.CarController;
import com.carros.filtrarcarros.controllers.PartController;
import com.carros.filtrarcarros.model.Car;
import com.carros.filtrarcarros.model.PartList;

import java.util.*;

@RestController
@RequestMapping("/api/cars")
public class Routes {
	PartController partController = new PartController();

	@CrossOrigin
	@GetMapping("/allcars")
	public List<Car> listcars() {
		return CarController.newInstance().getCars();
	}

	@CrossOrigin
	@GetMapping("/allcarssorted")
	public List<Car> bytotalvalue() {
		return CarController.newInstance().sordByTotal();
	}

	@CrossOrigin
	@GetMapping("/damagedcars")
	public List<Car> bypartvalue () {
		return CarController.newInstance().damagedCars();
	}

	@CrossOrigin
	@GetMapping("/damagedparts")
	public List<PartList> listparts() {
		return partController.sortParts();
	}
}