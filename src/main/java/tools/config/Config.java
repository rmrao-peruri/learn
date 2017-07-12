package tools.config;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import tools.mybatis.mapper.PaymentMapper;

import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
		entityManagerFactoryRef = "entityManagerFactory",
		basePackages = {"tools.jpa.repo"} )
@MapperScan("tools.mybatis.mapper")
@EnableConfigurationProperties(DbProp.class)

public class Config {
	@Autowired
	DbProp dbProp;
	
	@Bean(name="allDataSources")
	public Map<String, DataSource> allDataSources() {
		Map<String, DataSource> allDs = new HashMap<String, DataSource>();
		Map<String,DataSourceProperties> x = dbProp.getSchemas();
		for( String y:x.keySet()) {
			DataSourceProperties z = x.get(y);
			System.out.println("Country " + y + " Url " + z.getUrl());
			allDs.put(y, z.initializeDataSourceBuilder().build());
		}
		
		return allDs;
	}
	
	@Bean(name="allSqlSessionFactory")
	public Map<String, SqlSessionFactory> allSqlSessionFactory()
	throws Exception {
		Map<String, SqlSessionFactory> allSsf = new HashMap<String, SqlSessionFactory>();
		Map<String, DataSource>allDs = allDataSources();
		for( String y:allDs.keySet()) {
			SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
			MapperScannerConfigurer configurer = new MapperScannerConfigurer();
	        configurer.setBasePackage("tools.mybatis.mapper");
	        ssf.setDataSource(allDs.get(y));
		}
		return allSsf;
	}
	
	@Bean (name = "dataSource")
	public DataSource dataSource() {
		Map<String, DataSource>allDs = allDataSources();
		return allDs.get("sg");
//		return DataSourceBuilder.create().build();
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
	    EntityManagerFactoryBuilder builder,
	    @Qualifier("dataSource") DataSource dataSource) {
	    return builder
	            .dataSource(dataSource)
	            .packages("tools.jpa.data")
	            .build();
	}
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
	    @Qualifier("entityManagerFactory") EntityManagerFactory emf) {
	    return new JpaTransactionManager(emf);
	}

	@Bean 
	public SqlSessionFactory sqlSessionFactory(
	    @Qualifier("dataSource") DataSource ds) 
	throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(ds);
		return (SqlSessionFactory)ssf.getObject();
	}
	
}
