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
    
    
    google.maps.event.addListener(oMarker, 'click', function (data) {
        $.ajax({
            type: "POST",
            url: "/airblio/member/mappemondeRequest",
            data: dataString,
            dataType: "json",
            
            success: function (data) {
                if (data.success) {
                    oInfo.setContent(data["5"]);
                    oInfo.open(map, oMarker);
                }
            }
        });
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