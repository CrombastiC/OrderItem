package com.dletc.domain;

public class User {
    private int UserID;
    private String UserName;
    private String PassWord;
    private int IsAdmin;
    // 0:普通用户 1:管理员

    public User() {
    }

    public User(int userID, String userName, String passWord, int isAdmin) {
        UserID = userID;
        UserName = userName;
        PassWord = passWord;
        IsAdmin = isAdmin;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public int getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        IsAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", IsAdmin=" + IsAdmin +
                '}';
    }
}
