package com.efinancialcareers.jbehave.qa;

import com.google.common.collect.Lists;
import org.jbehave.core.io.StoryFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AbsoluteFilePathBuilder {

    public String getStoryPath(String filename) {
        List<String> path = new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()),
                        Lists.newArrayList("**/" + filename),
                        Lists.<String>newArrayList());

        if(path != null && !path.isEmpty()) {
            return path.get(0).substring(0, path.get(0).lastIndexOf(filename));
        }

        throw new IllegalStateException("Custom Error : Cannot find this file in the classpath : " + filename);
    }

    public String getAbsolutePath(String filename) {
        File siteConfiguration = new File(ClassLoader.getSystemResource(filename).getFile());

        return siteConfiguration.getAbsolutePath();
    }

    public List<String> getAbsolutePath(List<String> fileList) {
        List<String> tempList = Lists.newArrayList();

        for (String fileName : fileList) {
            tempList.add(getAbsolutePath(fileName));
        }

        return tempList;
    }

    public List<String> getAbsolutePathForStringList(String delimetedListOfFileNames) {
        List<String> fileNames = Stream.of(delimetedListOfFileNames.split(",")).collect(Collectors.toList());
        List<String> newFileNames = new ArrayList<>();

        for (String name : fileNames) {
            newFileNames.add(getAbsolutePath(name));
        }

        return newFileNames;
    }
}
