package com.sparta.drb.controller;

import com.sparta.drb.model.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import com.sparta.drb.Exceptions.*;

public class SortFactory {

    private static final String PATH = "resources/Factory.Properties";

    public static Sorter getInstance() throws FactoryException {

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(PATH));
            String whichSort = properties.getProperty("sorter");
            Class selectorSorter = Class.forName(whichSort);
            return (Sorter)selectorSorter.getDeclaredConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)  {
            throw new FactoryException("Unable to process user request");
        }
    }
//        if (sortType.equals("bubble")) {
//            return new BubbleSorter();
//        } else if (sortType.equals("merge")) {
//            return new MergeSorter();
//        } else if (sortType.equals("quick")) {
//            return new QuickSorter();
//        } else if (sortType.equals("insertion")) {
//            return new InsertionSorter();
//        }
//        return null;
//    }
}
//            if (whichSort.equals("bubble")) {
//                    return new BubbleSorter();
//                    } else if (whichSort.equals("merge")) {
//                    return new MergeSorter();
//                    } else if (whichSort.equals("quick")) {
//                    return new QuickSorter();
//                    } else if (whichSort.equals("insertion")) {
//                    return new InsertionSorter();
//                    }