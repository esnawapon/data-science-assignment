package swe.ds.assignment.file;

import java.util.Collection;

public class CodFileParser extends AbstractFileParser<CodRecord> {
    private static final String DATA_FILE_PATH = "/home/es/Sites/swe/data-science-assignment/src/main/resources/CausesOfDeath_France_2001-2008.csv";

    @Override
    protected String getDataFilePath() {
        return DATA_FILE_PATH;
    }

    @Override
    protected CodRecord parseLineToModel(String line) {
        String[] split = line.split("\",\"");
        CodRecord model = new CodRecord();
        model.setTime(Integer.parseInt(split[0].substring(1)));
        model.setGeo(split[1]);
        model.setSex(split[3]);
        model.setIcd10(split[5]);
        return model;
    }

    public static int countByTime(Collection<CodRecord> collection, int time) {
        return (int) collection.stream().filter(each -> each.getTime().equals(time)).count();
    }
}