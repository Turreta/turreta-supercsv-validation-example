package com.turreta.supercsv.custom;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.util.CsvContext;

public class EmployeeSSNCsvRule extends CellProcessorAdaptor {

    @Override
    public <T> T execute(Object value, CsvContext context) {
        validateInputNotNull(value, context); // throws an Exception if the input is null

        String regex = "^\\d{3}-?\\d{2}-?\\d{4}$";

        if (value instanceof String && !value.toString().matches(regex)) {
            throw new SuperCsvConstraintViolationException(String.format("mismatched format value '%s' encountered - '%s'", value, regex), context, this);
        }

        return next.execute(value, context);
    }

}
