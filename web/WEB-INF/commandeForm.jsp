<%-- 
    Document   : commandeForm
    Created on : 4 avr. 2015, 21:45:08
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter une commande</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post">
            <fieldset>
                <legend>Ajout d'une commande</legend>

                <label for="lieu">Lieu </label>
                <input type="text" id="lieu" name="lieu" value="" />
                <br />
                
                <label for="denomination">Dénomination du site </label>
                <input type="text" id="denomination" name="denomination" value="" />
                <br />

                <label for="profondeur">Profondeur </label>
                <input type="number" id="profondeur" name="profondeur" value="" />
                <br />
                
                <label for="conditions_particulieres">Conditions particulières </label>
                <input type="text" id="conditions_particulieres" name="conditions_particulieres" value="" />
                <br />
                
                <label for="latitude">Latitude </label>
                <input type="number" id="latitude" name="latitude" value="" />
                <br />
                
                <label for="longitude">Longitude </label>
                <input type="number" id="longitude" name="longitude" value="" />
                <br />
                
                <label for="debut">Date de début </label>
                <input type="date" id="debut" name="debut" value="" />
                <br />
                
                <label for="fin">Date de fin </label>
                <input type="date" id="fin" name="fin" value="" />
                <br />
                
                <label for="client">Client </label>
                <input type="number" id="client" name="client" value="" />
                <br />
                
                <label for="statut">Statut de la commande </label>
                <input type="number" id="statut" name="statut" value="" />
                <br />
                
                <label for="equipe">Equipe technique </label>
                <input type="number" id="equipe" name="equipe" value="" />
                <br />

                <label for="materiel1">Matériel 1 </label>
                <input type="number" id="materiel1" name="materiel1" value="" />
                <br />

                <label for="materiel2">Matériel 2 </label>
                <input type="number" id="materiel2" name="materiel2" value="" />
                <br />
                
                <label for="materiel3">Matériel 3 </label>
                <input type="number" id="materiel3" name="materiel3" value="" />
                <br />

                <label for="materiel4">Matériel 4 </label>
                <input type="number" id="materiel4" name="materiel4" value="" />
                <br />

                <label for="materiel5">Matériel 5 </label>
                <input type="number" id="materiel5" name="materiel5" value="" />
                <br />
                
                <label for="materiel6">Matériel 6 </label>
                <input type="number" id="materiel6" name="materiel6" value="" />
                <br />
                
                <label for="materiel7">Matériel 7 </label>
                <input type="number" id="materiel7" name="materiel7" value="" />
                <br />
                
                <label for="materiel8">Matériel 8 </label>
                <input type="number" id="materiel8" name="materiel8" value="" />
                <br />

                <input type="submit" value="Ajouter" />
                <br />
            </fieldset>
        </form>
    </body>
</html>
