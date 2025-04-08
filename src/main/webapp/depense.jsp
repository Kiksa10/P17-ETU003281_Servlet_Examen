<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.CreditModel" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des depenses</title>
    <style>
        .container { 
            width: 50%; 
            margin: 20px auto; 
            padding: 20px; 
            box-shadow: 0 0 10px rgba(0,0,0,0.1); 
        }
        .form-group { 
            margin-bottom: 15px; 
        }
        .form-group label { 
            display: block; 
            margin-bottom: 5px; 
        }
        .form-group input { 
            width: 100%; 
            padding: 8px; 
            border: 1px solid #ddd; 
        }
        .submit-btn { 
            background-color: #4CAF50; 
            color: white; 
            padding: 10px 15px; 
            border: none; 
            cursor: pointer; 
        }
        .submit-btn:hover { 
            background-color: #45a049; 
        }
        .header-message {
            background-color: #e3f2fd;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 4px;
            border-left: 5px solid #2196f3;
            color: #0d47a1;
        }
        .header-message h2 {
            margin: 0;
            font-size: 1.2em;
        }
        .header-message p {
            margin: 5px 0 0 0;
            font-size: 0.9em;
        }
        .message {
            margin: 20px auto;
            padding: 20px;
            max-width: 500px;
            background-color: #dff0d8;
            border: 1px solid #d6e9c6;
            border-radius: 4px;
            color: #3c763d;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Ajout depense</h1>
        <% if(request.getAttribute("message") != null) { %>
            <div class="header-message">
                <p>${message}</p>
            </div>
        <% } %>
        <form action="insertDep" method="POST">
            <div class="form-group">
                <label for="cred">Credit :</label>
                <select name="idCred" id="cred" selected="Credit : Frais">
                    <% List<CreditModel> credits = (List<CreditModel>) request.getAttribute("credits");
                        if (credits != null) {
                            for (CreditModel cred : credits) { %>
                                <option value="<%= cred.getId() %>"><%= cred.getLibller() %></option>
                     <%     } 
                        } else { %>
                            <option value="">Aucun Credit disponible</option>
                     <% } %>

                </select>
                <label for="montant">Montant :</label>
                <input type="number" id="montant" name="montant" required 
                        placeholder="ex: 1000">

                <label for="dates">Date :</label>
                <input type="date" id="dates" name="dates" required 
                        >
            </div>
            <button type="submit" class="submit-btn">Ajoute le depense</button>
        </form>
    </div>
    <a href="dashboard" class="back-link">DashBoard</a>
</body>
</html>
