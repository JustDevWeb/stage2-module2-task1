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

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/add.jsp");
        try {
            dispatcher.forward(req , resp);
        } catch (IOException e) {
            req.setAttribute("Error" , e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String firstName = req.getParameter("firstName");
       String lastName = req.getParameter("lastName");

       if( ( firstName != null && lastName != null ) && ( !firstName.isEmpty() && !lastName.isEmpty() ) ) {
           User user = new User( firstName , lastName );
           Warehouse warehouse = Warehouse.getInstance();
           warehouse.addUser( user );

           req.setAttribute("user" , user);

           RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/add.jsp");

           try {
               dispatcher.forward(req , resp);
           } catch (IOException e) {
                req.setAttribute("Error" , e.getMessage());
           }

        }
    }
}
