package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Some javadoc.
 * Anything the will write symptom data on a valid data output format
 *
 * @return a listing of all Symptoms obtained from a data source with their amount.
 */
public interface ISymptomWriter {
  void writeSymptoms(Map<String, Integer> symptoms);
}
