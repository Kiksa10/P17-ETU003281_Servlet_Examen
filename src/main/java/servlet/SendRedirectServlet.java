package main.java.servlet;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;



public class SendRedirectServlet extends HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    response.sendRedirect("credit.jsp");
                } catch ( Exception e) {
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "Erreur lors de la redirection.");
                    request.getRequestDispatcher("depense.jsp").forward(request, response);
                }
        
    }
}
