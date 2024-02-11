package com.example.db.datasource;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "bookingEntityManagerFactory",
        transactionManagerRef = "bookingTransactionManager",
        basePackages = "com.example.db.repository.repository1"
)
public class BookingDBConfig {
    @Bean(name = "bookingDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bookingEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bookingEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("bookingDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.example.db.entity.entityone").persistenceUnit("employees")
                .build();
    }

    @Bean(name = "bookingTransactionManager")
    public PlatformTransactionManager barTransactionManager(
            @Qualifier("bookingEntityManagerFactory") EntityManagerFactory bookingEntityManagerFactory) {
        return new JpaTransactionManager(bookingEntityManagerFactory);
    }
}
