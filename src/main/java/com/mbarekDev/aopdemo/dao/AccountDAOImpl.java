package com.mbarekDev.aopdemo.dao;

import com.mbarekDev.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String seviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + "DOING DB WORK ");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "doWork ");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + "getName ");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + "setName ");
        this.name = name;
    }

    public String getSeviceCode() {
        System.out.println(getClass() + "getSeviceCode ");
        return seviceCode;
    }

    public void setSeviceCode(String seviceCode) {
        System.out.println(getClass() + "setSeviceCode ");
        this.seviceCode = seviceCode;
    }
}
