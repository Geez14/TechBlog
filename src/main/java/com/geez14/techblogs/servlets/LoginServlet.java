package com.geez14.techblogs.servlets;

import com.geez14.techblogs.dao.UserDao;
import com.geez14.techblogs.entities.User;
import com.geez14.techblogs.entities.utility.Message;
import com.geez14.techblogs.util.ConnectionProvider;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@MultipartConfig
@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Message m = new Message("","info", "alert alert-danger");
        request.getSession().setAttribute("msg", m);
        // null check
        if (email == null || password == null) {
            m.setContent("Malformed form parameters");
            response.sendRedirect("/login.jsp");
            return;
        }

        // value check
        if (email.isBlank() || password.isBlank()) {
            m.setContent("Cannot leave email or password empty");
            response.sendRedirect("/login.jsp");
            return;
        }

        // check for data length
        if (email.length() > 128 || password.length() > 64) {
            m.setContent("Data is too large to process");
            response.sendRedirect("/login.jsp");
            return;
        }

        // check password length
        if (password.length() < 8) {
            m.setContent("password must be at least 8 characters");
            response.sendRedirect("/login.jsp");
            return;
        }

        User user = new UserDao(ConnectionProvider.getConnection()).verifyByEmailAndPassword(email, password);
        if (user == null) {
            m.setContent("Incorrect email or password");
            response.sendRedirect("/login.jsp");
            return;
        }
        m.setContent("Successfully logged in");
        m.setCssClass("alert alert-success");
        request.getSession().setAttribute("userSession", user);
        // ('on' | null)
        String check = request.getParameter("check");
        if (check != null) {
            // 2 days session expire time
            int time = 2*24*60*60;
            request.getSession().setMaxInactiveInterval(time);
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
