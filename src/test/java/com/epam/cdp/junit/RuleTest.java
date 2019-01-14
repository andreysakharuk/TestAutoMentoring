package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RuleTest {

    @Rule
    public final TemporaryFolder tempFolder = new TemporaryFolder();

    @Rule
    public final TestName testname = new TestName();

    @Rule
    public final TestRule globalTimeout = Timeout.millis(20);
    //Set max 20 mili-seconds for running test

    @Test
    public void checkValuesInTemporaryFiles() throws IOException {
        File createdFile = tempFolder.newFile("1.text");
        BufferedWriter writer = new BufferedWriter(new FileWriter(createdFile));
        writer.write("3");
        writer.close();

        Scanner scanner = new Scanner(new FileReader(createdFile));
        ArrayList<String> line = new ArrayList<>();
        while (scanner.hasNextLine()) {
            line.add(scanner.nextLine());
        }
        Assert.assertEquals(3, Integer.parseInt(line.get(0)));
        scanner.close();
    }

    @Test
    public void checkNameOfTestMethod() {
        Assert.assertEquals("checkNameOfTestMethod", testname.getMethodName());
    }

}
