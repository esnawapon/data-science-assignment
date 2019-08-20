package swe.ds.assignment.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    private static final String FILE_PATH = "/home/es/Sites/swe/data-science-assignment/src/main/resources/resume_w_xsl.xml";
    private final File FILE = new File(FILE_PATH);
    private static XmlParser instance;

    public static XmlParser getInstance() throws Exception {
        if (instance == null) {
            instance = new XmlParser();
            if (!instance.FILE.exists()) {
                throw new IOException("File not exists");
            }
        }
        return instance;
    }

    public String getName() throws Exception {
        String xpath = "//resumes/person/@name";
        return executeXpath(xpath, null).toString();
    }

    public String getPhone() throws Exception {
        String xpath = "//resumes/person/phone/text()";
        return executeXpath(xpath, null).toString();
    }

    public List<String> getProjectNamesByStartYear(int year) throws Exception {
        List<String> results = new ArrayList<>();
        String xpath = "//resumes/person/project[contains(@start, '" + year + "')]";
        NodeList nodeList = (NodeList) executeXpath(xpath, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            String shortDesc = executeXpath(node, "short_desc", null).toString();
            String client = executeXpath(node, "client/@name", null).toString();
            String position = executeXpath(node, "position/@title", null).toString();
            StringBuilder sb = new StringBuilder()
                .append("Description: ").append(shortDesc).append("\n")
                .append("Client: ").append(client).append("\n")
                .append("Position: ").append(position).append("\n");
            results.add(sb.toString());
        }
        return results;
    }

    public Object executeXpath(String xpathExpression, QName type) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(FILE);
        return executeXpath(doc, xpathExpression, type);
    }

    public Object executeXpath(Object doc, String xpathExpression, QName type) throws Exception {
        XPathExpression expr = XPathFactory.newInstance()
                .newXPath()
                .compile(xpathExpression);
        Object result;
        if (type == null) {
            result = expr.evaluate(doc);
        } else {
            result = expr.evaluate(doc, type);
        }
        return result;
    }
}
