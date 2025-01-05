package com.geez14.techblogs.servlets;

import com.geez14.techblogs.entities.User;
import jakarta.servlet.ServletException;
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
        // ('on' | null)
        String check = request.getParameter("check");
        if (check != null) {
            // 2 days session expire time
            int time = 2*24*60*60;
            request.getSession().setMaxInactiveInterval(time);
        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // null check
        if (email == null || password == null) {
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            out.println("Malformed form parameters");
            return;
        }

        // value check
        if (email.isBlank() || password.isBlank()) {
            response.setStatus(HttpServletResponse.SC_UNPROCESSABLE_CONTENT);
            out.println("Cannot leave email or password empty");
            return;
        }

        // check for data length
        if (email.length() > 128 || password.length() > 64) {
            response.setStatus(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
            out.println("Data is too large to process");
            return;
        }

        // check password length
        if (password.length() < 8) {
            response.setStatus(HttpServletResponse.SC_UNPROCESSABLE_CONTENT);
            out.println("password must be at least 8 characters");
            return;
        }

        out.println("Logged in");
        out.println("<br>");
        out.println("Email: " + email);
        out.println("Password: " + password);
    }
}
