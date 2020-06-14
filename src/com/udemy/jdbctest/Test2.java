package com.udemy.jdbctest;


import java.sql.Connection;
import java.sql.DriverManager;

public class Test2 {
    public static void main(String[] args) {
        // setup connection variables
        String user = "springstudent";
        String pass = "springstudent";
        String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        // get connection to database

        try {
            System.out.println("Connecting to database: " + url);
            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(url, user, pass);
            System.out.println("SUCCESS !!!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
