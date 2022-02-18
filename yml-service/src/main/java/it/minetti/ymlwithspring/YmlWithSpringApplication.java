package it.minetti.ymlwithspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackageClasses = {InfoVersionFromYaml.class, YmlWithSpringApplication.class})
public class YmlWithSpringApplication {
    private static final Logger log = LoggerFactory.getLogger(YmlWithSpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(YmlWithSpringApplication.class, args);
    }

    @Autowired
    InfoVersionFromYaml infoVersionFromYaml;

    @Autowired
    BuildProperties buildProperties;

    @PostConstruct
    public void setUp() {
        log.info("Current version of the service is {}, build at {}", infoVersionFromYaml.getVersion(), infoVersionFromYaml.getTime());
        log.info("Version from BuildProperties is {}", buildProperties.getVersion());
    }
}
