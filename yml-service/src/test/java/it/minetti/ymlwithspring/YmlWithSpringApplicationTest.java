package it.minetti.ymlwithspring;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.matchesPattern;

@SpringBootTest
class YmlWithSpringApplicationTest {

    LogCaptor logCaptor;

    @Autowired
    VersionAwareComponent component;

    @BeforeEach
    void beforeEach() {
        logCaptor = LogCaptor.forClass(VersionAwareComponent.class);
    }

    @Test
    void contextLoads() {
        // when
        component.setUp();

        // then
        assertThat(logCaptor.getInfoLogs(), (hasItem(matchesPattern("Current version of the service is 0.0.1-SNAPSHOT, build at [-:\\.TZ0-9]+"))));
        assertThat(logCaptor.getInfoLogs(), (hasItem(matchesPattern("Version from BuildProperties is 0.0.1-SNAPSHOT"))));

    }

}
