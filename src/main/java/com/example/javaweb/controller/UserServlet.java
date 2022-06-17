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
            case "main":
                MainUser(request,response);
                break;
            case "register":
                Register(request, response);
                break;
            case "listuser":
                ListUser(request,response);
                break;
            case "edit":
                EditUser(request,response);
                break;
            case "dangxuat":
                Logout(request,response);
                break;
            default:
                UILoginn(request, response);
                break;
        }
    }

    private void Logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/main.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void EditUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session= request.getSession();
        im_User user_login= (im_User) session.getAttribute("user");
        String id= user_login.getId();
        im_User users = this._dbcontext.FindById(id);
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/editUser.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ListUser(HttpServletRequest request, HttpServletResponse response) {
        List<im_User> users = this. _dbcontext.GetAll();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/dsuser.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void Register(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        if(username!=null&&pass!=null&&email!=null)
        {
            this._dbcontext.register(username,pass,email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/register.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void UILoginn(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        String username=request.getParameter("username");
        String pass=request.getParameter("password");

        im_User user=this._dbcontext.checkUser(username,pass);
        session.setAttribute("user",user);
        if(user==null)
        {
            //kiểm tra xem nó đang đăng ký hay đăng nhập

                RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        else
        {
            //request.setAttribute("users", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/main.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void MainUser(HttpServletRequest request, HttpServletResponse response) {
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
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action)
        {
            case "login":
                UILoginn(request,response);
                break;
            case "register":
                Register(request, response);
                break;
            case "edit":
                UpdateUser(request,response);
                break;

        }
    }

    private void UpdateUser(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String phonenumber=request.getParameter("phone");

        im_User user=this._dbcontext.FindById(id);
        RequestDispatcher dispatcher;
        if(user == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            user.setName(name);
            user.setEmail(email);
            user.setAddress(address);
            user.setUsername(username);
            user.setPhoneNumber(phonenumber);
            this._dbcontext.updateUser(user);
            request.setAttribute("users", user);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("user/editUser.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
