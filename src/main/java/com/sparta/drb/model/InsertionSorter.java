package com.sparta.drb.model;

public class InsertionSorter implements Sorter {
    public int[] sortArray(int[] arrayToSort) {

        if (arrayToSort.length < 1) {
            return null;
        }
        for (int i=1; i< arrayToSort.length; ++i){
            int key = arrayToSort[i];
            int j = i-1;

            while (j>=0 && arrayToSort[j] > key) {
                arrayToSort[j+1] = arrayToSort[j];
                j = j-1;
            }
            arrayToSort[j+1] = key;
        }
        return arrayToSort;
    }
    @Override
    public String toString() {
        return "Insertion Sorter";
    }
}
