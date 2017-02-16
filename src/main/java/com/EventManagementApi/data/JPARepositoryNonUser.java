package com.EventManagementApi.data;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * Created by Shravan Deolalikar on 1/19/2017.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "nonUserEntityManagerFactory",
        transactionManagerRef = "nonUserTransactionManager",
        basePackages = { "com.EventManagementApi.data.nonuser.repo" })
public class JPARepositoryNonUser {
    @Bean(name = "springDataSource")
    @Qualifier("springDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

	// @PersistenceContext(unitName = "nonuser")
    @Primary
	@Qualifier("nonUserEntityManagerFactory")
    @Bean(name = "nonUserEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean nonUserEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("springDataSource") DataSource springDataSource) {
        return builder
                .dataSource(primaryDataSource())
                .packages("com.EventManagementApi.data.entity")
                .persistenceUnit("nonuser")
                .build();
    }

    @Bean(name = "nonUserTransactionManager")
    public PlatformTransactionManager nonUserTransactionManager(
            @Qualifier("nonUserEntityManagerFactory") EntityManagerFactory nonUserEntityManagerFactory) {
        return new JpaTransactionManager(nonUserEntityManagerFactory);
    }
}
