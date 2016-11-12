package com.turreta.supercsv;

import org.supercsv.cellprocessor.ift.CellProcessor;

public interface CsvColumnProcessor {
    CellProcessor[] getProcessors();
}
