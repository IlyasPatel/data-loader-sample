package com.efinancialcareers.jbehave.qa;

public enum SingletonFactory {

    INSTANCE;

    private TestDataLoader testDataManager;
    private Parser xmlSuiteParser;
    private StoryContainer storyContainer;
    private AbsoluteFilePathBuilder absoluteFilePathBuilder;

    SingletonFactory() {
        xmlSuiteParser = new XMLSuiteParser();
        storyContainer = new StoryContainer();
        absoluteFilePathBuilder = new AbsoluteFilePathBuilder();
        testDataManager = new TestDataManager();
    }

    public TestDataLoader getTestDataManager() {
        return testDataManager;
    }

    public Parser getXmlSuiteParser() {
        return xmlSuiteParser;
    }

    public StoryContainer getStoryContainer() {
        return storyContainer;
    }

    public AbsoluteFilePathBuilder getAbsoluteFilePathBuilder() {
        return absoluteFilePathBuilder;
    }
}
