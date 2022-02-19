package it.minetti.ymlwithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {InfoVersionFromYaml.class, YmlWithSpringApplication.class})
public class YmlWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmlWithSpringApplication.class, args);
    }

}
