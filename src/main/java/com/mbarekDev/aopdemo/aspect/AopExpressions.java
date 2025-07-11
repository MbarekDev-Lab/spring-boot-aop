package com.mbarekDev.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    //start with a @Before advice
    //@Before("execution(public void updateAccount())")

    //@Before("execution(public void com.mbarekDev.aopdemo.dao.addAccount())")

    // this is where we add all of our related advices for logging
    // step1, Apply pointcut declaration to advice
    @Pointcut("execution(* com.mbarekDev.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
        // System.out.println("\n ----> Executing @Before advice on method ...");
    }

    // create a pointcut for getter methods
    @Pointcut("execution(* com.mbarekDev.aopdemo.dao.*.get*(..))")
    public void getter() {

    }

    // create a pointcut for setter methods
    @Pointcut("execution(* com.mbarekDev.aopdemo.dao.*.set*(..))")
    public void setter() {

    }

    // create a pointcut: include package ... executed getter / setter
    @Pointcut("forDaoPackage() && !(getter() || setter()))")
    public void forDaoPackageNoGetterSetter() {
    }

}
