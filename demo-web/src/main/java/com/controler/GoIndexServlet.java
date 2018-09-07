package com.controler;

import com.entity.Dept;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.service.Deptservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/index")
public class GoIndexServlet extends HttpServlet {
    private final int PAGE_SIZE = 2 ;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Deptservice deptservice =  new Deptservice();
        List<Dept> deptList = deptservice.getAll(verifyPageNum(req),PAGE_SIZE);
        Page<Dept> page = (Page<Dept>) deptList;
        PageInfo<Dept> pageInfo = new PageInfo<>(page.getResult(),3);
        req.setAttribute("deptList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("WEB-INF/index.jsp").forward(req,resp);
    }

    private int verifyPageNum(HttpServletRequest request){
        int pageNum = 1 ;
        try {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }finally {
            return pageNum;
        }

    }
}
