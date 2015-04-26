<%-- 
    Document   : accueil
    Created on : 25 févr. 2015, 18:46:17
    Author     : CedricBm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil Airblio</title>
        <link rel="stylesheet" href="/airblio/css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="/airblio/css/accueil.css" type="text/css" />
    </head>
    <body>
        <h1>Airblio</h1>
        <c:out value="${erreur}" /><br/>
        <form method="post">
            <fieldset>
                <div id="inputlabel">
                    <label for="email">Email </label>
                    <input type="email" id="email" name="email" value="" />
                    <br />

                    <label for="password">Mot de passe </label>
                    <input type="password" id="password" name="password" value="" />
                    <br />

                    <input id="bouton" type="submit" value="Connection" />
                    <br />
                </div>
            </fieldset>
        </form>
    </body>
</html>
