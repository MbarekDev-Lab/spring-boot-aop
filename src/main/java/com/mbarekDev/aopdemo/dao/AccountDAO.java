package com.mbarekDev.aopdemo.dao;

import com.mbarekDev.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    // add a new method: findAccounts()
    List<Account> findAccounts();

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);


    public String getSeviceCode();

    public void setSeviceCode(String seviceCode);

}
