package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.*;

public class WriteSymptomDataToFile implements ISymptomWriter {
    public Map<String, Integer> WriteSymptomDataToFile(){
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        Map<String, Integer> symptoms = new HashMap<>();
        List<String> symptomsList = reader.getSymptoms();
        for(String symptom : symptomsList ){          
            if (symptoms.containsKey(symptom)) { // si l'élément existe déjà dans la map
                int count = symptoms.get(symptom); // on récupère la valeur associée à la clé
                symptoms.put(symptom, count + 1); // on incrémente la valeur et on met à jour la map
            } else {
                symptoms.put(symptom, 1); // sinon on ajoute l'élément à la map avec une valeur de 1
            }
        }
        return symptoms;
    }
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){ 
        if ("result.out" != null) {
            try {
                    FileWriter writer = new FileWriter ("result.out");
                    for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                        String symptom = entry.getKey();
                        writer.write( symptom + " : " + entry.getValue().toString()+ "\n");
                    } 
                }
            catch (IOException e) {
				        e.printStackTrace();
			    }
        };
    }
}