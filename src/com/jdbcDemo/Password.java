package com.jdbcDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Password extends HttpServlet{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/password";
    static final String USER = "root";
    static final String PASS = "root";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        Connection conn = null;
        Statement stmt = null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        out.println("<!DOCTYPE html>\n" +
        "<html>\n<body>\n" +
        "<table>\n" +
        "<tr><td>名称</td><td>链接</td><tr/>");
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement");
            stmt = conn.createStatement();
            String sql = "select * from password";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String name = rs.getString("name");
                String url = rs.getString("url");
                out.println("<tr><td>"+name+"</td><td>"+url+"</td><tr/>");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception se) {
            out.println("<h3 color='red'>error</h3>");
            se.printStackTrace();
        }
        out.println("</table></html>");
    }
}
