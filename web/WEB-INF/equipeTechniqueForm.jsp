<%-- 
    Document   : equipeTechniqueForm
    Created on : 2 avr. 2015, 18:50:04
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter une équipe</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post">
            <fieldset>
                <legend>Ajout d'une équipe</legend>

                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" />
                <br />
                
                <label for="latitude">Latitude </label>
                <input type="number" id="latitude" name="latitude" value="" />
                <br />

                <label for="longitude">Longitude </label>
                <input type="number" id="longitude" name="longitude" value="" />
                <br />

                <label for="technicien1">Technicien 1 </label>
                <input type="number" id="technicien1" name="technicien1" value="" />
                <br />

                <label for="technicien2">Technicien 2 </label>
                <input type="number" id="technicien2" name="technicien2" value="" />
                <br />
                
                <label for="technicien3">Technicien 3 </label>
                <input type="number" id="technicien3" name="technicien3" value="" />
                <br />

                <label for="technicien4">Technicien 4 </label>
                <input type="number" id="technicien4" name="technicien4" value="" />
                <br />

                <label for="technicien5">Technicien 5 </label>
                <input type="number" id="technicien5" name="technicien5" value="" />
                <br />

                <input type="submit" value="Ajouter" />
                <br />
            </fieldset>
        </form>
    </body>
</html>
