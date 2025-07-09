package com.mbarekDev.aopdemo;

import com.mbarekDev.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDFAO) {

        return runner -> {
            demoTheBeforeAdvice(theAccountDFAO);
        };

    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDFAO) {
        // call the business method
        theAccountDFAO.addAccount();

        // call the business method again
        theAccountDFAO.addAccount();
    }


}
