package com.example.t2009m1demo.model;

import com.example.t2009m1demo.entity.Account;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {

    @Test
    void save() {
        MySqlAccountModel mySqlAccountModel = new MySqlAccountModel();
        Account account = new Account(1,"cuong09", "123456", "Nguyen Manh Cuong", "cuong@gmail.com", "0999999999", "1994/03/29", 1);
        assertEquals(true, mySqlAccountModel.save(account));
    }

    @Test
    void findById() {
        MySqlAccountModel mySqlAccountModel = new MySqlAccountModel();
        assertNotEquals(null, mySqlAccountModel.findById(7));
    }

    @Test
    void findAll() {
        MySqlAccountModel mySqlAccountModel = new MySqlAccountModel();
        Account account = new Account();
        assertNotEquals(account, mySqlAccountModel.findAll());

    }

    @Test
    void update() {
        MySqlAccountModel mySqlAccountModel = new MySqlAccountModel();
        Account account = new Account(1,"LanAnhxg", "12345678", "Nguyen Lan Anh", "lananh@gmail.com", "0555555555", "1998/09/19", 1);
        assertEquals(true, mySqlAccountModel.update(7, account));

    }

    @Test
    void delete() {
       MySqlAccountModel mySqlAccountModel = new MySqlAccountModel();
       assertEquals(true, mySqlAccountModel.delete(7));

    }
}