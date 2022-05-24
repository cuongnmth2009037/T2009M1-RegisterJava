package com.example.t2009m1demo.controllers;

import com.example.t2009m1demo.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user/register.jsp").forward(req,resp);
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
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setFullname(fullname);
        account.setEmail(email);
        account.setPhone(phone);
        account.setBirthday(birthday);
        req.setAttribute("account",account);
        req.getRequestDispatcher("/user/register-success.jsp").forward(req,resp);

    }
}