package com.efinancialcareers.jbehave.qa;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public final class Story {
    private final String name;
    private final String storyFilePath;
    private final List<String> datasetPaths;
    private final List<String> data;
    private final boolean include;
    private final boolean preloadData;
    private final String scenario;

    /**
     * Ctor.
     * @param name name
     * @param include include
     */
    /**
     * Constructor
     * @param name Story name
     * @param include Include test during test suite execution
     * @param path Path to file
     * @param datasets List of datasets for database
     * @param data List of datasets to use as test data
     * @param preloadData Determines if test data should be inserted in to database on startup
     */
    public Story(String name, boolean include, final String path, List<String> datasets,  List<String> data, boolean preloadData, String scenario) {
        this.name = name;
        this.storyFilePath = path;
        this.datasetPaths = Collections.unmodifiableList(Lists.transform(datasets, new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input;
            }
        }));
        this.data = Collections.unmodifiableList(Lists.transform(data, new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input;
            }
        }));
        this.include = include;
        this.preloadData = preloadData;
        this.scenario = scenario;
    }

    public String getName() {
        return name;
    }

    public String getStoryFilePath() {
        return storyFilePath;
    }

    public List<String> getDatasetPaths() {
        return datasetPaths;
    }

    public boolean isInclude() {
        return include;
    }

    public boolean shouldPreloadData() {
        return preloadData;
    }

    public List<String> getData() {
        return data;
    }

    public String getScenario() {
        return scenario;
    }

    /**
     * Has Dataset
     * @return yes or no
     */
    public boolean hasDatasets(){
        return !datasetPaths.isEmpty();
    }

    /**
     * Has data not entered into database
     * @return yes or no
     */
    public boolean hasData(){
        return !data.isEmpty();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, storyFilePath);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Story other = (Story) obj;
        return Objects.equal(this.name, other.name) && Objects.equal(this.storyFilePath, other.storyFilePath);
    }
}
