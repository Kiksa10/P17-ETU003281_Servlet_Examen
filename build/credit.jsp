<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajout de credit</title>
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
        <h1>Ajouter votre credit</h1>
        <% if(request.getAttribute("message") != null) { %>
            <div class="header-message">
                <p>${message}</p>
            </div>
        <% } %>
        <form action="credit" method="POST">
            <div class="form-group">
                <label for="libeller">libeller</label>
                <input type="text" id="libeller" name="libeller" required 
                       maxlength="50" placeholder="ex: Frais bus ">
                <label for="montant">Montant</label>
                <input type="number" id="montant" name="montant" required 
                              maxlength="50" placeholder="600">
            </div>
            <button type="submit" class="submit-btn">Inserer</button>
        </form>
    </div>
    <a href="gestionCredit" class="back-link">Ajouter une depense</a>
</body>
</html>
