package swe690.salesummary;

import swe690.AbstractFileParser;

import java.io.RandomAccessFile;
import java.util.Map;

public class SaleFileParser extends AbstractFileParser<SaleRecord> {
    private static final String DATA_FILE_PATH = "/home/es/Sites/es/data-science-assignment/resources/data.txt";
    @Override
    protected String getDataFilePath() {
        return DATA_FILE_PATH;
    }

    @Override
    protected SaleRecord parseLineToModel(String rawRecord) {
        SaleRecord model = new SaleRecord();
        String id = rawRecord.substring(1, rawRecord.indexOf(",'"));
        String saleId = rawRecord.substring(rawRecord.indexOf(",'") + 2, rawRecord.indexOf("','"));
        String name = rawRecord.substring(rawRecord.indexOf("','") + 3, rawRecord.length() - 3);
        model.setId(Integer.parseInt(id));
        model.setSaleId(saleId);
        model.setName(name);
        return model;
    }

    public <T extends Map<Integer, SaleRecord>> T parseFileToMap(T map) throws Exception {
        long start = System.currentTimeMillis();
        RandomAccessFile raf = new RandomAccessFile(DATA_FILE_PATH, "r");
        String line;
        while ((line = raf.readLine()) != null) {
            SaleRecord record = parseLineToModel(line);
            map.put(record.getId(), record);
        }
        long end = System.currentTimeMillis();
        System.out.println("[" + map.getClass() + "]Duration: " + (end - start) + "ms");
        return map;
    }
}
