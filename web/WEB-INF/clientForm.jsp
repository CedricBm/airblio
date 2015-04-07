<%-- 
    Document   : clientForm
    Created on : 2 avr. 2015, 17:37:50
    Author     : Superced
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un client</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post">
            <fieldset>
                <legend>Ajout d'un client</legend>

                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" />
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

                <label for="reference">Référence </label>
                <input type="text" id="reference" name="reference" value="" />
                <br />

                <label for="iban">Iban </label>
                <input type="text" id="iban" name="iban" value="" />
                <br />

                <label for="bic">Bic </label>
                <input type="text" id="bic" name="bic" value="" />
                <br />

                <input type="submit" value="Ajouter" />
                <br />
            </fieldset>
        </form>
    </body>
</html>