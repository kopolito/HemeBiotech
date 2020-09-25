package com.hemebiotech.analytics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of Symptom Sorter
 * 
 * @see ISymptomSorter
 *
 */
public class SymptomSortWithStream implements ISymptomSorter {

	/**
	 * 
	 * Sorts symptoms map using a stream
	 * 
	 * @param Map(String symptom, Integer count) : map of all Symptoms counts
	 * @return Map(String symptom, Integer count) :sorted Map Symptom counts
	 * 
	 * @see ISymptomCounter#sortSymptoms
	 */
	@Override
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsMap) {

		return symptomsMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

}
