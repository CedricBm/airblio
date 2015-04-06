<%-- 
    Document   : accueil
    Created on : 25 févr. 2015, 18:46:17
    Author     : CedricBm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <h1>Airblio</h1>
        <form method="post">
            <fieldset>
                <legend>Connectez-vous</legend>

                <label for="email">Email </label>
                <input type="email" id="email" name="email" value="" />
                <br />
                
                <label for="password">Mot de passe </label>
                <input type="password" id="password" name="password" value="" />
                <br />


                <input type="submit" value="Connection" />
                <br />
            </fieldset>
        </form>
    </body>
</html>
