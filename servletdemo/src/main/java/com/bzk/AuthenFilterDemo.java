package com.bzk;
import javax.servlet.*;
import java.io.PrintWriter;


public class AuthenFilterDemo implements Filter{

    // 初始化工作
    @Override
    public void init(FilterConfig config) throws ServletException{
        String config_value = config.getInitParameter("param");
        System.out.println(config_value);
    }

    // 过滤工作
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException{

        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        System.out.println("过滤器获取到的用户名是: "+ user);
        System.out.println("过滤器获取到的密码是: "+ passwd);

        if("xiaobao".equals(user))
        {
            chain.doFilter(request, response);
        }else{
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<b>用户名不正确，登陆无效<b>");
        }
    }

    // 在Filter实例被移除服务器之前调用
    @Override
    public void destroy(){
    }
}
