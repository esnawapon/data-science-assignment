package swe.ds.assignment.weka;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

public class WekaModel {
    private static final String TRAIN_FILE_PATH = "/home/es/Sites/swe/data-science-assignment/src/main/resources/sweden-auto-insurance-training.arff";
    private static final String TEST_FILE_PATH = "/home/es/Sites/swe/data-science-assignment/src/main/resources/sweden-auto-insurance-testing.arff";
    private static final String PREDICT_FILE_PATH = "/home/es/Sites/swe/data-science-assignment/src/main/resources/sweden-auto-insurance-predict.arff";
    public static Instances buildInstance(String filePath) {
        Instances dataSet = null;
        ArffLoader loader = new ArffLoader();
        try {
            loader.setFile(new File(filePath));
            dataSet = loader.getDataSet();
            dataSet.setClassIndex(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    public static void processLinearRegression() {
        Instances trainInstance = buildInstance(TRAIN_FILE_PATH);
        Instances testInstance = buildInstance(TEST_FILE_PATH);
        Instances predictInstance = buildInstance(PREDICT_FILE_PATH);
        Classifier classifier = new LinearRegression();
        try {
            classifier.buildClassifier(trainInstance);
            Evaluation evaluation = new Evaluation(trainInstance);
            evaluation.evaluateModel(classifier, testInstance);
            System.out.println("Linear Regression");
            System.out.println(evaluation.toSummaryString());
            System.out.println("Prediction");
            for (int i = 0; i < predictInstance.numInstances(); i++) {
                Double predictedValue = classifier.classifyInstance(predictInstance.instance(i));
                System.out.println("predicted value of " + predictInstance.instance(i).value(0) + "     \t= " + predictedValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
