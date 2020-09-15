package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Reads, counts and exports symptoms trend analysis
 *
 * @param args : symptom file's path
 */
public class AnalyticsCounter {

	/**
	 * The application's entry point
	 *
	 * @param args : symptom file's path
	 */
	public static void main(String args[]) {
		// first argument may contains custom symptom file's path
		if (args.length > 0) {
			readCountExportSymptoms(args[0]);
		} else {
			readCountExportSymptoms("symptoms.txt");
		}
	}

	/**
	 * read and count symptoms from file, then export result to file
	 * 
	 * @see SymptomReadDataFromFile
	 * @see SymptomExportDataToFile
	 */
	private static void readCountExportSymptoms(String symptomsFilePath) {
		// read and count from file
		final SymptomReadDataFromFile symptomReader = new SymptomReadDataFromFile(symptomsFilePath);
		final Map<String, Integer> symptomsMap = symptomReader.getSymptoms();
		// export to file
		if (symptomsMap.size() == 0) {
			System.out.println("No symptom was imported.");
		} else {
			final String exportFilePath = "results.out";

			final SymptomExportDataToFile symptomExporter = new SymptomExportDataToFile(exportFilePath);
			final boolean success = symptomExporter.exportSymptoms(symptomsMap);
			if (!success) {
				System.out.println("Result not exported to file");
			} else {
				System.out.println("Result successfully exported to " + exportFilePath);
			}
		}
	}
}
