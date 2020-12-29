package com.achacker.servlet;


import com.achacker.pojo.Persion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get session
        HttpSession session = req.getSession();
        Persion persion = (Persion) session.getAttribute("name");
        if(persion!=null)
        {
            resp.getWriter().write(persion.toString());
            resp.getWriter().write("<h1>No session - 有 session</h1>");
        }else
        {
            resp.getWriter().write("<h1>No session - 无 session</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
