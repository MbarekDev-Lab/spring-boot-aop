package com.mbarekDev.aopdemo.aspect;


import com.mbarekDev.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Around("execution(* com.mbarekDev.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @Around on method: " + method);

        long begin = System.nanoTime();

        Object result;

        try {
            // Proceed with the actual method
            result = theProceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("\n====> Exception caught in @Around: " + ex.getMessage());

            // Optionally: log the exception, alert, etc.
            result = "System busy. Please try again later.";

            // Optionally rethrow if you want to propagate
            // throw ex;
        }

        long end = System.nanoTime();
        long duration = end - begin;
        System.out.println("Duration: " + (duration / 1_000_000) + " ms");

        return result;
    }


    /*@Around("execution(* com.mbarekDev.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune2(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        // print outmethiod we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @After (finally) on method: " + method);

        //get begin timestamp
        //long begin = System.currentTimeMillis();
        long begin = System.nanoTime();

        //now, execute the method
        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            result = "  exception  to notify the user ---->  ";
        }

        // get end timestump
        //long end = System.currentTimeMillis();
        long end = System.nanoTime();

        // compute duration and display it
        long duration = end - begin;

        System.out.println("\n ---Duration : " + duration  + " seconds");

        return result;
    }*/

    @After("execution(* com.mbarekDev.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        // Print which method threw the exception
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @After (finally) on method: " + method);
    }


    @AfterThrowing(
            pointcut = "execution(* com.mbarekDev.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        // Print which method threw the exception
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterThrowing on method: " + method);

        // Log the exception
        System.out.println("====> The exception is: " + theExc);
    }


    //add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.mbarekDev.aopdemo.dao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n -----> Executing @AfterReturning on method : " + method);

        // print out the resuls of the method call
        System.out.println("\n -----> result is : " + result);

        // let's post-process the data ... and modify is.
        // convert the account names to uppercase
        convertAccountNameToUppercase(result);

    }

    private void convertAccountNameToUppercase(List<Account> resultList) {
        // loop throught accounts
        for (Account tempAccount : resultList) {
            // get an uppercase version of name
            String theUpperCase = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperCase);
        }
    }


    @Before("com.mbarekDev.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n ----> Executing @Before advice on addAccount() ");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments
        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through args
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                //cast and print Account apicic stuff
                // extracted((Account) tempArg);
                Account theAccount = (Account) tempArg;
                System.out.println("account name : " + theAccount.getName());
                System.out.println("account level : " + theAccount.getLevel());
            }
        }


    }

    private static void extracted(Account tempArg) {
        Account theAccount = tempArg;
    }
    //-> means match on any number of argumennts () use param wildcards
    // step1, Create pointcut declaration
    //    @Before("forDaoPackage()")
    //    public void beforeAddAccountAdvice2() {
    //        System.out.println("\n ----> Executing @Before advice on addAccount() ");
    //    }

}
