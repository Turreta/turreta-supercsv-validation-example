package com.turreta.supercsv;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

/**
 * The Class CsvValidator.
 */
public class CsvValidator {

    /**
     * Validate CSV.
     *
     * @param fileName
     *            the file name
     * @param processors
     *            the processors
     * @throws Exception
     *             the exception
     */
    public static void validateNewEmployee(File file, CellProcessor[] processors) throws Exception {
        ICsvMapReader mapReader = null;
        try {
            mapReader = new CsvMapReader(new FileReader(file), CsvPreference.STANDARD_PREFERENCE);

            final String[] header = mapReader.getHeader(true);
            final CellProcessor[] processor = processors;

            Map<String, Object> subMap;
            while ((subMap = mapReader.read(header, processor)) != null) {
                // logger.info(String.format("lineNo=%s, rowNo=%s, master=%s", mapReader.getLineNumber(),
                // mapReader.getRowNumber(), subMap));
            }
        } finally {
            if (mapReader != null) {
                mapReader.close();
            }
        }
    }
}
