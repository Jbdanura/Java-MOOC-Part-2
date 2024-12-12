/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jotabe
 */
package dictionary;

import java.io.*;
import java.util.*;

public class SaveableDictionary {
    private Map<String, String> dictionary;
    private Map<String, String> reverseDictionary; 
    private String fileName;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
        this.reverseDictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.fileName = file;
    }

    public void add(String word, String translation) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, translation);
            reverseDictionary.put(translation, word); 
        }
    }

    public String translate(String word) {

        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }

        else if (reverseDictionary.containsKey(word)) {
            return reverseDictionary.get(word);
        }

        return null;
    }

    public void delete(String word) {
        if (dictionary.containsKey(word)) {
            String translation = dictionary.remove(word);
            reverseDictionary.remove(translation);
        } else if (reverseDictionary.containsKey(word)) {
            String finnishWord = reverseDictionary.remove(word);
            dictionary.remove(finnishWord);
        }
    }


    public boolean load() {
        if (fileName == null) {
            return false;
        }

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    add(parts[0], parts[1]);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public boolean save() {
        if (fileName == null) {
            return false;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}


