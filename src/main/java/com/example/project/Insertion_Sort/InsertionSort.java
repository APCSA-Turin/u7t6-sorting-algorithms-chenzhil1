package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int count  = 0;
        for(int i = 1; i < elements.length; i ++) {
            int idxCompare = i;
            while(idxCompare -1 >= 0 && elements[i] < elements[idxCompare - 1]) {
                idxCompare --;
                count ++;
            }
            int temp = elements[i];
            for(int j = i - 1; j >= idxCompare; j --) {
                elements[j + 1] = elements[j];
            }
            elements[idxCompare] = temp;
        }
        System.out.println("INSERTION SORT: Numbers of iterations: " + count);
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        int count = 0;
        for(int i = 0; i < elements.length; i ++) {
            int temp = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = i + 1; j < elements.length; j ++) {
                count ++;
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
        System.out.println("SELECTION SORT: Numbers of iterations: " + count);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int count = 0;
        for(int i = 0; i < words.size(); i ++) {
            int idxCompare = i;
            while(idxCompare - 1 >= 0 && words.get(i).compareTo(words.get(idxCompare - 1)) < 0){
                count ++;
                idxCompare --;
            }
            String temp = words.get(i);
            for(int j = i - 1; j >= idxCompare; j --) {
                words.set(j + 1, words.get(j));
            }
            words.set(idxCompare, temp);

        }
        System.out.println("INSERTION SORT: Numbers of iterations: " + count);
        return words;
    }

    public static ArrayList<String> selectionSortWordList(ArrayList<String> words) {
        int count = 0;
        for(int i = 0; i < words.size();i ++) {
            String temp = "zzzzzzz";
            int minIndex = -1;
            for(int j = i + 1; j < words.size();j ++) {
                count ++;
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
        System.out.println("SELECTION SORT: Numbers of iterations: " + count);
        return words;
    }

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
        int[] arrA = {90,60,37,48,12,3,74,80,82,7,27,11,63,9,59,79,100,43,47,5,33,71,26,14,20};
        InsertionSort.selectionSort(arrA);
        System.out.println(Arrays.toString(arrA));
        System.out.println();
        int[] arrB = {90,60,37,48,12,3,74,80,82,7,27,11,63,9,59,79,100,43,47,5,33,71,26,14,20};
        InsertionSort.insertionSort(arrB);
        System.out.println(Arrays.toString(arrB));

    }

   
}