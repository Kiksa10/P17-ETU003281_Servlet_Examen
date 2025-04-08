package main.java.servlet;
import models.DepenseModel;
import utils.DbConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DepenseServlet extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCred = request.getParameter("idCred");
        String montant = request.getParameter("montant");
        String dates = request.getParameter("dates");


        if (idCred != null && !idCred.trim().isEmpty() && montant != null && !montant.trim().isEmpty() && dates != null && !dates.trim().isEmpty()) {
            DepenseModel dep = new DepenseModel(idCred,montant,dates);
            try {
                dep.save();        
                request.setAttribute("message", "depense ajouter");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                
                // Redirect or forward to a success page
                
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                request.setAttribute("message", e);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Le champ est incomplete !");
            request.getRequestDispatcher("depense.jsp").forward(request, response);
        }
    }
}
