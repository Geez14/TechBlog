package com.geez14.techblogs.servlets;

import com.geez14.techblogs.entities.utility.Message;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("userSession") != null) {
            request.getSession().invalidate();
            // invalidate session and remove browser cache
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            Message m = new Message("Logout Successful", "info", "alert alert-success");
            request.getSession().setAttribute("msg", m);
            response.sendRedirect("/login.jsp");
        }
    }
}
