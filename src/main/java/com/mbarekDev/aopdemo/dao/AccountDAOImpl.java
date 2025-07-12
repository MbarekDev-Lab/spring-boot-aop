package com.mbarekDev.aopdemo.dao;

import com.mbarekDev.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String seviceCode;

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();
        // create sample accounts
        Account temp1 = new Account("Mbarek", "neni");
        Account temp2 = new Account("XYZ", "xyz");
        Account temp3 = new Account("Laura", "llll");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

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
