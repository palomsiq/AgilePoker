package com.agile.poker.agilepoker.infrastructure;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean
    public Flyway flyway(@Qualifier("dataSource") DataSource dataSource){
        final var classicConfiguration  = new ClassicConfiguration();
        classicConfiguration.setDataSource(dataSource);
        classicConfiguration.setLocations(new Location("classpath:migrations"));
        final var flywayConfiguration = new Flyway(classicConfiguration);
        flywayConfiguration.migrate();
        return flywayConfiguration;
    }

}
