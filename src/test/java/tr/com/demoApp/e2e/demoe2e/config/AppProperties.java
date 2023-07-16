package tr.com.demoApp.e2e.demoe2e.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@ConfigurationProperties(prefix = "app")
@Service
@Getter
@Setter
public class AppProperties {
    private String baseUrl;
    private Driver driver;
    private DriverFirefox driverFirefox;
    private String select;


    @Getter
    @Setter
    @Service
    public static class Driver {

        private String path;
        private String driverClass;
        private String type;
    }

    @Getter
    @Setter
    @Service
    public static class DriverFirefox {

        private String path;
        private String driverClass;
        private String type;
    }
}
