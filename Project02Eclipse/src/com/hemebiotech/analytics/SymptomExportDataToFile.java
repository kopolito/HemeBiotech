package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Implementation of Symptom Exporter, sorts and exports symptoms to file
 * 
 * @see ISymptomExporter
 *
 */
public class SymptomExportDataToFile implements ISymptomExporter {

	private String exportFilePath;

	/**
	 * 
	 * @param filepath a full or partial path to file to export symptoms counts
	 * 
	 */
	public SymptomExportDataToFile(String filepath) {
		this.exportFilePath = filepath;
	}

	/**
	 * sort results and export to file
	 * 
	 * @param symptomsMap (String symptom : Integer count)
	 * 
	 * @see ISymptomExporter#exportSymptoms
	 */
	@Override
	public boolean exportSymptoms(Map<String, Long> symptomsMap) {
		// write to file
		try {
			FileWriter writer = new FileWriter(this.exportFilePath);
			// write symptoms counts
			String symptom;
			long count;
			Iterator<String> iterator = symptomsMap.keySet().iterator();
			while (iterator.hasNext()) {
				symptom = iterator.next();
				count = symptomsMap.get(symptom);
				writer.write(symptom + ": " + count + "\n");
				System.out.println(symptom + ": " + count);
			}
			writer.close();

		} catch (IOException e) {
			System.out.println("File does not exist, or is a directory, or cannot be opened for any other reason.");
			return false;

		} catch (ClassCastException e) {
			System.out.println("Symptoms list contains wrong type elements that are not mutually comparable.");
			return false;

		} catch (NullPointerException e) {
			System.out.println("Specified symptoms collection is null");
			return false;
		}
		// success
		return true;
	}

}
