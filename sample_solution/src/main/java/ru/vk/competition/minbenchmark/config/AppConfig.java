package ru.vk.competition.minbenchmark.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import ru.vk.competition.minbenchmark.model.TableName;

@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class AppConfig implements RepositoryRestConfigurer {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void configureRepositoryRestConfiguration (RepositoryRestConfiguration configuration, CorsRegistry corsRegistry) {
        configuration.exposeIdsFor(TableName.class);
    }
}
