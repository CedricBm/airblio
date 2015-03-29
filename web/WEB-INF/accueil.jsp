<%-- 
    Document   : accueil
    Created on : 25 févr. 2015, 18:46:17
    Author     : CedricBm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            html, body, #map-canvas { height: 100%; margin: 0; padding: 0;}
        </style>
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
            }
            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:out value="utilisation de la jstl" /><br/>
        <div id="map-canvas"></div>
    </body>
</html>
