package com.mbarekDev.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging


    //start with an @Bedfor advice
    //@Before("execution(public void updateAccount())")

    //@Before("execution(public void com.mbarekDev.aopdemo.dao.addAccount())")
// .. -> means match on any number of argumennts () use param wildcards
    @Before("execution(* com.mbarekDev.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n ----> Executing @Before advice on addAccount() ");
    }
}
