package com.turreta.supercsv.custom;

import java.util.Arrays;
import java.util.List;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.util.CsvContext;

public class EmployeeHomeStateCsvRule extends CellProcessorAdaptor {

    private static List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
            "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
            "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");

    @Override
    public <T> T execute(Object value, CsvContext context) {
        validateInputNotNull(value, context); // throws an Exception if the input is null

        if (value instanceof String) {
            final String fnValue = (String) value;

            if (!states.stream().anyMatch(x -> x.equalsIgnoreCase(fnValue))) {
                throw new SuperCsvConstraintViolationException(String.format("mismatched value '%s' encountered - not a valid US state", value), context, this);
            }
        }

        return next.execute(value, context);
    }

}
