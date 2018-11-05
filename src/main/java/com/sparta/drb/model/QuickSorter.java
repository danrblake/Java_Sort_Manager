package com.sparta.drb.model;

public class QuickSorter implements Sorter {
        private int[] array;
        public int[] sortArray(int [] arrayToSort) {
            if(arrayToSort == null || arrayToSort.length == 0) {
                return null;
            }
            this.array = arrayToSort;
            quickSort(0, arrayToSort.length-1);
            return array;
        }

        private void quickSort(int left, int right) {
            int i = left;
            int j = right;
            int pivot = array[(left+right)/2];

            while(i<=j) {
                while(array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }
                if(i<=j){
                    swap(i,j);
                    i++;
                    j--;
                }
            }
            if(left < j){
                quickSort(left,j);
            }
            if (i < right) {
                quickSort(i, right);
            }
        }

        private void swap(int i, int j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    @Override
    public String toString() {
        return "Quick Sorter";
    }
}
