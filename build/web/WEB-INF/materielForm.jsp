<%-- 
    Document   : materielForm
    Created on : 4 avr. 2015, 16:47:52
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un matériel</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post">
            <fieldset>
                <legend>Ajout d'un matériel</legend>

                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" />
                <br />

                <label for="description">Description </label>
                <input type="text" id="description" name="description" value="" />
                <br />

                <label for="cout_location">Cout de location </label>
                <input type="number" id="cout_location" name="cout_location" value="" />
                <br />

                <label for="cout_expedition">Cout d'expédition </label>
                <input type="number" id="cout_expedition" name="cout_expedition" value="" />
                <br />
                
                <label for="site_stockage">Site de stockage </label>
                <input type="number" id="site_stockage" name="site_stockage" value="" />
                <br />

                <input type="submit" value="Ajouter" />
                <br />
            </fieldset>
        </form>
    </body>
</html>