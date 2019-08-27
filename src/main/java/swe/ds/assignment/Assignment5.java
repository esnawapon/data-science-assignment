package swe.ds.assignment;

import org.springframework.stereotype.Service;
import swe.ds.assignment.xml.XmlXQuery;

@Service
public class Assignment5 implements Demoable {
    @Override
    public void demo() throws Exception {
        XmlXQuery.getInstance().test();
    }
}
