<%-- 
    Document   : CommandeStatutForm
    Created on : 4 avr. 2015, 17:10:35
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un statut de commande</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post">
            <fieldset>
                <legend>Ajout d'un statut de commande</legend>

                <label for="statut">Nom </label>
                <input type="text" id="statut" name="statut" value="" />
                <br />

                <input type="submit" value="Ajouter" />
                <br />
            </fieldset>
        </form>
    </body>
</html>