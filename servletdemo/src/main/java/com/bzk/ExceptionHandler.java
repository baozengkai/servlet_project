package com.bzk;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler extends HttpServlet{

    @Override
    public void init() throws SecurityException{}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取异常的错误码
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        // 获取Servlet名称
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
        // 获取异常抛出类型
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");


        // 定义输出流
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // 判断输出的内容
        if(throwable == null && statusCode == null){
            out.println("<h1>错误信息丢失</h1>");
        }else if(statusCode != null){
            out.println("<h1>http错误码: "+statusCode+"</h1>");
        }else{
            out.println("<h2>错误信息</h2>");
            out.println("Servlet Name : " + servletName +
                    "</br></br>");
            out.println("异常类型 : " +
                    throwable.getClass( ).getName( ) +
                    "</br></br>");
            out.println("异常信息: " +
                    throwable.getMessage( ));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
