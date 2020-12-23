package com.achacker.servlet;


import com.achacker.pojo.Persion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // fix code mess
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        // get session
        HttpSession session = req.getSession();
        // Store to session
        session.setAttribute("name",new Persion("Kingfish404","20"));

        // Get session ID
        String sessionId = session.getId();

        if(session.isNew())
        {
            resp.getWriter().write("Session create successs,ID:"+sessionId);
        }else{
            resp.getWriter().write("Session already exists on server,ID:"+sessionId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
