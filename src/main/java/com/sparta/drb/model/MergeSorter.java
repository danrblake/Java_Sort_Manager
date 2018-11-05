package com.sparta.drb.model;

import com.sparta.drb.view.SortView;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

public class MergeSorter implements Sorter {

    final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    Logger log = Logger.getLogger(MergeSorter.class.getName());

    private  void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);

    }

        public int[] sortArray(int[] entryArray) {
            initialiseLogging();
            if (entryArray.length < 1){
                return null;
            }
            if (entryArray.length == 1){
                return entryArray;
            }
            int[] firstSplit = Arrays.copyOfRange(entryArray, 0, entryArray.length/2 );
            int[] secondSplit = Arrays.copyOfRange(entryArray, entryArray.length/2, entryArray.length);
            return merge(sortArray(firstSplit), sortArray(secondSplit));
        }

        private int[] merge(int[] array1, int[] array2) {
            int[] newArray = new int[array1.length + array2.length];
            int j = 0;
            int k = 0;
            for(int i = 0; i < newArray.length; i++){
                if(k >= array1.length) {
                    newArray[i] = array2[j];
                    j++;
                }
                else if(j >= array2.length) {
                    newArray[i] = array1[k];
                    k++;
                }
                else if(array1[k] < array2[j]) {
                    newArray[i] = array1[k];
                    k++;
                }
                else if (array2[j] < array1[k]) {
                    newArray[i] = array2[j];

                    j++;
                }
            }
            return newArray;
        }
    @Override
    public String toString() {
        return "Merge Sorter";
    }
}
