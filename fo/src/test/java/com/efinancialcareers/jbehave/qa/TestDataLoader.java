package com.efinancialcareers.jbehave.qa;

import java.util.List;
import java.util.Map;

public interface TestDataLoader {
    void insertTestDataSet(String name, List<String> dataSetPaths);

    Map<String, Object> getTestData(String name);
}
