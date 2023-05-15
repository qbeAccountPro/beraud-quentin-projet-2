package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything the will write symptom data on a valid data output format
 *
 */
public interface ISymptomWriter {
    /**
	 * @return a listing of all Symptoms obtained from a data source with their amount.
	 * 
	 */
     void writeSymptoms(Map<String, Integer> symptoms);
}
