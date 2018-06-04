package com.bzk;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

/**
 *  1.HelloWorld程序
 *  2.处理get请求
 *      处理单个数据
 *      处理表单数据
 *      处理请求头
 *  3.处理Post请求
 */


@WebServlet("/HelloWorld")
public class HelloWorld extends  HttpServlet{

    private String message;

    @Override
    public void init() throws SecurityException
    {
        message = "Hello 123";
    }


    // 1.HelloWorld程序
//    @Override
//    public void doGet(HttpServletRequest re.quest, HttpServletResponse response)
//            throws SecurityException, IOException
//    {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<h1>" + message + "</h1>");
//    }

    // 2.处理Get请求
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException
    {
        // 2.1 处理Get请求参数
//        String name = request.getParameter("name");

        // 创建返回内容
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//        out.println("<h1>"+ name + "</h1>");

        // 2.2处理Get的form表单
        // 设置服务器端将网页数据bytes转为字符 解码的方式用utf-8
        request.setCharacterEncoding("utf-8");

        String user = request.getParameter("user");
        String passwd = new String(request.getParameter("passwd"));
        System.out.println(user);

        // 设置服务器端将字符转换为bytes编码的方式用utf-8
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h1>"+ user + "</h1> <br> <h1>" + passwd + "</h1>");

        // 2.3 处理请求头
//        String method = request.getMethod();
//        String characterset =  request.getCharacterEncoding();
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//        out.println("<h1>"+ method + "</h1> <br> <h1>" + characterset + "</h1>");

    }

    // 3.处理Post请求
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException {
        doGet(request,response);
    }

    @Override
    public void destroy()
    {}
}