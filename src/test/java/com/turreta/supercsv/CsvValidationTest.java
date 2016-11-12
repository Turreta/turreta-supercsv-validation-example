package com.turreta.supercsv;

import java.io.File;

import org.junit.Test;

public class CsvValidationTest {

    @Test
    public void test() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        CsvValidator.validateNewEmployee(new File(classLoader.getResource("test11.csv").getFile()), new NewEmployeeCsvProcessor().getProcessors());
    }

}
