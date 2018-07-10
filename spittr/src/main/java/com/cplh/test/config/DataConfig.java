package com.cplh.test.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataConfig {
	
	@Bean
	public DataSource devDatabase(){
		 return new EmbeddedDatabaseBuilder()
         .setType(EmbeddedDatabaseType.H2)
         .addScript("schema.sql")
         .addScript("data.sql")
         .build();
	}
	
	@Profile("product")
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/spitter");
		ds.setUsername("sa");
		ds.setPassword("");
		ds.setInitialSize(5);
		ds.setMaxTotal(10);;
		return ds;
	}
	
	@Profile("qa")
	@Bean
	public DriverManagerDataSource jdbcDatasource(){
		DriverManagerDataSource driverManageDatasource=new DriverManagerDataSource();
		driverManageDatasource.setDriverClassName("org.h2.Driver");
		driverManageDatasource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
		driverManageDatasource.setUsername("sa");
		driverManageDatasource.setPassword("");		
		return driverManageDatasource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource){
		JdbcTemplate jdbcTemplate=new JdbcTemplate(datasource);
		return jdbcTemplate;
		
	}
}
