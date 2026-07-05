package com.bohdan;

import com.bohdan.config.TariffProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = TariffProperties.class)
@ConfigurationPropertiesScan
public class RailwayTicketsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailwayTicketsSystemApplication.class, args);
    }

}
