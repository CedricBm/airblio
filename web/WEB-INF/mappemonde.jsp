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
        <style type="text/css">
            html, body, #map-canvas { height: 100%; margin: 0; padding: 0;}
        </style>
    </head>

    <body>
        <div id="filtre">
            <form id="filtres">
                <input type="checkbox" name="choix1" value="1"> <label>Afficher équipes</label>
                <input type="checkbox" name="choix2" value="2"> <label>Afficher matériels</label>
                <input type="checkbox" name="choix3" value="3"> <label>Equipes en cours d’intervention</label>
                <input type="text" name="team"></input> 
                <input type="button" name="team" value="Chercher une equipe" onclick="chercheEquipe()"></input>
                <input type="text" name="location"></input> 
                <input type="button" name="location" value="Chercher un lieu" onclick="chercheLieu()"></input>
            </form>
        </div>
        <div id="map-canvas"></div>
    </body>

    <script type="text/javascript"
            src="https://maps.googleapis.com/maps/api/js?sensor=false">
    </script>  
    <script type="text/javascript">
        function initialize() {
            var mapOptions = {
                center: {lat: 48, lng: 2},
                zoom: 8
            };
            var map = new google.maps.Map(document.getElementById('map-canvas'),
                    mapOptions);
            // création de l'objet option
            var markerOption = {
                'position': new google.maps.LatLng(48.856667, 2.350987), // position d'ancrage du marker sur la carte
                'map': map                                              // l'objet carte sur lequel est affiché le marker
            };
            // création du marker
            var oMarker = new google.maps.Marker(markerOption);
            oMarker.setTitle("Paris");

            var oInfo = new google.maps.InfoWindow();

            google.maps.event.addListener(oMarker, 'click', function (data) {
                // affichage position du marker
                oInfo.setContent("Content perso");
                oInfo.open(map, oMarker);
            });
        }

        google.maps.event.addDomListener(window, 'load', initialize);

        function afficheEquipe() {

        }
        function afficheMateriel() {

        }
        function afficheEquipeEnCours() {

        }
        function chercheEquipe() {
            alert("Hello! I am an alert box!!");
        }
        function chercheLieu() {
            alert("Hello! I am an alert box!!");
        }
    </script>
</html>
