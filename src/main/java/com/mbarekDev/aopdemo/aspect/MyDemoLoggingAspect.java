package com.mbarekDev.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //start with a @Before advice
    //@Before("execution(public void updateAccount())")

    //@Before("execution(public void com.mbarekDev.aopdemo.dao.addAccount())")

    // this is where we add all of our related advices for logging
    // step1, Apply pointcut declaration to advice
    @Pointcut("execution(* com.mbarekDev.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
        // System.out.println("\n ----> Executing @Before advice on method ...");
    }

    // create a pointcut for getter methods
    @Pointcut("execution(* com.mbarekDev.aopdemo.dao.*.get*(..))")
    private void getter() {

    }

    // create a pointcut for setter methods
    @Pointcut("execution(* com.mbarekDev.aopdemo.dao.*.set*(..))")
    private void setter() {

    }

    // create a pointcut: include package ... executed getter / setter
    @Pointcut("forDaoPackage() && !(getter() || setter()))")
    private void forDaoPackageNoGetterSetter() {
    }


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ----> Executing @Before advice on addAccount() ");
    }

    //-> means match on any number of argumennts () use param wildcards
    // step1, Create pointcut declaration
    //    @Before("forDaoPackage()")
    //    public void beforeAddAccountAdvice2() {
    //        System.out.println("\n ----> Executing @Before advice on addAccount() ");
    //    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n ----> performing API analytics ...");
    }

}
