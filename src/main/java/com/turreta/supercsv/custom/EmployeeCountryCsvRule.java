package com.turreta.supercsv.custom;

import java.util.Arrays;
import java.util.List;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.util.CsvContext;

public class EmployeeCountryCsvRule extends CellProcessorAdaptor {

    private static List<String> states = Arrays.asList("US");

    @Override
    public <T> T execute(Object value, CsvContext context) {
        validateInputNotNull(value, context); // throws an Exception if the input is null

        if (value instanceof String) {
            final String fnValue = (String) value;

            if (!states.stream().anyMatch(x -> x.equalsIgnoreCase(fnValue))) {
                throw new SuperCsvConstraintViolationException(String.format("mismatched value '%s' encountered - not US country", value), context, this);
            }
        }

        return next.execute(value, context);
    }

}
