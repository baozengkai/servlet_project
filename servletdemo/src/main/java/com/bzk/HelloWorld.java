package com.bzk;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 *  1.HelloWorld程序
 *  2.处理get请求
 *      处理单个数据
 *      处理表单数据
 *      处理请求头
 *      处理响应头
 *  3.处理Post请求
 *  4.编写过滤器
 *  5.处理Cookie
 *      设置Cookie信息
 *  6.处理Session
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
//        request.setCharacterEncoding("utf-8");
//
//        String user = request.getParameter("user");
//        String passwd = new String(request.getParameter("passwd"));
//
//        // 设置服务器端将字符转换为bytes编码的方式用utf-8
//        response.setCharacterEncoding("utf-8");
//
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//        out.println("<h1>"+ user + "</h1> <br> <h1>" + passwd + "</h1>");
        // 2.3 处理请求头
//        String method = request.getMethod();
//        String characterset =  request.getCharacterEncoding();
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//        out.println("<h1>"+ method + "</h1> <br> <h1>" + characterset + "</h1>");
        // 2.4 处理响应头
        // 设置自动刷新加载为5秒
//        response.setIntHeader("Refresh",5);
        // 设置客户端接收数据类型和编码格式
//        response.setContentType("text/html;charset=UTF-8");
//
//        Calendar cale = Calendar.getInstance();
//        Date taskTime = cale.getTime();
//        String nowTime = taskTime.toString();
//
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//        out.println("<h1> 现在时间是: </h1> <br> <h1>" + nowTime + "</h1>");
        // 3.1 设置Cookie
        setCookie(request, response);
    }

    // 3.处理Post请求
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException {
        doGet(request,response);
    }

    // 4.处理Cookie
    public void setCookie(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{

        // 获取当Cookie原料的参数
        Cookie user = new Cookie("user",request.getParameter("user"));
        Cookie passwd = new Cookie("passwd", request.getParameter("passwd"));

        // 设置Cookie的保质期(设置为24小时)
        user.setMaxAge(60*60*24);
        passwd.setMaxAge(60*60*24);

        //在响应头中添加这两个Cookie
        response.addCookie(user);
        response.addCookie(passwd);


        //设置输出
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h1> 设置的Cookie实例为: <h1/>");
        out.println("<h2>"+request.getParameter("user")+"</h2>");
        out.println("<h2>"+request.getParameter("passwd")+"</h2>");
    }

    // 5.处理Session
    public void setSession(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{
        HttpSession session = request.getSession();

    }
    @Override
    public void destroy()
    {}
}
