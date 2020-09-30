package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Sorts symptoms map
 */
public interface ISymptomSorter {
	/**
	 * If no data is available, return an emptyMap
	 * 
	 * @param symptomsMap Map(String symptom, Long count) : map of all Symptoms counts
	 * @return Map(String symptom, Long count) :sorted Map Symptom counts
	 *         source
	 */

	public Map<String, Long> sortSymptoms(Map<String, Long> symptomsMap);

}
