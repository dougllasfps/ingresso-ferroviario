package br.com.digitoglobal.ferroviario.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "br.com.digitoglobal.ferroviario.model.entity")
@EnableJpaRepositories(basePackages = {"br.com.digitoglobal.ferroviario.model.repository"})
public class DataBaseConfiguration {

}
