package servlets;

import templates.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitaly on 17.07.17.
 */
public class MainpageServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {


        if (!request.getRequestURI().equals("/") && (!request.getPathInfo().endsWith(".html"))) {
            FileSender.sendFile(request, response, request.getPathInfo());
            return;
        }

        response.setContentType("text/html;charset=utf-8");

        String page = "mainpage.html";

        if (!request.getRequestURI().equals("/")) {
            page = request.getPathInfo().substring(1);
        }
        response.getWriter().println(PageGenerator.instance().getPage(page, null));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost (HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

    }
}
