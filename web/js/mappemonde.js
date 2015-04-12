function initialize() {
    var mapOptions = {
        center: {lat: 48, lng: 2}, zoom: 8
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
    dataString = "markerID=" + 1;
    var textInfo = "null";
    
    google.maps.event.addListener(oMarker, 'click', function (data) {
        $.ajax({
            type: "POST",
            url: "MapEquipeTechnique",
            data: dataString,
           // dataType: "text",
            //if received a response from the server
            success: function (data, textStatus, jqXHR) {
                //our country code was correct so we have some information to display
                if (data.success) {
                    //$("#ajaxResponse").html("");
                    //$("#ajaxResponse").append("<b>Country Code:</b> " +  + "");
                    textInfo = data.markerText;
                }
                //display error message
                else {
                   textInfo = "data failed";
                }
                alert("Hello! success");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                textInfo = "Something really bad happened " + jqXHR;
                alert("Hello! error!!"+ textInfo);
                //$("#ajaxResponse").html(jqXHR.responseText);
            }
        });
        // affichage position du marker
        oInfo.setContent(textInfo);
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