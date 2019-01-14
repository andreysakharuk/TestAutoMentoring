package com.epam.cdp;


import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

//Create instance of TestNg
        TestNG testNG = new TestNG();

// Create List of suites and  define needed path to suites
        List<String> suites = new ArrayList<>();
        suites.add("./src/test/resources/SuiteParametrized.xml");

// Add needed suite to testng object
        testNG.setTestSuites(suites);
        testNG.run();
    }
}
