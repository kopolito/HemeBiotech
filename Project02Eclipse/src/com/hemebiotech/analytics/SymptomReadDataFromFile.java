package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Symptom Reader, reads symptoms to List
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
	 * If no data is available, return an emptyList
	 * 
	 * @return List(String symptom) : list of all Symptoms obtained from a data
	 *         source
	 * 
	 * @see ISymptomReader#getSymptoms
	 */
	@Override
	public List<String> getSymptoms() {
		final List<String> symptomsList = new ArrayList<String>();

		if (filepath != null) {
			try {
				//
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String symptomLine = reader.readLine();

				while (symptomLine != null) {
					symptomsList.add(symptomLine);
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

		return symptomsList;
	}

}
