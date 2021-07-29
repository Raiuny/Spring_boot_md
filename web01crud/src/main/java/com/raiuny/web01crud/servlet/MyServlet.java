package com.raiuny.web01crud.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/my") //效果：直接相应，没有经过Spring的拦截器
//拦截器只适用于Spring框架，原生Servlet需要通过过滤器拦截
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().write("<h1>78967293748</h1>");
    }
}
