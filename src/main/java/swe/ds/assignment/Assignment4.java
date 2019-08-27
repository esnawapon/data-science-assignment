package swe.ds.assignment;

import org.springframework.stereotype.Service;
import swe.ds.assignment.xml.XmlXPath;

import java.util.List;

@Service
public class Assignment4 implements Demoable {
    @Override
    public void demo() throws Exception {
        String name = XmlXPath.getInstance().getName();
        String phone = XmlXPath.getInstance().getPhone();
        List<String> proj1993 = XmlXPath.getInstance().getProjectNamesByStartYear(1996);
        System.out.println("name: " + name);
        System.out.println("phone: " + phone);
        System.out.println("prjects in 1993:");
        for (String project: proj1993) {
            System.out.println(project);
        }

    }
}
