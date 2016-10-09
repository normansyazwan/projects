package com.bharatonjava.matri.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "com.bharatonjava.matri" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@PropertySource("classpath:placeholder.properties")
public class RootConfig {

	private static final Logger logger = LoggerFactory.getLogger(RootConfig.class);
	
	@Value("${jdbc.databaseurl}")
	private String databaseurl;

	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	public void setDatabaseurl(String databaseurl) {
		this.databaseurl = databaseurl;
	}
	
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Bean(destroyMethod = "close", name = "dataSource")
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(this.driverClassName);
		basicDataSource.setUrl(this.databaseurl);
		basicDataSource.setUsername(this.username);
		basicDataSource.setPassword(this.password);
		basicDataSource.setInitialSize(5);
		basicDataSource.setMinIdle(5);
		basicDataSource.setMaxIdle(10);
		return basicDataSource;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource);
		return tm;
	}
	
	@Bean 
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
}
