package com.achacker.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置浏览器3秒自动刷新
        resp.setHeader("refresh", "3");

        // create a image in memory
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);

        // get image
        Graphics2D g = (Graphics2D) image.getGraphics();

        // set img background color
        g.setColor(Color.white);
        g.fillRect(0, 0, 80, 20);

        // write data to img
        g.setColor(Color.blue);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        // 告诉浏览器，这个请求用图片方式打开
        resp.setContentType("image/png");

        // 网站存在缓存，需要清除
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        // 写图片给浏览器
        ImageIO.write(image,"png",resp.getOutputStream());
    }

    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            sb.append(0);
        }
        num = sb.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
