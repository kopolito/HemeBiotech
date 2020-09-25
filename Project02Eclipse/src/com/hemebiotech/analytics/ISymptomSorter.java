package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Sorts symptoms map
 */
public interface ISymptomSorter {
	/**
	 * If no data is available, return an emptyMap
	 * 
	 * @return Map(String symptom, Integer count) :sorted Map Symptom counts
	 *         source
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsMap);

}
