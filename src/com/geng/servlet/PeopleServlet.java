package com.geng.servlet;

import com.geng.pojo.People;
import com.geng.service.PeopleService;
import com.geng.service.impl.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 控制层 PeopleServlet
 */
@WebServlet(value = {"/show"})
public class PeopleServlet extends HttpServlet {

    private PeopleService peopleService = new PeopleServiceImpl();

    /**
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<People> peopleList = peopleService.showAll();
        req.setAttribute("peopleList", peopleList);
        req.getRequestDispatcher("/index.jsp").forward(req, res);
    }
}
