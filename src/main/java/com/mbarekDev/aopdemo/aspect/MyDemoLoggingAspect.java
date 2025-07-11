package com.mbarekDev.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Before("com.mbarekDev.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ----> Executing @Before advice on addAccount() ");
    }

    //-> means match on any number of argumennts () use param wildcards
    // step1, Create pointcut declaration
    //    @Before("forDaoPackage()")
    //    public void beforeAddAccountAdvice2() {
    //        System.out.println("\n ----> Executing @Before advice on addAccount() ");
    //    }

}
