package main.java.servlet;
import models.LoginModel;
import utils.DbConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");

        if (email != null && !email.trim().isEmpty() && pwd != null && !pwd.trim().isEmpty()) {
            LoginModel log = new LoginModel(email,pwd);
            try {
                if(log.verifie()){
                    
                    request.setAttribute("message", "succes login");
                    request.getRequestDispatcher("credit.jsp").forward(request, response);
                }
                // Redirect or forward to a success page
                
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                request.setAttribute("message", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Le champ Nom est obligatoire !");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
