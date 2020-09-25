package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Implementation of Symptom Counter
 * 
 * @see ISymptomReader
 *
 */
public class SymptomCountWithStream implements ISymptomCounter {

	/**
	 * 
	 * Symptom counter
	 */
	public SymptomCountWithStream() {

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
	public Map<String, Integer> symptomCountFromList(List<String> symptomsList) {
		if (symptomsList == null || symptomsList.isEmpty()) {
			System.out.println("Empty or Null List provided toi SymptomCounter !");
			return new HashMap<String, Integer>();
		}
		// // count with Long Type result
		// Map<String, Long> longCountSymptomsMap = symptomsList.stream()
		// .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		// // convert Map<String, Long> to Map<String, Integer>
		// Map<String, Integer> symptomsMap = longCountSymptomsMap.entrySet().stream()
		// .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().intValue()));
		//

		// custom collector to count with Integers
		Collector<String, ?, Integer> totalSymptomCountCollector = Collector.of(
				() -> new int[1],
				(resultCount, symptom) -> resultCount[0] += 1,
				(resultCount1, resultCount2) -> {
					resultCount1[0] += resultCount2[0];
					return resultCount1;
				},
				total -> total[0]);

		// count bis
		Map<String, Integer> intCountSymptomMap = symptomsList.stream()
				.collect(Collectors.groupingBy(Function.identity(), totalSymptomCountCollector));

		return intCountSymptomMap;
	}

}
