package it.minetti.ymlwithspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
public class InfoVersionFromYaml {

    @Value("${app.version}")
    String version;

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InfoVersionFromYaml.class.getSimpleName() + "[", "]")
                .add("version='" + version + "'")
                .toString();
    }
}
