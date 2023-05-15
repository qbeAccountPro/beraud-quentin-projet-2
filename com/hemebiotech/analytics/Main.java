package com.hemebiotech.analytics;

import com.hemebiotech.analytics.AnalyticsCounter;
import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.WriteSymptomDataToFile;
import java.util.List;
import java.util.Map;


public class Main {
  /**
    
    * The main method of the program.
    * Create an instance of the different object, writer, reader and counter
    * And call different functions of each.
    */
  public static void main(String[] args) {
    // Instantiate a Symptom Reader object
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

    // Instantiate a Symptom Writer object
    ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

    // Instantiate a Symptom Counter object
    AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

    // Retrieve the list of symptoms
    List<String> symptomsList = reader.getSymptoms();

    // Retrieve the list of symptoms then count the occurrences
    Map<String, Integer> symptomsMap = counter.countSymptoms(symptomsList);

    // Get the collection of symptoms, then sort alphabetically
    Map<String, Integer> symptomsMapSorted = counter.sortSymptoms(symptomsMap);

    // Write the file with the list of symptoms and their quantities
    writer.writeSymptoms(symptomsMapSorted);
  }
}
