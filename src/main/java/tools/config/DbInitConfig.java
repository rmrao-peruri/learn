package tools.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class DbInitConfig {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@ConditionalOnExpression("#{ ${init-db} == 1 }")
	@Bean
	@Transactional
	public Jackson2RepositoryPopulatorFactoryBean populateRepository() 
	throws Exception {
		logger.info("Reading test-data.json");
        Resource sourceData = new ClassPathResource("data/test-data.json");
        
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setResources(new Resource[] { sourceData });
        logger.info( "My Data: " + sourceData.toString());

        return factory;
	}
	
}
