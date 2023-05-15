package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

  private String filepath;

  /**
   * Some javadoc. 
   * Constructor containing one parameter to take the filepath.
   *
   * @param filepath a full or partial path to file with symptom strings in it, one per line
   */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  /**
    * Some javadoc.
    * Retrieves the data on each line of a ".txt" file then adds it to a list of String
    * 
    */
  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<String>();
    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        
        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return result;
  }

}