package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration

@SpringBootApplication
public class Teste4Application {

    public static void main(String[] args) {
        SpringApplication.run(Teste4Application.class, args);
    }
}
