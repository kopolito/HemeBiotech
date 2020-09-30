package com.hemebiotech.analytics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of Symptom Sorter, using a stream
 * 
 * @see ISymptomSorter
 *
 */
public class SymptomSortWithStream implements ISymptomSorter {

	/**
	 * 
	 * Sorts symptoms map using a stream
	 * 
	 * @param symptomsMap Map(String symptom, Long count) : map of all Symptoms counts
	 * @return Map(String symptom, Long count) :sorted Map Symptom counts
	 * 
	 * @see ISymptomSorter#sortSymptoms
	 */
	@Override
	public Map<String, Long> sortSymptoms(Map<String, Long> symptomsMap) {

		return symptomsMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

}
