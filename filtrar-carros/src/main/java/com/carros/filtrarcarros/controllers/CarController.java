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
	
	List<Car> cars = null;
	List<Car> auxiliar = null;

	public CarController() 
	{
	  cars = getCars();
	}
	
	private static CarController _carsController;
	
	public static CarController newInstance()
	{
		
		if(_carsController == null)
		{
			_carsController = new CarController();
		}
		return _carsController;
		
	}
	
	public List<Car> findCars()
	{
		Gson gson = new Gson();
		try
		{
			Path paths = Paths.get("vehicles.json");
			String content = new String(Files.readAllBytes(paths));	
			Car[] car = gson.fromJson(content, Car[].class);
			cars = Arrays.asList(car);
			return cars;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;	
	}
	
	/*
	public List<Carro> ordenarPorTotal()
	{
		Collections.sort(carros, (Carro carro1, Carro carro2) -> carro1.getBrand().compareTo(carro2.getBrand()));
		return auxiliar;
		
	}*/
	
	//Ordenar veiculos por valor das pecas
	public List<Car> sordByTotal()
	{
		List<Car> auxiliar = new ArrayList<>(getCars());
		System.out.print(auxiliar.size());
		Collections.sort(auxiliar, Car.getPartsValue);
		return auxiliar;
		
	}
	
	
	//Ordenar veiculos que precisam de reparo pelo valor das pecas danificadas
	public List<Car> damagedCars()
	{
		List<Car> auxiliar = getCars().stream().filter(car -> car.parts()>0).collect(Collectors.toList());
		Collections.sort(auxiliar, Car.getDamagedPartsValue);
		return auxiliar;
		
	}
	
	
	/*//Listar as peças que mais precisam de reparo; (ordenar pela quantidade de peças danificadas)
	public List<PartList> ordenarPorPecas()
	{
		
		Comparator<List<Part>> bySize = (List<Part> obj1,List<Part> obj2) ->  Integer.valueOf(obj1.size()).compareTo(obj2.size());
		
		List<Map.Entry<String, Integer>> listParts = getCarros()
					.stream()
					.flatMap(grupo -> grupo.getParts()
	                         .stream()
	                         .filter(part -> part.isDamaged() == true))
	               .collect(Collectors.groupingBy(o->o.getName()))
	               .entrySet()
	               .stream()
                   .sorted(Map.Entry.<String,List<Part>>comparingByValue(bySize).reversed())
                   .collect(Collectors.toMap(Map.Entry::getKey,entry -> entry.getValue().size(),(e1,e2)->e1,LinkedHashMap::new))
                   .entrySet()
                   .stream()
                   .collect(Collectors.toCollection(ArrayList::new));
		           
		teste();
		return obterPartsList(listParts);
	}
	
	public List<PartList> obterPartsList(List<Map.Entry<String, Integer>> lista)
	{
		List<PartList> listaPartes = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry : lista)
		{
			listaPartes.add(new PartList(entry.getKey(),entry.getValue()));
		}
		
		return listaPartes;
	}
	*/
	public List<Car> getCars()
	{
		if(cars != null)
		{
			return cars;
		}

		cars = findCars();
		return cars;
	}
		

}
