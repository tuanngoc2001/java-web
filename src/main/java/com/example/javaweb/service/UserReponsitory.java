package com.example.javaweb.service;

import com.example.javaweb.model.im_User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserReponsitory implements IUserReponsitory{
    private String jdbcUrl="jdbc:mysql://localhost:3306/db";
    private String username="root";
    private String password="ngoc06112001";
    private static final String GET_USER_ALL="SELECT  *FROM im_user";

    private static final String GET_USER_GETBYID="SELECT * FROM im_user WHERE id=?";
    private static final String INSERT_USER="INSERT INTO im_user(title,username,password,status,avatar,name,address,sdt,date,admin,act)";
    private static final String UPDATE_USER="UPDATE im_user SET username=?,password=?,status=?,avatar=?,name=?,address=?,sdt=?,date=?,admin=?,act=? where id=?; ";
//    private static final String DELETE_USER="DELETE FROM im_user WHERE Id=?";
//    private static final String GET_BY_KEY="SELECT * FROM im_user WHERE name like '%"name%'";

    private Connection getConnection()
    {
        Connection connection=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<im_User> GetAll() {
        List<im_User>lstUser=new ArrayList<>();
        try
        {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ALL);

            //add dependenci
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next())
            {
                im_User user=new im_User(rs.getString("id"),rs.getString("username"),
                        rs.getString("password"),rs.getBoolean("status"),rs.getString("avatar"),
                        rs.getString("name"),rs.getString("address"),rs.getString("sdt"),
                        rs.getDate("date"),rs.getBoolean("admin"),rs.getBoolean("act"));
                lstUser.add(user);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //thi???u logger
            //log4j ????? ghi log
        }
        return lstUser;


    }

    @Override
    public void addUser(im_User user) {
        try
        {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setBoolean(3,user.isStatus());
            preparedStatement.setString(4,user.getAvatar());
            preparedStatement.setString(5,user.getName());
            preparedStatement.setString(6,user.getAddress());
            preparedStatement.setString(7,user.getPhoneNumber());
            preparedStatement.setDate(8, (Date) user.getDate());
            preparedStatement.setBoolean(9,user.isAdmin());
            preparedStatement.setBoolean(10,user.isAct());

            preparedStatement.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(im_User user) {
        try
        {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setBoolean(3,user.isStatus());
            preparedStatement.setString(4,user.getAvatar());
            preparedStatement.setString(5,user.getName());
            preparedStatement.setString(6,user.getAddress());
            preparedStatement.setString(7,user.getPhoneNumber());
            preparedStatement.setDate(8, (Date) user.getDate());
            preparedStatement.setBoolean(9,user.isAdmin());
            preparedStatement.setBoolean(10,user.isAct());
            preparedStatement.setString(11,user.getId());


            //c??u l???nh n??y d??ng ????? update b???n c???p nh???t m???i

            preparedStatement.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public im_User findByName(String key) {
        im_User user = null;
        try
        {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM im_user WHERE username like ?");
            preparedStatement.setString(1,key);
            //add dependenci
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next())
            {
                user=new im_User(rs.getString("id"),rs.getString("username"),
                        rs.getString("password"),rs.getBoolean("status"),rs.getString("avatar"),
                        rs.getString("name"),rs.getString("address"),rs.getString("sdt"),
                        rs.getDate("date"),rs.getBoolean("admin"),rs.getBoolean("act"));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            //thi???u logger
            //log4j ????? ghi log
        }
        return user;

    }

    @Override
    public im_User checkUser(String username, String password) {
        im_User user = null;
        try
        {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM im_user WHERE username = ? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            //add dependenci
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next())
            {
                user=new im_User(rs.getString("id"),rs.getString("username"),
                        rs.getString("password"),rs.getBoolean("status"),rs.getString("avatar"),
                        rs.getString("name"),rs.getString("address"),rs.getString("sdt"),
                        rs.getDate("date"),rs.getBoolean("admin"),rs.getBoolean("act"));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            //thi???u logger
            //log4j ????? ghi log
        }
        return user;
    }
}
