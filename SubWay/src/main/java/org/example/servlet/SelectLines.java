package org.example.servlet;

import org.example.dao.SubWay;
import org.example.service.SubWayService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectLines extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubWay service=new SubWayService();
        List<String> list=service.lines(req.getParameter("stationname"));
        req.setAttribute("lines",list);
        req.getRequestDispatcher("/resline").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
