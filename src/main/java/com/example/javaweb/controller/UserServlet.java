package com.example.javaweb.controller;

import com.example.javaweb.model.im_User;
import com.example.javaweb.service.IUserReponsitory;
import com.example.javaweb.service.UserReponsitory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserReponsitory _dbcontext=new UserReponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){

            case "login":
                UILoginn(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void UILoginn(HttpServletRequest request, HttpServletResponse response) {


        RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<im_User> users = this. _dbcontext.GetAll();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/main.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
