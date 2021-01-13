package com.achacker.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 设置servlet的attribute
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

//        this.getInitParameter();
//        this.getServletConfig();
//        this.getServletContext();
        ServletContext context = this.getServletContext();

        String username = "Kingfish404";    // 数据

        // 将一个数据保存在了ServletContext中。名字为：username，值：username
        context.setAttribute("username",username);

        System.out.println("Hello");
    }
}
