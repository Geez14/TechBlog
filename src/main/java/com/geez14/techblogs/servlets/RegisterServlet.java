package com.geez14.techblogs.servlets;

import java.io.*;
import java.util.*;

import com.geez14.techblogs.entities.About;
import com.geez14.techblogs.entities.Detail;
import com.geez14.techblogs.entities.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class RegisterServlet extends HttpServlet {

    static Random code = new Random();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String about = request.getParameter("about");
        String check = request.getParameter("check");

        String username = "@".concat(firstName).concat("_").concat(lastName).concat(Integer.toString(code.nextInt(Integer.MAX_VALUE)));

        User u = new User(username, email, password);
        About a = new About(about);
        Detail d = new Detail(firstName, lastName, gender, phone);

        response.getWriter().println(u);
        response.getWriter().println("<br>");
        response.getWriter().println(a);
        response.getWriter().println("<br>");
        response.getWriter().println(d);
    }

    public void destroy() {
        Runtime.getRuntime().gc();
    }
}