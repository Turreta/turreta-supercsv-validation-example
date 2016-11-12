package com.turreta.supercsv.custom;

import java.util.HashSet;
import java.util.Set;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.util.CsvContext;

public class EmployeeIdCsvRule extends CellProcessorAdaptor {

    private final Set<Object> encounteredElements = new HashSet<Object>();

    @Override
    public <T> T execute(Object value, CsvContext context) {
        validateInputNotNull(value, context); // throws an Exception if the input is null

        String regex = "\\d{10}";

        if (value instanceof String && !value.toString().matches(regex)) {
            throw new SuperCsvConstraintViolationException(String.format("mismatched format value '%s' encountered - '%s'", value, regex), context, this);
        }

        if (!encounteredElements.add(value)) {
            throw new SuperCsvConstraintViolationException(String.format("duplicate value '%s' encountered", value), context, this);
        }

        return next.execute(value, context);
    }

}
