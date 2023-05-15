package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class AnalyticsCounter {  
  private static int headacheCount = 0;
  private static int rashCount = 0;
  private static int pupilCount = 0;
  public ISymptomReader reader;
  public ISymptomWriter writer;

  /**
    * Some javadoc.
    * Constructor containing two parameters for symptom analysis
    * 
    * 
    * @param reader : Symptom Reader object which will read symptom data from a source
    * @param writer : Symptom Writer object which will writer symptom data on a source
    */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  /**
    * Some javadoc.
    * Call the getSymptoms method on the source document
    * Return a list of symptoms in String format
    */
  public List<String> getSymptoms() {
    return reader.getSymptoms();
  }

  /**
    * Some javadoc.
    * Get a list of symptoms in String format and return a collection in String, Integer format
    * Will get all occurrences of each symptom and count the repetitions
    *
    * @param symptoms : Corresponds to the list of symptoms from the input data
    */
  public Map<String, Integer> countSymptoms(List<String> symptoms) { 
    Map<String, Integer> symptomsMap = new HashMap<>();
    for (String symptom : symptoms) {          
      if (symptomsMap.containsKey(symptom)) { 
        int count = symptomsMap.get(symptom); 
        symptomsMap.put(symptom, count + 1); 
      } else {
        symptomsMap.put(symptom, 1);
      }
    }
    return symptomsMap;
  }

  /**
    * Some javadoc.
    * Get a collection in String, Integer format and will sort it alphabetically
    *     
    * @param symptoms : List of symptoms with theirs amounts from the input data
    */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    Map<String, Integer> symptomsSortedAlphabetically = new TreeMap<>(symptoms);
    return symptomsSortedAlphabetically;
  }
}