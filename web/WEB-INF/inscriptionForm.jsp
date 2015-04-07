<%-- 
    Document   : inscriptionForm
    Created on : 6 avr. 2015, 14:13:46
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>S'inscrire sur Airblio</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" />
                <br />

                <label for="prenom">Prénom </label>
                <input type="text" id="prenom" name="prenom" value="" />
                <br />

                <label for="email">Email </label>
                <input type="email" id="email" name="email" value="" />
                <br />

                <label for="password">Mot de passe </label>
                <input type="password" id="password" name="password" value="" />
                <br />
                
                <label for="confirmation">Confirmation du mot de passe </label>
                <input type="password" id="confirmation" name="confirmation" value="" />
                <br />

                <input type="submit" value="S'inscrire" />
                <br />
            </fieldset>
        </form>
    </body>
</html>