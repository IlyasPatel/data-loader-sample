package com.efinancialcareers.jbehave.qa;

import com.google.common.base.Joiner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.validation.constraints.NotNull;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XMLSuiteParser implements Parser {
    private AbsoluteFilePathBuilder absoluteFilePathBuilder;

    public XMLSuiteParser() {
        absoluteFilePathBuilder = new AbsoluteFilePathBuilder();
    }

    @Override
    public Suite parseSuiteFileByScenario(@NotNull String path, @NotNull String scenarioName) {

        final Suite suiteWithActiveTests = new Suite();
        final Suite tempSuite = parseSuiteFile(path);

        for (Map.Entry<String, Story> pair : tempSuite.getSuiteMap().entrySet()) {
            if (pair.getValue().getScenario().equalsIgnoreCase(scenarioName)) {
                suiteWithActiveTests.getSuiteMap().put(pair.getKey(), pair.getValue());
            }
        }

        return suiteWithActiveTests;
    }

    @Override
    public Suite parseSuiteFileByName(@NotNull String path, @NotNull String suiteName) {

        final Suite suiteWithActiveTests = new Suite();
        final Suite tempSuite = parseSuiteFile(path);

        for (Map.Entry<String, Story> pair : tempSuite.getSuiteMap().entrySet()) {
            if (isTestIncluded(pair)) {
                suiteWithActiveTests.getSuiteMap().put(pair.getKey(), pair.getValue());
            }
        }

        return suiteWithActiveTests;
    }

    private boolean isTestIncluded(Map.Entry<String, Story> pair) {
        return pair.getValue().isInclude();
    }

    private Suite parseSuiteFile(@NotNull String path) {
        Suite suite = new Suite();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(path);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();

        NodeList suiteList = doc.getElementsByTagName("suite");

        for (int i = 0; i < suiteList.getLength(); i++) {
            Node suiteNode = suiteList.item(i);

            if (isAnXmlNode(suiteNode)) {
                NodeList storyList = ((Element) suiteNode).getElementsByTagName("story");

                for (int j = 0; j < storyList.getLength(); j++) {
                    Node storyNode = storyList.item(j);

                    if (isAnXmlNode(storyNode)) {
                        Element storyElement = (Element) storyNode;

                        String storyName = storyElement.getAttribute("name");
                        boolean include = isStoryIncluded(storyElement.getAttribute("include"));
                        String absolutePath = absoluteFilePathBuilder.getStoryPath(storyName);
                        List<String> datasets = absoluteFilePathBuilder.getAbsolutePathForStringList(convertPaths("datasets/", storyElement.getAttribute("datasets")));
                        List<String> data = new ArrayList<>();
                        Boolean preLoadData = Boolean.valueOf(storyElement.getAttribute("preLoadData"));
                        String scenario = storyElement.getAttribute("scenario");

                        Story story = new Story(storyName, include, absolutePath, datasets, data, preLoadData, scenario);

                        suite.getSuiteMap().put(storyElement.getAttribute("name"), story);
                    }
                }
            }
        }

        return suite;
    }

    public String convertPaths(String path, String fileName) {
        List<String> fileNames = Stream.of(fileName.split(";")).collect(Collectors.toList());
        List<String> newFileNames = new ArrayList<>();

        for (String name : fileNames) {
            newFileNames.add(path + name);
        }

        return Joiner.on(",").join(newFileNames);
    }

    private boolean isAnXmlNode(Node suiteNode) {
        return suiteNode.getNodeType() == Node.ELEMENT_NODE;
    }

    private boolean isStoryIncluded(String num) {
        return getBool(num);
    }

    private boolean getBool(String num) {
        return !"0".equals(num);
    }
}
