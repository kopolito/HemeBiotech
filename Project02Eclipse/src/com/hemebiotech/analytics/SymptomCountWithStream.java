package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Implementation of Symptom Counter
 * 
 * @see ISymptomReader
 *
 */
public class SymptomCountWithStream implements ISymptomCounter {

	/**
	 * 
	 * Symptom counter
	 */
	public SymptomCountWithStream() {

	}

	/**
	 * count symptoms occurrences in symptomList
	 * 
	 * If no data is available, return an empty Map
	 * 
	 * @return Map(String symptom, Integer count) : map of all Symptoms counts obtained from list
	 * 
	 * @see ISymptomCounter#symptomCountFromList
	 */
	@Override
	public Map<String, Long> symptomCountFromList(List<String> symptomsList) {
		if (symptomsList == null || symptomsList.isEmpty()) {
			System.out.println("Empty or Null List provided toi SymptomCounter !");
			return new HashMap<String, Long>();
		}
		// count with Long Type result
		return symptomsList.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

	}

}
