package com.turreta.supercsv;

import org.supercsv.cellprocessor.ift.CellProcessor;

import com.turreta.supercsv.custom.EmployeeCommentCsvRule;
import com.turreta.supercsv.custom.EmployeeCountryCsvRule;
import com.turreta.supercsv.custom.EmployeeHireDateCsvRule;
import com.turreta.supercsv.custom.EmployeeHomeStateCsvRule;
import com.turreta.supercsv.custom.EmployeeIdCsvRule;
import com.turreta.supercsv.custom.EmployeeNameCsvRule;
import com.turreta.supercsv.custom.EmployeeSSNCsvRule;

public class NewEmployeeCsvProcessor implements CsvColumnProcessor {

    public CellProcessor[] getProcessors() {

        // @formatter:off
        return new CellProcessor[] {

                // Employee Id
                new EmployeeIdCsvRule(),

                // Last name
                new EmployeeNameCsvRule(),

                // // First name
                new EmployeeNameCsvRule(),
                //
                // SSN
                new EmployeeSSNCsvRule(),

                // Home state
                new EmployeeHomeStateCsvRule(),

                // Country
                new EmployeeCountryCsvRule(),

                // Hire date
                new EmployeeHireDateCsvRule(),

                // Comment
                new EmployeeCommentCsvRule()

                // @formatter:on

        };
    }

}
