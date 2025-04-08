<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion d'argent</title>
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
        <h1>Login</h1>
        <% if(request.getAttribute("message") != null) { %>
            <div class="header-message">
                <p>${message}</p>
            </div>
        <% } %>
        <form action="login" method="POST">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="mail" id="email" name="email" required 
                       maxlength="50" placeholder="ex: fitia@gmail.com" value="fitia@gmail.com">
                <label for="pwd">PassWord</label>
                <input type="password" id="pwd" name="pwd" required 
                              maxlength="50" placeholder="*********" value="12345">
            </div>
            <button type="submit" class="submit-btn">Login</button>
        </form>
    </div>
    
</body>
</html>
