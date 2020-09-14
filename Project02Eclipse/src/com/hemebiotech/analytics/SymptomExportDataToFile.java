package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class SymptomExportDataToFile implements ISymptomExporter {

	private String exportFilePath;

	/**
	 * 
	 * @param filepath a full or partial path to file to export symptoms counts
	 */
	public SymptomExportDataToFile(String filepath) {
		this.exportFilePath = filepath;
	}

	/**
	 * sort results and export to file
	 * 
	 * @param symptomsCountMap
	 */
	@Override
	public boolean exportSymptoms(Map<String, Integer> symptomsMap) {
		// check export file exists
		if ((new File(this.exportFilePath).exists())) {
			// Ask if user wants to overwrite the export file
			Scanner input = new Scanner(System.in);
			String answer;
			do {
				System.out.print("File exists, do you wish to overwrite " + this.exportFilePath + "? (Y/N): ");
				answer = input.next().trim().toUpperCase();
			} while (!answer.matches("[YN]"));
			input.close();
			if (answer.toUpperCase().equalsIgnoreCase("N")) {
				// abort
				return false;
			}
		}
		// sort symptoms
		Map<String, Integer> sortedSymptomsMap = new TreeMap<String, Integer>(symptomsMap);
		// write to file
		try {
			FileWriter writer = new FileWriter(this.exportFilePath);
			// write symptoms counts
			String symptom;
			int count;
			Iterator<String> iterator = sortedSymptomsMap.keySet().iterator();
			while (iterator.hasNext()) {
				symptom = iterator.next();
				count = sortedSymptomsMap.get(symptom);
				writer.write(symptom + ": " + count + "\n");
			}
			writer.close();

		} catch (IOException e) {
			System.out.println("File does not exist, or is a directory, or cannot be opened for any other reason.");
			return false;

		} catch (ClassCastException e) {
			System.out.println("Symptoms list contains wrong type elements that are not mutually comparable.");
			return false;

		} catch (NullPointerException e) {
			System.out.println("Specified symptoms colelction is null");
			return false;
		}
		// success
		return true;
	}

}
