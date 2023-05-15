package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter {

  private String filepath;

  /**
   * Some javadoc. 
   * Constructor containing one parameter to take the filepath.
   *
   * @param filepath a full or partial path 
   */
  public WriteSymptomDataToFile(String filepath) {
    this.filepath = filepath;
  }
      
  /**
    * Some javadoc.
    * Writes in an output file all the symptoms, one per line with their respective quantities
    * 
    * @param symptoms : List of symptoms from the input data sorted alphabetically
    */
  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) { 
    try {
      FileWriter writer = new FileWriter(filepath);
      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        String symptom = entry.getKey();
        writer.write(symptom + " : " + entry.getValue().toString() + "\n");
      } 
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}