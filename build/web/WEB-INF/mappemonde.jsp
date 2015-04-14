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
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1>La mappemonde de Airblio</h1>
                    <p>Blabla descriptif. "The Toyota Supra which Brian drives at the end of Furious 7 actually belonged to the late actor Paul Walker"</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <div id="filtre">
                        <h3>Les équipes techniques</h3>
                        <input type="checkbox" name="choix1" value="1"> <label>Afficher équipes</label> <br />
                        <input type="checkbox" name="choix3" value="3"> <label>Equipes en cours d’intervention</label> <br />
                        <input type="text" name="team" /> <br />
                        <input type="button" name="team" value="Chercher une equipe" onclick="chercheEquipe()" /> <br />
                        <input type="text" name="location" /> <br />
                        <input type="button" name="location" value="Chercher un lieu" onclick="chercheLieu()" />
                        <h3>Les clients</h3>
                        <input type="checkbox" name="choix1" value="1"> <label>Afficher clients</label> <br />
                        <input type="text" name="client" /> <br />
                        <input type="button" name="client" value="Chercher un client" onclick="chercheEquipe()" /> <br />
                        <input type="checkbox" name="choix3" value="3"> <label>Client ayant des interventions en cours</label> <br />
                        <input type="text" name="client" /> <br />
                        <input type="button" name="client" value="Intervention depuis" onclick="chercheEquipe()" /> <br />
                        <h3>Le matériel</h3>
                        <input type="checkbox" name="choix2" value="2"> <label>Afficher matériels</label> <br />
                        <input type="text" name="materiel" /> <br />
                        <input type="button" name="materiel" value="Client possédant ce matériel" onclick="chercheEquipe()" /> <br />
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
