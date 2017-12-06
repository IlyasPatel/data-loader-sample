package com.efinancialcareers.jbehave.qa;

import java.util.Map;

public class StoryContainer {
    private Map<String, Story> suite;

    public void setStories(Map<String, Story> suite) {
        this.suite = suite;
    }

    public Story getStoryByName(String storyName) {
        return this.suite.get(storyName);
    }
}
