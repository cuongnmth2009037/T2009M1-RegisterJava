package com.example.t2009m1demo.model;

import com.example.t2009m1demo.entity.Account;

import java.util.List;

public interface AccountModel {
    boolean save(Account account);
    boolean update(int id, Account updateAccount);
    boolean delete(int id);
    Account findById(int id);
    List<Account> findAll();
}
