package salesummary;

import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.Map;

public class FileParser {
    private static final String DATA_FILE_PATH = "/home/es/Sites/es/data-science-assignment/resources/data.txt";

    public static <T extends Map<Integer, SaleRecord>> T loadToMap(T map) throws Exception {
        long start = System.currentTimeMillis();
        RandomAccessFile raf = new RandomAccessFile(DATA_FILE_PATH, "r");
        String line;
        while ((line = raf.readLine()) != null) {
            SaleRecord record = parseSaleReocord(line);
            map.put(record.getId(), record);
        }
        long end = System.currentTimeMillis();
        System.out.println("[" + map.getClass() + "]Duration: " + (end - start) + "ms");
        return map;
    }

    public static <T extends Collection<SaleRecord>> T loadToCollection(T collection) throws Exception {
        long start = System.currentTimeMillis();
        RandomAccessFile raf = new RandomAccessFile(DATA_FILE_PATH, "r");
        String line;
        while ((line = raf.readLine()) != null) {
            SaleRecord record = parseSaleReocord(line);
            collection.add(record);
        }
        long end = System.currentTimeMillis();
        System.out.println("[" + collection.getClass() + "]Duration: " + (end - start) + "ms");
        return collection;
    }

    private static SaleRecord parseSaleReocord(String rawRecord) throws Exception {
        SaleRecord record = new SaleRecord();
        String id = rawRecord.substring(1, rawRecord.indexOf(",'"));
        String saleId = rawRecord.substring(rawRecord.indexOf(",'") + 2, rawRecord.indexOf("','"));
        String name = rawRecord.substring(rawRecord.indexOf("','") + 3, rawRecord.length() - 3);
        record.setId(Integer.parseInt(id));
        record.setSaleId(saleId);
        record.setName(name);
        return record;
    }
}
