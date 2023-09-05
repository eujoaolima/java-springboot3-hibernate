package com.aop.estudos.aopdemo.dao;

import com.aop.estudos.aopdemo.entity.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
