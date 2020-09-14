package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will export ordered symptoms count to a file
 * 
 */
public interface ISymptomExporter {
	/**
	 * 
	 * @param SortedMap<String, Integer> sortedSymptomsMap
	 * @return boolean for successful export
	 */
	boolean exportSymptoms(Map<String, Integer> symptomsMap);
}
