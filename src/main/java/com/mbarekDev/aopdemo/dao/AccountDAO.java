package com.mbarekDev.aopdemo.dao;

import com.mbarekDev.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);


    public String getSeviceCode();

    public void setSeviceCode(String seviceCode);

}
