package com.web;

import com.bean.Vet;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vetServlet")
public class VetServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String vName = req.getParameter("vName");
        String sName = req.getParameter("sName");
        String m = req.getParameter("m");
        if("search".equals(m)){
            Vet vet = new Vet();
            //查询医生
            List<Vet> list = service.searchVet(vName, sName);
            if(list.size()!=0){
                System.out.println(list);
                req.getSession().setAttribute("list",list);
                req.getRequestDispatcher("/vetsearch_result.jsp").forward(req,resp);
            }else{
                req.setAttribute("flag","没有找到相关医生信息");
                req.getRequestDispatcher("/vetsearch.jsp").forward(req,resp);
            }
        }

    }
}
