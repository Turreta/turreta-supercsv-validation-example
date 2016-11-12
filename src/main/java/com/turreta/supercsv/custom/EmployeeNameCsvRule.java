package com.turreta.supercsv.custom;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.util.CsvContext;

public class EmployeeNameCsvRule extends CellProcessorAdaptor {

    @Override
    public <T> T execute(Object value, CsvContext context) {
        validateInputNotNull(value, context); // throws an Exception if the input is null

        String regex = "([a-zA-Z]\\s*){1,50}";

        if (value instanceof String && !value.toString().matches(regex)) {
            throw new SuperCsvConstraintViolationException(String.format("mismatched format value '%s' encountered - '%s'", value, regex), context, this);
        }

        return next.execute(value, context);
    }

}
