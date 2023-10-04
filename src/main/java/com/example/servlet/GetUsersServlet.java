package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet ("/users")
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = Warehouse.getInstance();
        Set<User> users = warehouse.getUsers();

        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/users.jsp");
        dispatcher.include( req , resp );
    }
}
