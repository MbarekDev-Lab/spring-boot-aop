package com.mbarekDev.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

//    @Override
//    public void addAccount() {
//        System.out.println(getClass() + "DOING DB WORK ADDING A MEMBERSHIP ACCOUNT ");
//    }

    @Override
    public boolean addOtherAddMethod() {
        System.out.println(getClass() + "DOING DB WORK ADDING A MEMBERSHIP ACCOUNT ");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + "I am going to sleep... ");

    }
}
