package com.web;

import com.bean.User;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;
import com.utils.RandomValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、核对验证码
//        获取用户在输入框中输入的验证码
        String code1 = req.getParameter("code1");
        //获取session中存入的真实的验证码
        String code2 = (String) req.getSession().getAttribute(RandomValidateCode.RANDOMCODEKEY);
        if(!code1.equalsIgnoreCase(code2)){
            //重定向登录页面
             req.setAttribute("msg","验证码输入错误");
             req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        //2、核对用户名和密码
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        User user = service.login(name,pwd);
        System.out.println(user);
        if(user != null){
            //跳转成功页面
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/vetsearch.jsp").forward(req,resp);
//            resp.sendRedirect("/vetsearch.jsp");

        }else {
            //跳转登录页面
//            resp.sendRedirect("/index.jsp");
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
