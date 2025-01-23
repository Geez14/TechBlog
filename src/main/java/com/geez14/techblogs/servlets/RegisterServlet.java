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
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@MultipartConfig
@WebServlet(name = "RegisterServlet", value = "/signup")
public class RegisterServlet extends HttpServlet {

    static Random code = new Random();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String check = request.getParameter("check");
        if (check == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
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

        // null check
        if (firstName == null || lastName == null || email == null || phone == null || password == null || gender == null || about == null) {
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            out.println("Malformed form parameters");
            return;
        }

        // check for important fields
        if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || password.isBlank() || gender.isBlank()) {
            response.setStatus(HttpServletResponse.SC_UNPROCESSABLE_CONTENT);
            out.println("Some field are blank, fill them before proceeding");
            return;
        }

        // check for data lengths
        if (firstName.length() > 32 || lastName.length() > 32 || email.length() > 32 || password.length() > 32) {
            response.setStatus(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
            out.println("Some field are too large to fit");
            return;
        }

        // check password length
        if (password.length() < 8) {
            response.setStatus(HttpServletResponse.SC_UNPROCESSABLE_CONTENT);
            out.println("password must be at least 8 characters");
            return;
        }

        // check for correct gender values
        if (!(gender.equals("male") || gender.equals("female"))) {
            response.setStatus(HttpServletResponse.SC_UNPROCESSABLE_CONTENT);
            out.println("Gender must be either male or female");
            return;
        }

        // creating user_name
        String username = "@".concat("User").concat(Long.toString(email.hashCode())).concat(Integer.toString(code.nextInt(99999)));

        // Save User
        User userInstance = new User(username, email, password);
        UserDao userDao = new UserDao(ConnectionProvider.getConnection());
        if (!userDao.save(userInstance)) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            out.println("email or username already exists");
            return;
        }

        // Save bio
        About aboutInstance = new About(userInstance.getId(), null, about.isBlank()?null:about.toLowerCase());
        AboutDao aboutDao = new AboutDao(ConnectionProvider.getConnection());
        if (!aboutDao.save(aboutInstance)) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("Cannot Process data, contact support");
//            throw new RuntimeException("User with id = %d doesn't exist".formatted(aboutInstance.getId()));
        }

        // Save extra detail
        Detail detailInstance = new Detail(userInstance.getId(), firstName, lastName, gender, phone);
        DetailDao detailDao = new DetailDao(ConnectionProvider.getConnection());
        if (!detailDao.save(detailInstance)) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("Cannot Process data, contact support");
//            throw new RuntimeException("User with id = %d doesn't exist".formatted(detailInstance.getId()));
        }
        response.setStatus(HttpServletResponse.SC_CREATED);
        out.println("Successfully registered");
    }

    public void destroy() {
        Runtime.getRuntime().gc();
    }
}