package com.sparta.drb.controller;

import com.sparta.drb.Exceptions.FactoryException;
import com.sparta.drb.Starter;
import com.sparta.drb.view.SortView;
import com.sparta.drb.model.Sorter;
import com.sparta.drb.view.Display;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

public class SortManager{

    int [] arrayToSort = {20,7,10,9, 25};
    Display sortView = new SortView();

     final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
     Logger log = Logger.getLogger(SortManager.class.getName());
    private  void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);

    }
    public void runSorter()  {
        initialiseLogging();
        try {
            Sorter sorter = SortFactory.getInstance();
            log.info("User has requested a sort on input of " + Arrays.toString(arrayToSort));
            int[] sortedArray = sorter.sortArray(arrayToSort);

            displaySortedArray(sortedArray, sorter.toString());
        }  catch (Exception e) {
            displayExceptionMessage(e.getMessage());
            log.fatal("The factory has had an error CHECK IT OUT");

        }
        log.debug("Daniel is amazing");
    }

    private void displaySortedArray(int[] sortedArray, String typeOfSort) {
        sortView.display(sortedArray, typeOfSort);
    }

    private void displayExceptionMessage(String message){
        sortView.displayExceptionMessage(message);
    }
}
