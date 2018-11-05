package com.sparta.drb;

import com.sparta.drb.controller.SortManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Starter
{




    public static void main( String[] args )
    {

        SortManager sortManager = new SortManager();
        sortManager.runSorter();
    }

}
