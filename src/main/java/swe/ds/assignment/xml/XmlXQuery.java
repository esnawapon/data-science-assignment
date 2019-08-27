package swe.ds.assignment.xml;

import java.io.*;
import javax.xml.xquery.*;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class XmlXQuery {
    private static final String FILE_PATH = "/home/es/Sites/swe/data-science-assignment/src/main/resources/NASAtemperatureAbnormal.xml";
    private final File FILE = new File(FILE_PATH);
    private static XmlXQuery instance;

    public static XmlXQuery getInstance() throws Exception {
        if (instance == null) {
            instance = new XmlXQuery();
            if (!instance.FILE.exists()) {
                throw new IOException("File not exists");
            }
        }
        return instance;
    }

    public void test() throws Exception {
        executeXQuery(
            "<results>{ " +
                "for $year in doc(\"" + FILE_PATH + "\")/years/year " +
                "let $max := max($year/months//diffTemperature/text()) " +
                "let $min := min($year/months//diffTemperature/text()) " +
                "return <year value='{$year/@collectingYear/string()}'> " +
                    "<max>" +
                        "<value>{$max}</value> " +
                        "<months>{ " +
                            "for $month in $year/months/* " +
                            "where $month/diffTemperature/text() = $max " +
                            "return <month>{$month/name()}</month> " +
                        "}</months> " +
                    "</max> " +
                    "<min>" +
                        "<value>{$min}</value> " +
                        "<months>{ " +
                            "for $month in $year/months/* " +
                            "where $month/diffTemperature/text() = $min " +
                            "return <month>{$month/name()}</month> " +
                        "}</months> " +
                    "</min> " +
                "</year> " +
            "}</results>"
        );
    }

    public Object executeXQuery(String xQuery) throws Exception {
        System.out.println(xQuery);
        InputStream is = null;
        XQConnection conn = null;
        XQSequence rs = null;
        try {
            is = new ByteArrayInputStream(xQuery.getBytes());
            XQDataSource ds = new SaxonXQDataSource();
            conn = ds.getConnection();
            XQPreparedExpression xqpre = conn.prepareExpression(is);
            rs = xqpre.executeQuery();
            while(rs.next()) {
                String txt = rs.getItemAsString(null);
                System.out.println(txt);
                System.out.println();
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                // no-op
            }
            try {
                is.close();
            } catch (Exception e) {
                // no-op
            }
            try {
                conn.close();
            } catch (Exception e) {
                // no-op
            }
        }
    }
}
