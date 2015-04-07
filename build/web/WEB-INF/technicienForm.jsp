<%-- 
    Document   : technicienForm
    Created on : 2 avr. 2015, 18:15:00
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un technicien</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post">
            <fieldset>
                <legend>Ajout d'un technicien</legend>

                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" />
                <br />
                
                <label for="prenom">Prénom </label>
                <input type="text" id="prenom" name="prenom" value="" />
                <br />

                <label for="telephone">Téléphone </label>
                <input type="text" id="telephone" name="telephone" value="" />
                <br />

                <label for="adresse">Adresse </label>
                <input type="text" id="adresse" name="adresse" value="" />
                <br />

                <label for="email">Adresse email </label>
                <input type="email" id="email" name="email" value="" />
                <br />

                <label for="prix_par_heure">Prix par heure </label>
                <input type="number" id="prix_par_heure" name="prix_par_heure" value="" />
                <br />

                <label for="poste">Poste </label>
                <input type="text" id="poste" name="poste" value="" />
                <br />

                <input type="submit" value="Ajouter" />
                <br />
            </fieldset>
        </form>
    </body>
</html>