package com.example.t2009m1demo.controllers;

import com.example.t2009m1demo.entity.Account;
import com.example.t2009m1demo.entity.User;
import com.example.t2009m1demo.model.MySqlAccountModel;

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
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setBirthday(birthday);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/user/register-success.jsp").forward(req,resp);
    }
}
