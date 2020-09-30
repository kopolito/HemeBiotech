package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will export ordered symptoms count to a file
 * 
 * @see SymptomExportDataToFile
 */
public interface ISymptomExporter {
	/**
	 * 
	 * @param symptomsMap (String symptom : Integer count)
	 * @return boolean for successful export
	 * @see SymptomExportDataToFile#exportSymptoms
	 */
	boolean exportSymptoms(Map<String, Long> symptomsMap);
}
