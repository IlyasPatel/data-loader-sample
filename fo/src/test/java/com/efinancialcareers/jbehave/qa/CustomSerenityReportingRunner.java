package com.efinancialcareers.jbehave.qa;

import net.serenitybdd.jbehave.runners.SerenityReportingRunner;
import net.thucydides.core.steps.StepEventBus;
import org.jbehave.core.ConfigurableEmbedder;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

public class CustomSerenityReportingRunner extends SerenityReportingRunner {

    public CustomSerenityReportingRunner(Class<? extends ConfigurableEmbedder> testClass) throws Throwable {
        super(testClass);
    }

    public CustomSerenityReportingRunner(Class<? extends ConfigurableEmbedder> testClass, ConfigurableEmbedder embedder) throws Throwable {
        super(testClass, embedder);
    }

    @Override
    public void run(final RunNotifier notifier) {
        notifier.addListener(new RunListener() {
            @Override
            public void testStarted(Description description) throws Exception {
                //StoryStorage storyStorage = new StoryStorage();
                //Story story = storyStorage.getStoryByName(description.getDisplayName());
                //StepEventBus.getEventBus().registerListener(new FlashStepListener());
                Story story = SingletonFactory.INSTANCE.getStoryContainer().getStoryByName(description.getDisplayName());

                if (story != null) {
                    try {

                        TestDataLoader testDataLoader = SingletonFactory.INSTANCE.getTestDataManager();
                        testDataLoader.getTestData(story.getName());

                        //Serenity.getCurrentSession().put("currentTestData", null);
                        //StoryDataLoaderFactory.getDataLoader(story.getDatasetPaths()).pushDataset(story);
                    } catch (Throwable e) {
                        try {
                            StepEventBus.getEventBus().testFailed(e);
                        } finally {
                            notifier.pleaseStop();
                            notifier.fireTestFailure(new Failure(description, e));
                        }
                    }
                }
            }
        });

        super.run(notifier);
    }

    @Override
    public int testCount() {
        return super.testCount();
    }
}
