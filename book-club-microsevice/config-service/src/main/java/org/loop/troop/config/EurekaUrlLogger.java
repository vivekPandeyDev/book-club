package org.loop.troop.config;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EurekaUrlLogger {

    private final Environment environment;

    @Autowired
    public EurekaUrlLogger(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void logEurekaUrl() {
        String defaultZone = environment.getProperty("eureka.client.service-url.defaultZone");
        log.info("Eureka defaultZone = {}" , defaultZone);
    }
}