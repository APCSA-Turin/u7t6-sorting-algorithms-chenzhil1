package com.example.project.Selection_Sort;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class SelectionSort {

    // PART A. implementing selection sort
    public static int[] selectionSort(int[] elements) {
        for(int i = 0; i < elements.length; i ++) {
            int temp = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = i + 1; j < elements.length; j ++) {
                if(elements[j] < temp) {
                    temp = elements[j];
                    minIndex = j;
                }
            }
            if(minIndex != -1 && elements[minIndex] < elements[i]) {
                elements[minIndex] = elements[i];
                elements[i] = temp;
            }
        }
        return elements;
    }


    // PART B. sorting a 1000-word list
    public static ArrayList<String> selectionSortWordList(ArrayList<String> words) {
        for(int i = 0; i < words.size();i ++) {
            String temp = "zzzzzzz";
            int minIndex = -1;
            for(int j = i + 1; j < words.size();j ++) {
                if(words.get(j).compareTo(temp) < 1) {
                    minIndex = j;
                    temp = words.get(j);
                }
            }
            if(minIndex != -1 && words.get(minIndex).compareTo(words.get(i)) < 1) {
                words.set(minIndex, words.get(i));
                words.set(i, temp);
            }
            
        }
        return words;
    }

    //call this method to load 1000 words into list. Use it to test Part B
    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

    public static void main(String[] args) {
        int[] elements = {3,5,6,8,4,2,1};
        elements = selectionSort(elements);
        for(int num : elements) {
            System.out.println(num);
        }
    }
}
