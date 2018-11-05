package com.sparta.drb;

import com.sparta.drb.Exceptions.FactoryException;
import com.sparta.drb.controller.SortFactory;
import com.sparta.drb.controller.SortManager;
import com.sparta.drb.model.*;
import com.sparta.drb.view.Display;
import com.sparta.drb.view.SortView;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class SorterTester {
    private static int[] unsortedArray;
    private int[] sortedArray;
    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    Logger log = Logger.getLogger(SortView.class.getName());


    private static void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);

    }

    @BeforeClass
    public static void setClass() {
        initialiseLogging();
        Random random = new Random();
        unsortedArray = new int[10];
        for (int i = 0; i < 10; i++) {
            unsortedArray[i] = random.nextInt(100) + 1;
        }
    }

    @Test
    public void testBubbleSort() {
        Sorter sorter = new BubbleSorter();
        sortedArray = sorter.sortArray(unsortedArray.clone());
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testBubbleSortedArrayLength() {
        Sorter sorter = new BubbleSorter();
        sortedArray = sorter.sortArray(unsortedArray.clone());
        assertEquals(unsortedArray.length, sortedArray.length);
    }

    @Test
    public void testBinarySorter() {
        Sorter sorter = new BinarySorter();
        sortedArray = sorter.sortArray(unsortedArray.clone());
        assertEquals(unsortedArray.length, sortedArray.length);
    }

    @Test
    public void testQuickSort() {
        Sorter sorter = new QuickSorter();
        sortedArray = sorter.sortArray(unsortedArray.clone());
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testNegativeQuickSort() {
        int[] negativeUnsortedArray = {-1, -5, 3, 8};
        Sorter sorter = new QuickSorter();
        sortedArray = sorter.sortArray(negativeUnsortedArray);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testNegativeBubbleSort() {
        int[] negativeUnsortedArray1 = {-1, -5, 3, 8};
        Sorter sorter = new BubbleSorter();
        sortedArray = sorter.sortArray(negativeUnsortedArray1);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testNegativeInsertionSort() {
        int[] negativeUnsortedArray2 = {-1, -5, 3, 8};
        Sorter sorter = new InsertionSorter();
        sortedArray = sorter.sortArray(negativeUnsortedArray2);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testNegativeMergeSort() {
        int[] negativeUnsortedArray1 = {-1, -5, 3, 8};
        Sorter sorter = new MergeSorter();
        sortedArray = sorter.sortArray(negativeUnsortedArray1);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testEmptyMergeSort() {
        int[] emptyUnsortedArray = {};
        Sorter sorter = new MergeSorter();
        sortedArray = sorter.sortArray(emptyUnsortedArray);
        assertNull(sortedArray);
    }

    @Test
    public void testEmptyQuickSort() {
        int[] emptyUnsortedArray = {};
        Sorter sorter = new QuickSorter();
        sortedArray = sorter.sortArray(emptyUnsortedArray);
        assertNull(sortedArray);
    }

    @Test
    public void testEmptyInsertionSort() {
        int[] emptyUnsortedArray = {};
        Sorter sorter = new InsertionSorter();
        sortedArray = sorter.sortArray(emptyUnsortedArray);
        assertNull(sortedArray);
    }

    @Test
    public void testEmptyBubbleSort() {
        int[] emptyUnsortedArray = {};
        Sorter sorter = new BubbleSorter();
        sortedArray = sorter.sortArray(emptyUnsortedArray);
        assertNull(sortedArray);
    }

    @Test
    public void testInsertionSort() {
        Sorter sorter = new InsertionSorter();
        sortedArray = sorter.sortArray(unsortedArray.clone());
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testMergeSort() {
        Sorter sorter = new MergeSorter();
        sortedArray = sorter.sortArray(unsortedArray.clone());
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testDisplay() {
        Display testView = new SortView();
        testView.display(unsortedArray, "bubble");
    }
}

//    @Test
//    public void testToString() throws FactoryException{
//        Sorter instancedSorter = SortFactory.getInstance("bubble");
//        assertTrue(instancedSorter.toString().equals("Bubble Sorter"));
//        Sorter instancedSorter2 = SortFactory.getInstance("merge");
//        assertTrue(instancedSorter2.toString().equals("Merge Sorter"));
//        Sorter instancedSorter3 = SortFactory.getInstance("insertion");
//        assertTrue(instancedSorter3.toString().equals("Insertion Sorter"));
//        Sorter instancedSorter4 = SortFactory.getInstance("quick");
//        assertTrue(instancedSorter4.toString().equals("Quick Sorter"));
//
//    }
//    @Test
//    public void testSortFactory() throws FactoryException {
//        Sorter instancedSorter = SortFactory.getInstance("bubble");
//        assertTrue(instancedSorter instanceof BubbleSorter);
//        Sorter instancedSorter2 = SortFactory.getInstance("merge");
//        assertTrue(instancedSorter2 instanceof MergeSorter);
//        Sorter instancedSorter3 = SortFactory.getInstance("insertion");
//        assertTrue(instancedSorter3 instanceof InsertionSorter);
//        Sorter instancedSorter4 = SortFactory.getInstance("quick");
//        assertTrue(instancedSorter4 instanceof QuickSorter);
//        Sorter instancedSorter5 = SortFactory.getInstance("whatever");
//        assertTrue(instancedSorter5 == null);
//    }
//}
