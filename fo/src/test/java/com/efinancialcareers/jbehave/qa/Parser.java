package com.efinancialcareers.jbehave.qa;

import javax.validation.constraints.NotNull;

public interface Parser {
    Suite parseSuiteFileByScenario(@NotNull String path, @NotNull String scenarioName);

    Suite parseSuiteFileByName(@NotNull String path, @NotNull String suiteName);
}
