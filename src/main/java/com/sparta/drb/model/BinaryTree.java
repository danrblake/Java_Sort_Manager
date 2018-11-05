package com.sparta.drb.model;

import com.sparta.drb.Exceptions.ChildNotFoundException;
import com.sparta.drb.controller.SortManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BinaryTree implements BinaryTreeInterface {

    private Node root;
    private int count = 1;
    private int index;

    private final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    Logger log = Logger.getLogger(BinaryTree.class.getName());
    private  void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);

    }

    private class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        private Node(int data) {
            this.data = data;
        }
    }

     public int[] sortArray(int[] arrayToSort){
        addElements(arrayToSort);
        return getSortedTreeAsc();
    }

    public int getRootElement(){
        return root.data;
    }

    public void addElement(int element){
        initialiseLogging();
        Node newNode = new Node(element);
        if(root == null){
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            boolean complete = false;
            while(!complete){
                parent = focusNode;
                if(element < focusNode.data){
                    focusNode = focusNode.leftChild;
                    if(focusNode == null) {
                        parent.leftChild = newNode;
//                        log.info("Node created with value - " + parent.leftChild.data + ". This is the left child of " +parent.data);
                        complete = true;
                        count++;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if(focusNode == null) {
                        parent.rightChild = newNode;
//                        log.info("Node created with value - " + parent.rightChild.data + ". This is the right child of " +parent.data);
                        complete = true;
                        count++;
                    }
                }
            }
        }
    }
    public void addElements(int[] array){
        for (int i=0; i< array.length; i++){
            addElement(array[i]);
        }
    }

    public int getLeftChild(int element) throws ChildNotFoundException {
        Node focusNode = root;
        if (focusNode.data == element) {
            return focusNode.leftChild.data;
        }
        while (focusNode.data != element) {
            if (focusNode.data < element) {
                focusNode = focusNode.rightChild;
            } else if (focusNode.data > element) {
                focusNode = focusNode.leftChild;
            }

        }  try {
            return focusNode.leftChild.data;
        } catch (NullPointerException e) {
            throw new ChildNotFoundException("No left child");
        }

    }
    public int getRightChild(int element) throws ChildNotFoundException {
        Node focusNode = root;
        if (focusNode.data == element) {
            return focusNode.rightChild.data;
        }
        while (focusNode.data != element) {
            if (focusNode.data < element) {
                focusNode = focusNode.rightChild;
            } else if (focusNode.data > element) {
                focusNode = focusNode.leftChild;
            }
        }
        try {
            return focusNode.rightChild.data;
        } catch (NullPointerException e) {
            throw new ChildNotFoundException("No right child");
        }
    }

    public boolean findElement(int value) {
        Node focusNode = root;
        boolean found = false;
        boolean finished = false;
        if (focusNode.data == value) {
            found = true;
        } else {
            while(!finished) {
                if(value == focusNode.data){
                    found = true;
                    finished = true;
                } else if(value < focusNode.data && focusNode.leftChild == null){
                    finished = true;
                } else if(value > focusNode.data && focusNode.rightChild == null){
                    finished = true;
                }
                else if (value < focusNode.data) {
                    focusNode = focusNode.leftChild;
                } else if (value > focusNode.data) {
                    focusNode = focusNode.rightChild;
                } else  {
                    finished = true;
                }
            }
        } return found;
    }

    public int getNumberOfElements(){
        return count;
    }


    public int[] getSortedTreeAsc(){
        index = 0;
        int[] returningArray = new int[getNumberOfElements()];
        Node focusNode = root;
        fillArrayAsc(focusNode, returningArray);
        return returningArray;
    }
    public int[] getSortedTreeDesc(){
        index = 0;
        int[] returningArray = new int[getNumberOfElements()];
        Node focusNode = root;
        fillArrayDesc(focusNode, returningArray);
        return returningArray;
    }

    private void fillArrayAsc(Node focusNode, int[] arrayToReturn){
        if(focusNode.leftChild != null){
            fillArrayAsc(focusNode.leftChild, arrayToReturn);
        }
        arrayToReturn[index++] = focusNode.data;
        if(focusNode.rightChild!= null){
            fillArrayAsc(focusNode.rightChild, arrayToReturn);
        }
    }
    private void fillArrayDesc(Node focusNode, int[] arrayToReturn){
        if(focusNode.rightChild != null){
            fillArrayDesc(focusNode.rightChild, arrayToReturn);
        }
        arrayToReturn[index++] = focusNode.data;
        if(focusNode.leftChild!= null){
            fillArrayDesc(focusNode.leftChild, arrayToReturn);
        }
    }

}
