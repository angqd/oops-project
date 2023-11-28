package com.example.demo3.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class BBuserConfig {
    @Bean
    CommandLineRunner commandLineRunner(BBuserRepo userRepo){
        return args -> {
            BBuser angad = new BBuser(
                    "Angad",
                    "angadbawa02@gmai.com",
                    9082350859L
            );
            BBuser ishan = new BBuser(
                    "ishan",
                    "ishan@gmail.com",
                    9619882330L
            );
            userRepo.saveAll(
                    List.of(angad,ishan)
            );
        };
    }
}
