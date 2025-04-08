package main.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.CreditModel;


public class GestionCreditServlet extends HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    CreditModel credit = new CreditModel();
                    List<CreditModel> credits = credit.getAll();
                    request.setAttribute("credits", credits);;
                    RequestDispatcher dispatcher = request.getRequestDispatcher("depense.jsp");
                    dispatcher.forward(request, response);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "Erreur lors de la récupération des départements.");
                    request.getRequestDispatcher("depense.jsp").forward(request, response);
                }
        
    }
}
