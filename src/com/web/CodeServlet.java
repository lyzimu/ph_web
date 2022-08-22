package com.web;

import com.utils.RandomValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/randomCode")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RandomValidateCode randomValidateCode = new RandomValidateCode();

        randomValidateCode.getRandcode(req,resp);//输出图片的方法
    }
}
