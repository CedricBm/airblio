<%-- 
    Document   : mappemonde
    Created on : Apr 2, 2015, 3:45:54 PM
    Author     : Skulldy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mappemonde</title>
        <link rel="stylesheet" href="/airblio/css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="/airblio/css/styles.css" type="text/css" />
        <link href="<c:url value="/css/mappemonde.css" />" rel="stylesheet">
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1>La mappemonde de Airblio</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <div id="filtre">
                        <input type="text" id="multiple" name="multiple" /> <br />
                        <input type="button" id="multipleButton" name="multiple" value="Chercher" />
                        <select id="selectMultiple">
                            <option value="equipe">une équipe</option>
                            <option value="client">un client</option>
                            <option value="materiel">un matériel</option>
                            <option value="intervention">les interventions depuis</option>
                            <option value="clientPossedant">les clients possédant</option>
                        </select>
                        <h3>Les équipes techniques</h3>
                        <input type="checkbox" class="checky" id="afficheEquipes" name="afficheEquipes"> <label for="afficheEquipes">Toutes les équipes techniques</label> <br />
                        <input type="checkbox" class="checky" id="afficheEquipesIntervention" name="afficheEquipesIntervention"> <label for="afficheEquipesIntervention">Equipes en cours d'intervention</label> <br />
                        <h3>Les clients</h3>
                        <input type="checkbox" class="checky" id="afficheClients" name="afficheClients"> <label for="afficheClients">Afficher clients</label> <br />
                        <input type="checkbox" class="checky" id="afficheClientsIntervention" name="afficheClientsIntervention"> <label for="afficheClientsIntervention">Client ayant des interventions en cours</label> <br />
                        <h3>Le matériel</h3>
                        <input type="checkbox" class="checky" id="afficheMaterielsSite" name="afficheMaterielsSite"> <label for="afficheMaterielsSite">Afficher matériaux dans les sites</label> <br />
                        <input type="checkbox" class="checky" id="afficheMaterielsClients" name="afficheMaterielsClients"> <label for="afficheMaterielsClients">Afficher matériaux chez les clients</label> <br />
                    </div>
                </div>
                <div class="col-md-9">
                    <div id="map-canvas"></div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="/airblio/js/jquery-2.1.3.min.js" ></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>  
        <script type="text/javascript" src="/airblio/js/mappemonde.js"></script>
    </body>


</html>
