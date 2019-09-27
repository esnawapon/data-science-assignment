package swe.ds.assignment;

import org.springframework.stereotype.Service;
import swe.ds.assignment.weka.WekaModel;

@Service
public class Assignment7 implements Demoable {
    private static final String TRAIN = "/home/es/Sites/swe/data-science-assignment/src/main/resources/creditRisk_Clean_NoCreditHistory_training.arff";
    private static final String TEST = "/home/es/Sites/swe/data-science-assignment/src/main/resources/creditRisk_Clean_NoCreditHistory_testing.arff";
    private static final String PREDICT = "/home/es/Sites/swe/data-science-assignment/src/main/resources/creditRisk_Clean_NoCreditHistory_predict.arff";
    private static final int CLASS_INDEX = 9;
    @Override
    public void demo() throws Exception {
        WekaModel.processLogistic(TRAIN, TEST, PREDICT, CLASS_INDEX);
    }
}
