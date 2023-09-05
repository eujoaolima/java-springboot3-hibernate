package com.aop.estudos.aopdemo.dao;

import com.aop.estudos.aopdemo.entity.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    public String getName() ;

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
