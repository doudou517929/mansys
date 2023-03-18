package sia.mansys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ManSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManSysApplication.class, args);
    }

}
