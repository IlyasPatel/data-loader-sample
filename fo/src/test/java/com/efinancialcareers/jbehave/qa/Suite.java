package com.efinancialcareers.jbehave.qa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Suite {
    private Map<String, Story> suiteMap = new LinkedHashMap<>();
    private List<String> shareDataSets = new ArrayList<>();

    public Map<String, Story> getSuiteMap() {
        return suiteMap;
    }

    public void setSuiteMap(Map<String, Story> suiteMap) {
        this.suiteMap = suiteMap;
    }

    public List<String> getShareDataSets() {
        return shareDataSets;
    }

    public void setShareDataSets(List<String> shareDataSets) {
        this.shareDataSets = shareDataSets;
    }
}
