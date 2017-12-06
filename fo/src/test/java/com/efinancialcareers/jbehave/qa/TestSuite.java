package com.efinancialcareers.jbehave.qa;

import net.serenitybdd.jbehave.SerenityStories;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(CustomSerenityReportingRunner.class)
public class TestSuite extends SerenityStories {

    @Override
    public List<String> storyPaths() {
        final SingletonFactory singletonFactory = SingletonFactory.INSTANCE;

        AbsoluteFilePathBuilder absoluteFilePathBuilder = singletonFactory.getAbsoluteFilePathBuilder();

        String suiteToRun = "suite1";

        final String suiteFile = absoluteFilePathBuilder.getAbsolutePath("suiteFOHighPriority.xml");
        TestDataLoader testDataManager = singletonFactory.getTestDataManager();

        Parser xmlSuiteParser = singletonFactory.getXmlSuiteParser();
        Suite activeTests = xmlSuiteParser.parseSuiteFileByName(suiteFile, suiteToRun);

        Map<String, Story> suite = activeTests.getSuiteMap();
        insertTestData(testDataManager, suite);
        singletonFactory.getStoryContainer().setStories(suite);

        return buildStoryPaths(suite);
    }

    private List<String> buildStoryPaths(Map<String, Story> suite) {
        List<String> storyPaths = new ArrayList<String>();
        for (Map.Entry<String, Story> story : suite.entrySet()) {
            storyPaths.add(story.getValue().getStoryFilePath());
        }

        return storyPaths;
    }

    private void insertTestData(TestDataLoader testDataManager, Map<String, Story> suite) {
        for (Map.Entry<String, Story> story : suite.entrySet()) {
            if(shouldPreLoadTestData(story)) {
                testDataManager.insertTestDataSet(story.getKey(), story.getValue().getDatasetPaths());
            }
        }
    }

    private boolean shouldPreLoadTestData(Map.Entry<String, Story> story) {
        return true;
    }
}
