package com.mbarekDev.aopdemo.aspect;


import com.mbarekDev.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Before("com.mbarekDev.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n ----> Executing @Before advice on addAccount() ");
        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments
        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
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
