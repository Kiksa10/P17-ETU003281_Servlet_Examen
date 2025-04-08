package main.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import models.DashBoardModel;


public class DashBoardServlet extends HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    DashBoardModel dashboard = new DashBoardModel();
                    List<DashBoardModel> dashboards = dashboard.getAll();
                    request.setAttribute("listes", dashboards);;
                    RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                    dispatcher.forward(request, response);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "Erreur lors de la récupération des départements.");
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                }
        
    }
}
