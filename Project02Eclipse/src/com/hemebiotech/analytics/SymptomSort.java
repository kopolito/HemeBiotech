package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation of Symptom Sorter
 * 
 * @see ISymptomSorter
 *
 */
public class SymptomSort implements ISymptomSorter {

	/**
	 * 
	 * Sorts symptoms map using TreeMap
	 * 
	 * @param symptomsMap Map(String symptom, Integer count) : map of all Symptoms counts
	 * @return Map(String symptom, Integer count) :sorted Map Symptom counts
	 * 
	 * @see ISymptomSorter#sortSymptoms
	 */
	@Override
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsMap) {

		return new TreeMap<String, Integer>(symptomsMap);
	}

}
