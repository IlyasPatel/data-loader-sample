import com.efinancialcareers.domain.Company;
import com.efinancialcareers.domain.CompanyAddress;
import com.efinancialcareers.service.GroovyScriptLoaderImpl;
import com.efinancialcareers.service.Loader;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Map;

public class GroovyScriptConverterUnitTest {

    private Loader loader;
    private EntityManager entityManager;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "classpath:/applicationContext-d-loader.xml"
        );

        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) applicationContext.getBean("myEmf");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void when_I_provide_a_groovy_script_data_then_the_entities_should_be_converted_to_domain_beans_and_persisted() {
        loader = new GroovyScriptLoaderImpl(entityManager);
        final String fileAbsolutePath = FileUtils.getFileAbsolutePath("classpath:CompanyAndCompanyAddress.groovy");

        Map<String, Object> variables = loader.loadAndPersist(Lists.newArrayList(fileAbsolutePath));

        Assert.assertEquals(2, variables.size());

        int i = 0;
        for (Map.Entry<String, Object> entity : variables.entrySet()) {
            if(Company.class.getName().equals(entity.getValue().getClass().getName())) {
                final Company company = (Company) entity.getValue();

                Assert.assertTrue(NumberUtils.isNumber(String.valueOf(company.getCompanyId())));
                Assert.assertEquals("http://www.random.com", company.getUrl());

                i++;
            }

            if(CompanyAddress.class.getName().equals(entity.getValue().getClass().getName())) {
                final CompanyAddress companyAddress = (CompanyAddress) entity.getValue();

                Assert.assertTrue(NumberUtils.isNumber(String.valueOf(companyAddress.getCompanyAddressId())));
                Assert.assertEquals("Company add 1", companyAddress.getAddress1());

                i++;
            }
        }

        Assert.assertEquals(i, variables.size());
    }
    
    @Test
    public void when_I_provide_a_groovy_script_data_then_the_entities_should_be_converted_to_domain_beans_and_not_persisted() {
        loader = new GroovyScriptLoaderImpl(entityManager);
        final String fileAbsolutePath = FileUtils.getFileAbsolutePath("classpath:CompanyAndCompanyAddress.groovy");

        Map<String, Object> variables = loader.load(Lists.newArrayList(fileAbsolutePath));

        Assert.assertEquals(2, variables.size());

        int i = 0;
        for (Map.Entry<String, Object> entity : variables.entrySet()) {
            if(Company.class.getName().equals(entity.getValue().getClass().getName())) {
                final Company company = (Company) entity.getValue();

                Assert.assertNull(company.getCompanyId());
                Assert.assertEquals("http://www.random.com", company.getUrl());

                i++;
            }

            if(CompanyAddress.class.getName().equals(entity.getValue().getClass().getName())) {
                final CompanyAddress companyAddress = (CompanyAddress) entity.getValue();

                Assert.assertNull(companyAddress.getCompanyAddressId());
                Assert.assertEquals("Company add 1", companyAddress.getAddress1());

                i++;
            }
        }

        Assert.assertEquals(i, variables.size());
    }

}
