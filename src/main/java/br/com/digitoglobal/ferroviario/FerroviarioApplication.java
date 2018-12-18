package br.com.digitoglobal.ferroviario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FerroviarioApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FerroviarioApplication.class, args);
    }
}
