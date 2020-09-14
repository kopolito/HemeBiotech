package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an emptyMap
	 * 
	 * @return Map<String symptom, Integer count> : map of all Symptoms counts obtained from a data source
	 */
	Map<String, Integer> getSymptoms();
}
