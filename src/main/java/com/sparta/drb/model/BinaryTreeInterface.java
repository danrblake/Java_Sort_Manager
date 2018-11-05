package com.sparta.drb.model;

import com.sparta.drb.Exceptions.ChildNotFoundException;

public interface BinaryTreeInterface {

    public interface BinaryTree {
        int getRootElement();

        int getNumberOfElements();

        void addElement(int element);

        void addElements(int[] elements);

        boolean findElement(int value);

        int getLeftChild(int element) throws ChildNotFoundException;

        int getRightChild(int element) throws ChildNotFoundException;

        int[] getSortedTreeAsc();

        int[] getSortedTreeDesc();
    }

}
