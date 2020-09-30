package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will count symptoms occurrences from a list.
 * Must return a map of unique symptoms strings paired with associated count
 * 
 */
public interface ISymptomCounter {
	/**
	 * If no data is available, return an emptyMap
	 * 
	 * @param symptomsList : list of all Symptoms
	 * @return Map(String symptom, Integer count) : map of Symptoms counts obtained from the List
	 */
	Map<String, Long> symptomCountFromList(List<String> symptomsList);
}
