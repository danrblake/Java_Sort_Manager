package com.sparta.drb.view;

import com.sparta.drb.Starter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;
import java.io.Console;

public class SortView implements Display {
    final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    Logger log = Logger.getLogger(SortView.class.getName());


    private  void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);

    }
//    public static String getSortType() {
//        Console console = System.console();
//        String input = Console.readLine("What sort type would you like? (your choices are 1) quick 2) merge 3) insertion 4) bubble");
//    }
    public void display(int [] sortedArray, String sortType) {
        initialiseLogging();
        System.out.printf("Your sorted result is %s:  \n this was sorted with a %s",  Arrays.toString(sortedArray), sortType);
        log.info("User has received output of - " + Arrays.toString(sortedArray));
    }
    public void displayExceptionMessage(String message){
        initialiseLogging();
        System.out.println(message);
    }
}
