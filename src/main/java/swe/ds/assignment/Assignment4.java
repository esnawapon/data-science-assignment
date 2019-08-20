package swe.ds.assignment;

import org.springframework.stereotype.Service;
import swe.ds.assignment.xml.XmlParser;

import java.util.List;

@Service
public class Assignment4 implements Demoable {
    @Override
    public void demo() throws Exception {
        String name = XmlParser.getInstance().getName();
        String phone = XmlParser.getInstance().getPhone();
        List<String> proj1993 = XmlParser.getInstance().getProjectNamesByStartYear(1996);
        System.out.println("name: " + name);
        System.out.println("phone: " + phone);
        System.out.println("prjects in 1993:");
        for (String project: proj1993) {
            System.out.println(project);
        }

    }
}
