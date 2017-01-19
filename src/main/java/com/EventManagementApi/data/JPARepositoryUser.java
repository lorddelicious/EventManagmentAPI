package com.EventManagementApi.data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by Shravan Deolalikar on 1/19/2017.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManager",
        basePackages = { "com.EventManagementApi.data.user.repo" })
public class JPARepositoryUser {
    @Bean(name = "springSecondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.secondDatasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean nonUserEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("springSecondaryDataSource") DataSource springDataSource) {
        return builder
                .dataSource(secondaryDataSource())
                .packages("com.EventManagementApi.data.secondary")
                .persistenceUnit("user")
                .build();
    }

    @Bean(name = "nonUserTransactionManager")
    public PlatformTransactionManager nonUserTransactionManager(
            @Qualifier("userEntityManagerFactory") EntityManagerFactory nonUserEntityManagerFactory) {
        return new JpaTransactionManager(nonUserEntityManagerFactory);
    }
}
