package com.mbarekDev.aopdemo.dao;

import com.mbarekDev.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + "DOING DB WORK ");
    }
}
