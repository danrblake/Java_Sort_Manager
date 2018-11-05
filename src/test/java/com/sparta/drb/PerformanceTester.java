package com.sparta.drb;

import com.sparta.drb.model.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {

    private static int[] arrayToSort;
    private int[] unsortedArray;

    @BeforeClass
    public static void setupClass(){
        Random rand = new Random();
        arrayToSort = new int[100_000];
        for(int i = 0; i < arrayToSort.length; i++){
            arrayToSort[i] = rand.nextInt(100_000);
        }
    }

    @Before
    public void setup(){
        unsortedArray = arrayToSort.clone();
    }

    @Test
    public void testBubbleSort(){
        Sorter bubbleSorter = new BubbleSorter();
        long start = System.nanoTime();
        int[] sortedArray = bubbleSorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(bubbleSorter.toString(),end-start,sortedArray);
    }
    @Test
    public void testMergeSort(){
        Sorter bubbleSorter = new MergeSorter();
        long start = System.nanoTime();
        int[] sortedArray = bubbleSorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(bubbleSorter.toString(),end-start,sortedArray);
    }
    @Test
    public void testQuickSort(){
        Sorter bubbleSorter = new QuickSorter();
        long start = System.nanoTime();
        int[] sortedArray = bubbleSorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(bubbleSorter.toString(),end-start,sortedArray);
    }
    @Test
    public void testBinarySort(){
        Sorter bubbleSorter = new BinarySorter();
        long start = System.nanoTime();
        int[] sortedArray = bubbleSorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(bubbleSorter.toString(),end-start,sortedArray);
    }
    @Test
    public void testInsertionSort(){
        Sorter bubbleSorter = new InsertionSorter();
        long start = System.nanoTime();
        int[] sortedArray = bubbleSorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(bubbleSorter.toString(),end-start,sortedArray);
    }
    private void printResults(String sorter, long time, int[] sortedArray){
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println(sorter + ":");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Time taken: " + (df.format(time)) + " nano seconds");
    }
}
