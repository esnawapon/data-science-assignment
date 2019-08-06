package swe690;

import swe690.causesofdeath.CodFileParser;
import swe690.causesofdeath.CodRecord;
import swe690.salesummary.SaleFileParser;
import swe690.salesummary.SaleRecord;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        assignment2();
//        assignment1();
    }

    public static void assignment2() throws Exception {
        CodFileParser parser = new CodFileParser();
        List<CodRecord> list = parser.parseFileToCollection(new ArrayList<>(), true);
        for (int i = 2001; i < 2009; i++) {
            System.out.println("[" + i + "]: " + CodFileParser.countByTime(list, i));
        }
    }

    public static void assignment1() throws Exception {
        SaleFileParser parser = new SaleFileParser();
        List<SaleRecord> arrayList = parser.parseFileToCollection(new ArrayList<>());
        List<SaleRecord> linkedList = parser.parseFileToCollection(new LinkedList<>());
        Set<SaleRecord> hashSet = parser.parseFileToCollection(new HashSet<>());
        Set<SaleRecord> treeSet = parser.parseFileToCollection(new TreeSet<>());
        Map<Integer, SaleRecord> hashMap = parser.parseFileToMap(new HashMap<>());
        Map<Integer, SaleRecord> treeMap = parser.parseFileToMap(new TreeMap<>());
    }
}
