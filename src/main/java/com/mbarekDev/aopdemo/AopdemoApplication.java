package com.mbarekDev.aopdemo;

import com.mbarekDev.aopdemo.dao.AccountDAO;
import com.mbarekDev.aopdemo.dao.MembershipDAO;
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
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDFAO, MembershipDAO theMembershipDAO) {

        return runner -> {
            demoTheBeforeAdvice(theAccountDFAO, theMembershipDAO);
        };

    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDFAO, MembershipDAO theMembershipDAO) {
        // call the business method
        Account myAccount = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");

        theAccountDFAO.addAccount(myAccount, true);
        theAccountDFAO.doWork();

        // call the accountdao getter / setter methods
        theAccountDFAO.setName("foobar");
        theAccountDFAO.setSeviceCode("silver");

        String name = theAccountDFAO.getName();
        String code = theAccountDFAO.getSeviceCode();

        //call the membership business method
        theMembershipDAO.addOtherAddMethod();
        theMembershipDAO.goToSleep();
    }


}
