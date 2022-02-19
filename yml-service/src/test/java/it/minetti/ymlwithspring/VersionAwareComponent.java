package it.minetti.ymlwithspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class VersionAwareComponent {
    private static final Logger log = LoggerFactory.getLogger(VersionAwareComponent.class);

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
