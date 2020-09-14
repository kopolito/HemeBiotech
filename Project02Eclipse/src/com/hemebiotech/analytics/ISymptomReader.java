package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will read symptom data from a source.
 * Must return a map of unique symptoms strings paired with associated count
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an emptyMap
	 * 
	 * @return Map(String symptom, Integer count) : map of all Symptoms counts obtained from a data
	 *         source
	 */
	Map<String, Integer> getSymptoms();
}
