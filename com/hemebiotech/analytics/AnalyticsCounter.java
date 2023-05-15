package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class AnalyticsCounter{
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;	
	public ISymptomReader reader;
    public ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
        }
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int rowCounter = 0;	
		int headCount = 0;	
		while (line != null) {
			rowCounter++; // 	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}
			line = reader.readLine();	// get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms (List<String> symptoms) { 
        Map<String, Integer> symptomsMap = new HashMap<>();
        for(String symptom : symptoms ){          
            if (symptomsMap.containsKey(symptom)) { 
                int count = symptomsMap.get(symptom); 
                symptomsMap.put(symptom, count + 1); 
            } else {
                symptomsMap.put(symptom, 1);
            }
        }
        return symptomsMap;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    Map<String, Integer> symptomsSortedAlphabetically = new TreeMap<>(symptoms);
    return symptomsSortedAlphabetically;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) { 

    }
  

}