package com.efinancialcareers.jbehave.qa;

import com.efinancialcareers.service.GroovyScriptLoaderImpl;
import com.efinancialcareers.service.Loader;
import com.google.common.collect.Maps;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;

public class TestDataManager implements TestDataLoader {
    private Loader loader;
    private final Map<String, Map<String, Object>> stories = Maps.newConcurrentMap();

    public TestDataManager() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/applicationContext.xml"
        );

        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) applicationContext.getBean("myEmf");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        this.loader = new GroovyScriptLoaderImpl(entityManager);
    }

    @Override
    public void insertTestDataSet(String name, List<String> dataSetPaths) {
        Map<String, Object> loadedData = loader.loadAndPersist(dataSetPaths);

        stories.put(name, loadedData);
    }

    @Override
    public Map<String, Object> getTestData(String name) {
        return stories.get(name);
    }
}
