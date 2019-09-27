package swe.ds.assignment;

import org.springframework.stereotype.Service;
import swe.ds.assignment.weka.WekaModel;

@Service
public class Assignment6 implements Demoable {
    private static final String TRAIN = "/home/es/Sites/swe/data-science-assignment/src/main/resources/sweden-auto-insurance-training.arff";
    private static final String TEST = "/home/es/Sites/swe/data-science-assignment/src/main/resources/sweden-auto-insurance-testing.arff";
    private static final String PREDICT = "/home/es/Sites/swe/data-science-assignment/src/main/resources/sweden-auto-insurance-predict.arff";
    private static final int CLASS_INDEX = 1;
    @Override
    public void demo() throws Exception {
        WekaModel.processLinearRegression(TRAIN, TEST, PREDICT, CLASS_INDEX);
    }
}
