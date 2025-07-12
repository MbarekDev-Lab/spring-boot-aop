package com.mbarekDev.aopdemo;

import com.mbarekDev.aopdemo.dao.AccountDAO;
import com.mbarekDev.aopdemo.dao.AccountDAOImpl;
import com.mbarekDev.aopdemo.dao.MembershipDAO;
import com.mbarekDev.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AccountDAO theAccountDFAO,
            MembershipDAO theMembershipDAO,
            TrafficFortuneService theTrafficFortuneService

    ) {

        return runner -> {
            //demoTheBeforeAdvice(theAccountDFAO, theMembershipDAO);
            // demoTheAfterReturningAdvice(theAccountDFAO);
            //demoTheAfterThrowingAdvice(theAccountDFAO);
            //demoTheAfterAdvice(theAccountDFAO);
            //demoTheAroundAdvice(theTrafficFortuneService);
            demoTheAroundAdviceHandlingExeption(theTrafficFortuneService);

        };
    }

    private void demoTheAroundAdviceHandlingExeption(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain Program : demoTheAroundAdviceHandlingExeption ");
        System.out.println("Calling getFortuneService");

        boolean theTripWire = true;
        String data = theTrafficFortuneService.getFortune(theTripWire);
        System.out.println("\n My fottune is :  " + data);

        System.out.println(" Finished ");
    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain Program : demoTheAroundAdvice ");
        System.out.println("Calling getFortuneService");

        String data = theTrafficFortuneService.getFortune();
        System.out.println("\n My fottune is :  " + data);

        System.out.println(" Finished ");

    }

    private void demoTheAfterAdvice(AccountDAO theAccountDFAO) {
        try {
            // call method to find the Accounts
            List<Account> theAccounts = null;

            // add a boolean flag to simulate exceptions
            boolean tripWire = false;
            theAccounts = theAccountDFAO.findAccounts(tripWire);

        } catch (Exception exception) {
            System.out.println(" Main Program : caught exception :  " + exception);
        }

        // display the Accounts
        System.out.println(" Main Program : demoTheAfterThrowingAdvice  :  ");
        System.out.println("------------");

        //System.out.println(theAccounts);
        System.out.println("\n");

    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDFAO) {
        // call method to find the Accounts
        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            theAccounts = theAccountDFAO.findAccounts(tripWire);

        } catch (Exception exception) {
            System.out.println(" Main Program : caught exception :  " + exception);
        }

        // display the Accounts
        System.out.println(" Main Program : demoTheAfterThrowingAdvice  :  ");
        System.out.println("------------");

        System.out.println(theAccounts);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDFAO) {
        // call method to find the Accounts
        List<Account> theAccounts = theAccountDFAO.findAccounts();

        // display the Accounts
        System.out.println(" Main Program : demoTheAfterReturningAdvice  :  ");
        System.out.println("------------");

        System.out.println(theAccounts);
        System.out.println("\n");
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
