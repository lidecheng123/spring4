package com.cplh.test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages="com.cplh.test.data")
public class JpaConfig {
	/*@Autowired
	private DataSource dataSource;
	*/
	  @Bean
	  public HibernateJpaVendorAdapter jpaVendorAdapter() {
	    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setDatabase(Database.H2);
	    adapter.setShowSql(false);
	    adapter.setGenerateDdl(true);
	    return adapter;
	  }
	  
	  @Bean
	  public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter) {
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource);
//	    emf.setPersistenceUnitName("spitter");
	    emf.setJpaVendorAdapter(jpaVendorAdapter());
	    emf.setPackagesToScan("com.cplh.test.data");
	    return emf;
	  }
  
}
