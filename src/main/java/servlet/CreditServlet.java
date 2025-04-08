package main.java.servlet;
import models.CreditModel;
import utils.DbConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class CreditServlet extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String libeller = request.getParameter("libeller");
        String montant = request.getParameter("montant");

        if (libeller != null && !libeller.trim().isEmpty() && montant != null && !montant.trim().isEmpty()) {
            CreditModel credit = new CreditModel(libeller,montant);
            try {
                credit.save();        
                request.setAttribute("message", "credit ajouter");
                request.getRequestDispatcher("credit.jsp").forward(request, response);
                
                // Redirect or forward to a success page
                
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                request.setAttribute("message", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Le champ est incomplete !");
            request.getRequestDispatcher("credit.jsp").forward(request, response);
        }
    }
}
