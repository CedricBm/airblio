<%-- 
    Document   : siteStockageForm
    Created on : 4 avr. 2015, 17:01:31
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un site de stockage</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post">
            <fieldset>
                <legend>Ajout d'un site de stockage</legend>

                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" />
                <br />

                <label for="adresse">Adresse </label>
                <input type="text" id="adresse" name="adresse" value="" />
                <br />
                
                <label for="latitude">Latitude </label>
                <input type="number" id="latitude" name="latitude" value="" />
                <br />

                <label for="longitude">Longitude </label>
                <input type="number" id="longitude" name="longitude" value="" />
                <br />
                
                <input type="submit" value="Ajouter" />
                <br />
            </fieldset>
        </form>
    </body>
</html>