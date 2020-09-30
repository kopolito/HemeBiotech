package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of Symptom Counter
 * 
 * @see ISymptomReader
 *
 */
public class SymptomCount implements ISymptomCounter {

	/**
	 * 
	 * Symptom counter
	 */
	public SymptomCount() {

	}

	/**
	 * count symptoms occurrences in symptomList
	 * 
	 * If no data is available, return an empty Map
	 * 
	 * @return Map(String symptom, Integer count) : map of all Symptoms counts obtained from list
	 * 
	 * @see ISymptomCounter#symptomCountFromList
	 */
	@Override
	public Map<String, Long> symptomCountFromList(List<String> symptomsList) {
		final Map<String, Long> symptomsMap = new HashMap<String, Long>();
		if (symptomsList == null || symptomsList.isEmpty()) {
			System.out.println("Empty or Null List provided toi SymptomCounter !");
			return symptomsMap;
		}
		for (String symptom : symptomsList) {
			if (symptomsMap.containsKey(symptom)) {
				symptomsMap.put(symptom, symptomsMap.get(symptom) + 1);
			} else {
				symptomsMap.put(symptom, (long) 1);
			}
		}
		return symptomsMap;
	}

}
