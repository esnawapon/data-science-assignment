package swe.ds.assignment;

import org.springframework.stereotype.Service;
import swe.ds.assignment.weka.WekaModel;

@Service
public class Assignment6 implements Demoable {
    @Override
    public void demo() throws Exception {
        WekaModel.processLinearRegression();
    }
}
