package com.david.springData.mysql;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.david.springData.mysql.dao")
@EnableTransactionManagement
@ComponentScan("com.david.springData.mysql.dao, com.david.springData.mysql.service")
public class DataConfiguration {

	@Bean
	public DataSource dataSourceH2(){
		EmbeddedDatabaseBuilder build=new EmbeddedDatabaseBuilder();
		return build.setType(EmbeddedDatabaseType.H2).build();
	}
	
	@Bean
	public DataSource dataSourceMySql(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbtest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		Properties jpaProperties=new Properties();
		jpaProperties.put(Environment.HBM2DDL_AUTO, "validate");
		jpaProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		jpaProperties.put(Environment.HBM2DDL_IMPORT_FILES, "import.sql");
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSourceMySql());
		factory.setPackagesToScan("com.david.springData.mysql.model");
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Bean 
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager txManager=new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
}
