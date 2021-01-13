package com.achacker.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    // 初始化:web服务器启动，就已经初始化，等待过滤对象出现
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter - init");
    }

    // Chain：链
    /*
    1. 过滤器中的所有代码，在过滤特定请求时候都会执行
    2. 必须让过滤器继续执行
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // fix code mess
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        System.out.println("CharacterEncodingFilter - before running");
        chain.doFilter(request, response);  // 让我们的请求继续走，如果不写，程序就会在这里被拦截
        System.out.println("CharacterEncodingFilter - after running");
    }

    // 销毁:web服务器关闭时，过滤器会销毁
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter - destroy");
    }
}
