package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import com.hemebiotech.analytics.*;

public class Main {

    public static void main(String[] args) {

        // Instantiation d'un objet ISymptomReader
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

        // Instantiation d'un objet ISymptomWriter
        ISymptomWriter writer = new WriteSymptomDataToFile();

        // Instantiation d'un objet AnalyticsCounter
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Récupère la liste des symtpomes
        List<String> symptomsList = reader.getSymptoms();

        // Récupère la liste des symtpomes, comptes les occurences
        Map<String, Integer> symptomsMap = counter.countSymptoms(symptomsList);

        // Récupère la collection des symptomes, puis on la trie alphabétiquement
        Map<String, Integer> symptomsMapSorted = counter.sortSymptoms(symptomsMap);

        writer.writeSymptoms(symptomsMapSorted);

    }

}
