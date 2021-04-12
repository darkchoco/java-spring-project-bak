package kr.cloudscape.spring.simple_rest_api_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class SimpleRestApiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRestApiServerApplication.class, args);
    }

}
