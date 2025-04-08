<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.DashBoardModel" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Listes</title>
    <style>
        .container { 
            width: 80%; 
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

        table {
            width: 700px;
            height: auto;
            background-color: #dedddd;
            border: 1px solid black;

        }
        th,tr,td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>DashBoard</h1>
        <% if(request.getAttribute("message") != null) { %>
            <div class="header-message">
                <p>${message}</p>
            </div>
        <% } %>
        <table>
            <th>Credit</th>
            <th>Montant</th>
            <th>Depense effectuer</th>
            <th>Reste</th>
            <th>Date</th>
            

            <% List<DashBoardModel> listes = (List<DashBoardModel>) request.getAttribute("listes");
                if (listes != null) {
                    for (DashBoardModel liste : listes) { %>
                        <tr>
                            <td><%= liste.getNomCredit() %></td>
                            <td><%= liste.getCredit() %></td>
                            <td><%= liste.getDepense() %></td>
                            <td><%= liste.getReste() %></td>
                            <td><%= liste.getDate() %></td>

                        </tr>
                        
             <%     } 
                } else { %>
                    <h2 >Aucun liste disponible</h2>
             <% } %>
            
        </table>
                  
 
    </div>
    <a href="insertCred" class="back-link">Inserer une Credit</a>
</body>
</html>
