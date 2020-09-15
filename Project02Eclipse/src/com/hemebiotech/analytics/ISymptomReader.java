package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source.
 * Must return a list of symptoms
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an emptyList
	 * 
	 * @return List(String symptom) : list of all Symptoms obtained from a data
	 *         source
	 */
	List<String> getSymptoms();
}
