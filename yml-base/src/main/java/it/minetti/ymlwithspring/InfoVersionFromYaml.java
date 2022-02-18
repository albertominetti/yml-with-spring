package it.minetti.ymlwithspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
public class InfoVersionFromYaml {

    @Value("${app.version}")
    String version;
    @Value("${app.time}")
    String time;

    public String getVersion() {
        return version;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InfoVersionFromYaml.class.getSimpleName() + "[", "]")
                .add("version='" + version + "'")
                .add("time='" + time + "'")
                .toString();
    }
}
