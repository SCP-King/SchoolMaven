package org.example.servlet;

import org.example.dao.SubWay;
import org.example.pojo.Station;
import org.example.service.SubWayService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectShortLine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubWay subWay=new SubWayService();
        String start=req.getParameter("start");
        String end=req.getParameter("end");
       List<Station> stations=subWay.getShortLine(start,end);
       req.setAttribute("stations",stations);
       req.getRequestDispatcher("/resshort").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
