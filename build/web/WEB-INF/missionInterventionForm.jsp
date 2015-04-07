<%-- 
    Document   : missionInterventionForm
    Created on : 5 avr. 2015, 15:36:52
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter une mission d'interventoin</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post">
            <fieldset>
                <legend>Ajout d'une mission d'intervention</legend>

                <label for="commande">Commande </label>
                <input type="number" id="commande" name="commande" value="" />
                <br />

                <label for="intitule">Intitulé de l'intervention </label>
                <input type="text" id="intitule" name="intitule" value="" />
                <br />

                <label for="volume">Volume horaire total </label>
                <input type="number" id="volume" name="volume" value="" />
                <br />

                <label for="prix">Prix total TTC </label>
                <input type="number" id="prix" name="prix" value="" />
                <br />

                <label for="tva">TVA </label>
                <input type="number" id="tva" name="tva" value="" />
                <br />

                <label for="detail">Détail </label>
                <input type="text" id="detail" name="detail" value="" />
                <br />

                <label for="lieu_depart">Lieu de départ de l'équipe </label>
                <input type="text" id="lieu_depart" name="lieu_depart" value="" />
                <br />

                <label for="procedure">Procédure de la mission </label>
                <input type="text" id="procedure" name="procedure" value="" />
                <br />

                <label for="nb_heure">Nombre d'heure de travail de l'équipe </label>
                <input type="number" id="nb_heure" name="nb_heure" value="" />
                <br />

                <label for="nb_jour">Nombre de jour de location du matériel </label>
                <input type="number" id="nb_jour" name="nb_jour" value="" />
                <br />

                <input type="submit" value="Ajouter" />
                <br />
            </fieldset>
        </form>
    </body>
</html>