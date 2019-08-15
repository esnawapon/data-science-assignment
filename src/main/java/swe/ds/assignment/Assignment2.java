package swe.ds.assignment;

import org.springframework.stereotype.Service;
import swe.ds.assignment.file.CodFileParser;
import swe.ds.assignment.file.CodRecord;

import java.util.ArrayList;
import java.util.List;

@Service
public class Assignment2 implements Demoable {
    @Override
    public void demo() throws Exception {
        CodFileParser parser = new CodFileParser();
        List<CodRecord> list = parser.parseFileToCollection(new ArrayList<>(), true);
        for (int i = 2001; i < 2009; i++) {
            System.out.println("[" + i + "]: " + CodFileParser.countByTime(list, i));
        }
    }
}
