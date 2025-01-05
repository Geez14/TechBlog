package com.geez14.techblogs.servlets;

import java.io.*;
import java.util.*;

import com.geez14.techblogs.dao.AboutDao;
import com.geez14.techblogs.dao.DetailDao;
import com.geez14.techblogs.dao.UserDao;
import com.geez14.techblogs.entities.About;
import com.geez14.techblogs.entities.Detail;
import com.geez14.techblogs.entities.User;
import com.geez14.techblogs.util.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RegisterServlet", value = "/signup")
public class RegisterServlet extends HttpServlet {

    static Random code = new Random();

//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String check = request.getParameter("check");
        if (check == null) {
            out.println("we cannot proceed without agreeing on my terms and condition");
            return;
        }
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String about = request.getParameter("about");

        // check for important fields
        if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || password.isBlank() || gender.isBlank()) {
            out.println("Some field are blank, fill them before proceeding");
            return;
        }
        // check for bad fields
        if (firstName.length() > 32 || lastName.length() > 32 || email.length() > 32 || password.length() > 32) {
            out.println("Some field are too large to fit");
            return;
        }
        if (password.length() < 8) {
            out.println("password must be at least 8 characters");
            return;
        }
        if (!(gender.equals("male") || gender.equals("female"))) {
            out.println("Gender must be either male or female");
            return;
        }

        // creating user_name
        String username = "@".concat("User").concat(Integer.toString(email.hashCode())).concat(Integer.toString(code.nextInt(99999)));

        // Save User
        User userInstance = new User(username, email, password);
        UserDao userDao = new UserDao(ConnectionProvider.getConnection());
        if (!userDao.save(userInstance)) {
            out.println("email or username already exists");
            return;
        }

        // Save bio
        About aboutInstance = new About(userInstance.getId(), about);
        AboutDao aboutDao = new AboutDao(ConnectionProvider.getConnection());
        if (!aboutDao.save(aboutInstance)) {
            throw new RuntimeException("User with id = %d doesn't exist".formatted(aboutInstance.getId()));
        }

        // Save extra detail
        Detail detailInstance = new Detail(userInstance.getId(), firstName, lastName, gender, phone);
        DetailDao detailDao = new DetailDao(ConnectionProvider.getConnection());
        if (!detailDao.save(detailInstance)) {
            throw new RuntimeException("User with id = %d doesn't exist".formatted(detailInstance.getId()));
        }


        response.getWriter().println(userInstance);
        response.getWriter().println("<br>");
        response.getWriter().println(aboutInstance);
        response.getWriter().println("<br>");
        response.getWriter().println(detailInstance);
        response.getWriter().println("<br>");
    }

    public void destroy() {
        Runtime.getRuntime().gc();
    }
}