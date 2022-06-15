package com.example.javaweb.model;

import java.util.Date;

public class im_Post {
    private int id;
    private String title;
    private Date date;
    private String description;
    private boolean authorities;
    private int commentNumber;
    private int likeNumber;
    private String idUser;
    private int idType;

    public im_Post(int id, String title, Date date, String description, boolean authorities, int commentNumber, int likeNumber, String idUser, int idType) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.authorities = authorities;
        this.commentNumber = commentNumber;
        this.likeNumber = likeNumber;
        this.idUser = idUser;
        this.idType = idType;
    }

    public im_Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAuthorities() {
        return authorities;
    }

    public void setAuthorities(boolean authorities) {
        this.authorities = authorities;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
}
