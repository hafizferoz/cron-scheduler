/**
 * 
 */
package com.privasia.scheduler;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.privasia.scheduler.service.CurrentDateTimeService;
import com.privasia.scheduler.util.AuditingDateTimeProvider;
import com.privasia.scheduler.util.UserIDAuditorAwareService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Hafiz Feroz
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(dateTimeProviderRef = "cbasDateTimeProvider")
@EnableJpaRepositories(basePackages = "com.privasia.scheduler.repo.cbas",
    entityManagerFactoryRef = "cbasEntityManagerFactory", transactionManagerRef = "cbasTransactionManager")
@EntityScan(basePackages = {"com.privasia.scheduler.model"})
@EnableAutoConfiguration
public class PersistenceContextCBAS {
	
  /*@Configuration
  @Profile("dev")
  @PropertySource({"classpath:application-dev.properties"})
  static class Dev {
  }

  @Configuration
  @Profile("prod")
  @PropertySource({"classpath:application-prod.properties"})
  static class Prod {
  }

  @Configuration
  @Profile("uat")
  @PropertySource({"classpath:application-uat.properties"})
  static class Uat {
  }
*/


  @Bean
  public AuditorAware<Long> auditorProvider() {
    return new UserIDAuditorAwareService();
  }

  @Bean(name = "cbasDateTimeProvider")
  public DateTimeProvider cosmosOracleDateTimeProvider(
      @Qualifier("cbasCurrentDateTimeService") CurrentDateTimeService currentDateTimeService) {
    return new AuditingDateTimeProvider(currentDateTimeService);
  }
  
  @Bean(name = "cbasDataSource", destroyMethod = "close")
  public DataSource cbasDataSource(Environment env) {

    HikariConfig dataSourceConfig = new HikariConfig();
    dataSourceConfig.setDriverClassName(env.getRequiredProperty("cbas.datasource.driver"));
    dataSourceConfig.setJdbcUrl(env.getRequiredProperty("cbas.datasource.url"));
    dataSourceConfig.setUsername(env.getRequiredProperty("cbas.datasource.username"));
    dataSourceConfig.setPassword(env.getRequiredProperty("cbas.datasource.password"));
    dataSourceConfig.setPoolName(env.getRequiredProperty("cbas.datasource.poolname"));

    dataSourceConfig.setConnectionTestQuery(env.getRequiredProperty("cbas.datasource.validationQuery"));

    dataSourceConfig.setConnectionTimeout(Long.parseLong(env.getRequiredProperty("cbas.datasource.connectionTimeout")));
    dataSourceConfig.setIdleTimeout(Long.parseLong(env.getRequiredProperty("cbas.datasource.idleTimeout")));
    dataSourceConfig.setInitializationFailFast(false);
    dataSourceConfig
        .setLeakDetectionThreshold(Long.parseLong(env.getRequiredProperty("cbas.datasource.leakDetection.threshold")));
    dataSourceConfig.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("cbas.datasource.maximumPoolSize")));
    dataSourceConfig.setMaxLifetime(Integer.parseInt(env.getRequiredProperty("cbas.datasource.maxLifetime")));
    dataSourceConfig.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("cbas.datasource.minimumIdle")));


    dataSourceConfig.addDataSourceProperty("prepStmtCacheSize",
        Integer.parseInt(env.getRequiredProperty("cbas.dataSource.prepStmtCacheSize")));
    dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit",
        Integer.parseInt(env.getRequiredProperty("cbas.dataSource.prepStmtCacheSqlLimit")));
    dataSourceConfig.addDataSourceProperty("useServerPrepStmts",
        Boolean.parseBoolean(env.getRequiredProperty("cbas.dataSource.cachePrepStmts")));


    return new HikariDataSource(dataSourceConfig);

  }

  @Bean(name = "cbasEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean cbasEntityManagerFactory(@Qualifier("cbasDataSource") DataSource dataSource,
      Environment env) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPackagesToScan("com.privasia.scheduler.model",
        "org.springframework.data.jpa.convert.threeten");

    Properties jpaProperties = new Properties();

    // Configures the used database dialect. This allows Hibernate to create SQL
    // that is optimized for the used database.
    jpaProperties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));

    // Specifies the action that is invoked to the database when the Hibernate
    // SessionFactory is created or closed.
    // jpaProperties.put("hibernate.hbm2ddl.auto",
    // env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));

    // Configures the naming strategy that is used when Hibernate creates
    // new database objects and schema elements
    jpaProperties.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("spring.jpa.hibernate.naming-strategy"));

    // If the value of this property is true, Hibernate writes all SQL
    // statements to the console.
    jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));

    // If the value of this property is true, Hibernate will format the SQL
    // that is written to the console.
    jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("spring.jpa.format_sql"));

    jpaProperties.put("hibernate.enable_lazy_load_no_trans",
        env.getRequiredProperty("spring.jpa.properties.hibernate.enable_lazy_load_no_trans"));

    jpaProperties.put("hibernate.open-in-view", env.getRequiredProperty("spring.jpa.open-in-view"));

    entityManagerFactoryBean.setJpaProperties(jpaProperties);

    return entityManagerFactoryBean;
  }

  @Bean(name = "cbasTransactionManager")
  public JpaTransactionManager cbasTransactionManager(
      @Qualifier("cbasEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }
  


}
