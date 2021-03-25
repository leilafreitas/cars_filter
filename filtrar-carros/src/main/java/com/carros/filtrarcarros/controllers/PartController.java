package com.carros.filtrarcarros.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.carros.filtrarcarros.model.Car;
import com.carros.filtrarcarros.model.Part;
import com.carros.filtrarcarros.model.PartList;

public class PartController {

	public PartController() {
	}

	/**
	 * Obtem as peças a partir dos veiculos e as agrupa e ordena
	 * */
	public List<PartList> sortParts() {

		Comparator<List<Part>> bySize = (List<Part> obj1, List<Part> obj2) -> Integer.valueOf(obj1.size())
				.compareTo(obj2.size());

		List<Map.Entry<String, Integer>> listParts = CarController.newInstance().getCars().stream()
				.flatMap(grupo -> grupo.getParts().stream())
				.collect(Collectors.groupingBy(o -> o.getName(),
						Collectors.filtering(e -> e.isDamaged() == true, Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.<String, List<Part>>comparingByValue(bySize).reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size(), (e1, e2) -> e1,
						LinkedHashMap::new))
				.entrySet().stream().collect(Collectors.toCollection(ArrayList::new));

		return getPartsList(listParts);
	}

	/**
	 * remodelação dos dados para que o retorno seja apenas uma lista com o nome da
	peça e a quantidade de peças defeituosas
	*/
	public List<PartList> getPartsList(List<Map.Entry<String, Integer>> lista) {
		
		List<PartList> listaPartes = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : lista) {
			listaPartes.add(new PartList(entry.getKey(), entry.getValue()));
		}

		return listaPartes;
	}

}