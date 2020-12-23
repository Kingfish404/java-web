package com.achacker.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.Get file path
        String realPath = this.getServletContext().getRealPath("WEB-INF/classes/textfile.txt");
        System.out.println("Download file path:" + realPath);

        // 2.Get file name
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);

        // 3.Set header to make browser support to download file
        resp.setHeader("Content-Disposition", "attachment;filename=" +
                URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        // 4.Get file input stream
        FileInputStream in = new FileInputStream(realPath);

        // 5. create buffer
        int len = 0;
        byte[] buffer = new byte[1024];

        // 6.get OutputStream Object
        ServletOutputStream out = resp.getOutputStream();

        // 7.Read from fileOutputStream to buffer,then to OutputStream and to Client
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
