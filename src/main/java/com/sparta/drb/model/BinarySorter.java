package com.sparta.drb.model;

import java.util.Arrays;

public class BinarySorter implements Sorter {

    public int[] sortArray(int[] arrayToSort) {
        BinaryTree newTree = new BinaryTree();
        newTree.addElements(arrayToSort);
        return newTree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "Binary Sorter";
    }
}
