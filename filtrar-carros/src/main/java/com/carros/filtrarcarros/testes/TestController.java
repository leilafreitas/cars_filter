package com.carros.filtrarcarros.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.carros.filtrarcarros.controllers.CarController;
import com.carros.filtrarcarros.controllers.PartController;
import com.carros.filtrarcarros.model.Car;
import com.carros.filtrarcarros.model.Part;
import com.carros.filtrarcarros.model.PartList;


public class TestController 
//Para os testes, usei um arquivo diferente, no qual apenas utilizei 6 items
{	
	@Test
	public void testQtCars()
	{
		CarController controller = new CarController();
		List<Car> car= controller.getCars();
		assertEquals(car.size(), 6);
	}
	
	@Test
	public void testeSortedCar()
	{
		CarController controller = new CarController();
		List<Car> car= controller.sordByTotal();
		assertEquals(car.get(0).getBrand(), "Chevrolet");
		assertEquals(car.get(car.size()-1).getBrand(), "Hyundai");
	}
	
	@Test
	public void testeSortedDamagedCar()
	{
		CarController controller = new CarController();
		List<Car> car= controller.damagedCars();
		assertEquals(car.get(0).getBrand(), "Chevrolet");
		assertEquals(car.get(1).getBrand(), "Ford");
	}
	
	@Test
	public void testeGetParts()
	{
		PartController controller = new PartController();
		List<PartList> part= controller.sortParts();
		assertEquals(part.get(0).getQuantity(), 3);
		assertEquals(part.get(2).getQuantity(), 2);
		assertEquals(part.get(part.size()-1).getQuantity(), 1);
	}
}