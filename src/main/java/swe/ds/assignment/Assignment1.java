package swe.ds.assignment;

import org.springframework.stereotype.Service;
import swe.ds.assignment.file.SaleFileParser;
import swe.ds.assignment.file.SaleRecord;

import java.util.*;

@Service
public class Assignment1 implements Demoable {
    @Override
    public void demo() throws Exception {
        SaleFileParser parser = new SaleFileParser();
        List<SaleRecord> arrayList = parser.parseFileToCollection(new ArrayList<>());
        List<SaleRecord> linkedList = parser.parseFileToCollection(new LinkedList<>());
        Set<SaleRecord> hashSet = parser.parseFileToCollection(new HashSet<>());
        Set<SaleRecord> treeSet = parser.parseFileToCollection(new TreeSet<>());
        Map<Integer, SaleRecord> hashMap = parser.parseFileToMap(new HashMap<>());
        Map<Integer, SaleRecord> treeMap = parser.parseFileToMap(new TreeMap<>());
    }
}
