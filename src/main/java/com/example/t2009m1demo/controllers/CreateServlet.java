package com.example.t2009m1demo.controllers;

import com.example.t2009m1demo.entity.Account;
import com.example.t2009m1demo.model.MySqlAccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateServlet extends HttpServlet {
    private MySqlAccountModel mySqlAccountModel;

    @Override
    public void init() throws ServletException {
        mySqlAccountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username =  req.getParameter("username");
        String password =  req.getParameter("password");
        String fullname =  req.getParameter("fullname");
        String email =  req.getParameter("email");
        String phone =  req.getParameter("phone");
        String birthday =  req.getParameter("birthday");
        int status = Integer.parseInt(req.getParameter("status"));
        Account account = new Account(username, password, fullname, email, phone, birthday, status);
        mySqlAccountModel.save(account);
        resp.sendRedirect("/users");
    }
}
