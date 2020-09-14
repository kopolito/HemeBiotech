package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Symptom Reader, reads and count symptoms to HashMap
 * 
 * @see ISymptomReader
 *
 */
public class SymptomReadDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public SymptomReadDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * open file with filepath, read and count symptoms lines
	 * 
	 * @return symptomsMap (String symptom : Integer count) : map of all Symptoms counts obtained from a
	 *         data
	 *         source, empty map if file not found
	 * 
	 * @see ISymptomReader#getSymptoms
	 */
	@Override
	public Map<String, Integer> getSymptoms() {
		final Map<String, Integer> symptomsMap = new HashMap<String, Integer>();

		if (filepath != null) {
			try {
				//
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String symptomLine = reader.readLine();

				while (symptomLine != null) {
					symptomLine = symptomLine.trim();
					if (symptomsMap.containsKey(symptomLine)) {
						symptomsMap.put(symptomLine, symptomsMap.get(symptomLine) + 1);
					} else {
						symptomsMap.put(symptomLine, 1);
					}
					symptomLine = reader.readLine();
				}
				reader.close();
				System.out.println("Success reading file " + filepath);

			} catch (FileNotFoundException e) {
				System.out.println("Error : Could not find file " + filepath);
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("Erreur : Failed reading file " + filepath);
			}
		}

		return symptomsMap;
	}

}
