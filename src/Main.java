import salesummary.FileParser;
import salesummary.SaleRecord;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<SaleRecord> arrayList = FileParser.loadToCollection(new ArrayList<>());
        List<SaleRecord> linkedList = FileParser.loadToCollection(new LinkedList<>());
        Set<SaleRecord> hashSet = FileParser.loadToCollection(new HashSet<>());
        Set<SaleRecord> treeSet = FileParser.loadToCollection(new TreeSet<>());
        Map<Integer, SaleRecord> hashMap = FileParser.loadToMap(new HashMap<>());
        Map<Integer, SaleRecord> treeMap = FileParser.loadToMap(new HashMap<>());
    }
}
