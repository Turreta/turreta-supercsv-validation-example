package com.turreta.supercsv.custom;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.util.CsvContext;

public class EmployeeHireDateCsvRule extends CellProcessorAdaptor {

    @Override
    public <T> T execute(Object value, CsvContext context) {
        validateInputNotNull(value, context); // throws an Exception if the input is null

        String regex = "^(0[0-9]||1[0-2])/([0-2][0-9]||3[0-1])/([0-9][0-9])?[0-9][0-9]$";

        if (value instanceof String && !value.toString().matches(regex)) {
            throw new SuperCsvConstraintViolationException(String.format("mismatched format value '%s' encountered - '%s'", value, "MM/DD/YYYY"), context,
                    this);
        }

        if (value instanceof String) {
            String tmpValue = (String) value;
            try {
                LocalDate ld = LocalDate.of(Integer.valueOf(tmpValue.substring(6, 10)), Integer.valueOf(tmpValue.substring(0, 2)),
                        Integer.valueOf(tmpValue.substring(3, 5)));
            } catch (DateTimeException dte) {
                throw new SuperCsvConstraintViolationException(String.format("invalid date '%s' encountered", value), context, this);
            }
        }

        return next.execute(value, context);
    }

}
