package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Reads, counts and exports symptoms trend analysis
 *
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
			readCountSortExportSymptoms(args[0]);
		} else {
			readCountSortExportSymptoms("symptoms.txt");
		}
	}

	/**
	 * read symptoms from file, count, sort then export result to file
	 * 
	 * @param symptomsFilePath : a full or partial path to file with symptom strings in it, one per line
	 * @see SymptomReadDataFromFile#getSymptoms
	 * @see SymptomCountWithStream#symptomCountFromList
	 * @see SymptomSortWithStream#sortSymptoms
	 * @see SymptomExportDataToFile#exportSymptoms
	 */
	private static void readCountSortExportSymptoms(String symptomsFilePath) {
		// read from file
		final ISymptomReader symptomReader = new SymptomReadDataFromFile(symptomsFilePath);
		final List<String> symptomsList = symptomReader.getSymptoms();
		if (symptomsList.isEmpty()) {
			System.out.println("No symptom was imported.");
		} else {
			// count symptoms
			Map<String, Long> symptomsMap = (new SymptomCountWithStream()).symptomCountFromList(symptomsList);
			// sort symptoms
			symptomsMap = (new SymptomSortWithStream()).sortSymptoms(symptomsMap);
			// export to file
			final String exportFilePath = "results.out";
			final ISymptomExporter symptomExporter = new SymptomExportDataToFile(exportFilePath);
			final boolean success = symptomExporter.exportSymptoms(symptomsMap);
			if (!success) {
				System.out.println("Result not exported to file");
			} else {
				System.out.println("Result successfully exported to " + exportFilePath);
			}
		}
	}
}
