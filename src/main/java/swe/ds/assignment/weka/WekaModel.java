package swe.ds.assignment.weka;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.Logistic;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

public class WekaModel {
    public static Instances buildInstance(String filePath, int classIndex) {
        Instances dataSet = null;
        ArffLoader loader = new ArffLoader();
        try {
            loader.setFile(new File(filePath));
            dataSet = loader.getDataSet();
            dataSet.setClassIndex(classIndex);
        } catch (IOException e) {
            System.out.println("Cannot read: " + filePath);
            e.printStackTrace();
        }
        return dataSet;
    }

    public static void processLinearRegression(String train, String test, String predict, int classIndex) {
        processByClassifier(new LinearRegression(), train, test, predict, classIndex);
    }

    public static void processLogistic(String train, String test, String predict, int classIndex) {
        processByClassifier(new Logistic(), train, test, predict, classIndex);
    }

    public static void processByClassifier(Classifier classifier, String train, String test, String predict, int classIndex) {
        Instances trainInstance = buildInstance(train, classIndex);
        Instances testInstance = buildInstance(test, classIndex);
        Instances predictInstance = buildInstance(predict, classIndex);
        try {
            classifier.buildClassifier(trainInstance);
            Evaluation evaluation = new Evaluation(trainInstance);
            evaluation.evaluateModel(classifier, testInstance);
            System.out.println("Linear Regression");
            System.out.println(evaluation.toSummaryString());
            System.out.println("Prediction");
            for (int i = 0; i < predictInstance.numInstances(); i++) {
                Double predictedValue = classifier.classifyInstance(predictInstance.instance(i));
                System.out.println("predicted value of " + predictInstance.instance(i) + "      \t= " + predictedValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
