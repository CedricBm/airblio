$(function () {
    var map;
    var geocoder;
    var equipesTechnique = [];
    var equipesTechniqueIntervention = [];
    var clients = [];
    var clientsIntervention = [];
    var uneEquipe = new google.maps.Marker();
    var unClient = new google.maps.Marker();
    var unLieu = new google.maps.Marker();
    var clientsPossedant = [];
    var interventionsDepuis = [];
    var materiaux = [];
    var materiauxSite = [];
    var materiauxClients = [];

    function initialize() {
        geocoder = new google.maps.Geocoder();
        var mapOptions = {
            center: {lat: 48, lng: 2}, zoom: 8
        };
        map = new google.maps.Map(document.getElementById('map-canvas'),
                mapOptions);
    }

    google.maps.event.addDomListener(window, 'load', initialize);

    $("#afficheEquipes").change(function () {
        if ($(this).is(':checked')) {
            if (equipesTechnique.length === 0) {
                $.ajax({
                    type: "POST",
                    url: "/airblio/member/mappemondeRequest",
                    data: {requete: 'afficheEquipes'},
                    dataType: "json",
                    success: function (data) {
                        $.each(data, function (key, value) {
                            var oMarker = new google.maps.Marker({
                                position: new google.maps.LatLng(value.latitude, value.longitude),
                                map: map,
                                title: value.nom
                            });
                            var oInfo = new google.maps.InfoWindow({
                                content: value.content
                            });
                            google.maps.event.addListener(oMarker, 'click', function () {
                                oInfo.open(map, oMarker);
                            });
                            equipesTechnique.push(oMarker);
                        });
                    }
                });
            } else {
                for (var index = 0; index < equipesTechnique.length; index++) {
                    equipesTechnique[index].setMap(map);
                }
            }
        } else {
            for (var index = 0; index < equipesTechnique.length; index++) {
                equipesTechnique[index].setMap(null);
            }
        }
    });

    $("#afficheEquipesIntervention").change(function () {
        if ($(this).is(':checked')) {
            if (equipesTechniqueIntervention.length === 0) {
                $.ajax({
                    type: "POST",
                    url: "/airblio/member/mappemondeRequest",
                    data: {requete: 'afficheEquipesIntervention'},
                    dataType: "json",
                    success: function (data) {
                        $.each(data, function (key, value) {
                            var oMarker = new google.maps.Marker({
                                position: new google.maps.LatLng(value.latitude, value.longitude),
                                map: map,
                                title: value.nom
                            });
                            var oInfo = new google.maps.InfoWindow({
                                content: value.content
                            });
                            google.maps.event.addListener(oMarker, 'click', function () {
                                oInfo.open(map, oMarker);
                            });
                            equipesTechniqueIntervention.push(oMarker);
                        });
                    }
                });
            } else {
                for (var index = 0; index < equipesTechniqueIntervention.length; index++) {
                    equipesTechniqueIntervention[index].setMap(map);
                }
            }
        } else {
            for (var index = 0; index < equipesTechniqueIntervention.length; index++) {
                equipesTechniqueIntervention[index].setMap(null);
            }
        }
    });

    $("#afficheClients").change(function () {
        if ($(this).is(':checked')) {
            if (clients.length === 0) {
                $.ajax({
                    type: "POST",
                    url: "/airblio/member/mappemondeRequest",
                    data: {requete: 'afficheClients'},
                    dataType: "json",
                    success: function (data) {
                        $.each(data, function (key, value) {
                            geocoder.geocode({address: value.adresse}, function (results, status) {
                                if (status == google.maps.GeocoderStatus.OK) {
                                    var oMarker = new google.maps.Marker({
                                        map: map,
                                        position: results[0].geometry.location,
                                        title: value.nom
                                    });
                                } else {
                                    console.log('Geocode was not successful for the following reason: ' + status);
                                }
                                var oInfo = new google.maps.InfoWindow({
                                    content: value.content
                                });
                                google.maps.event.addListener(oMarker, 'click', function () {
                                    oInfo.open(map, oMarker);
                                });
                                clients.push(oMarker);
                            });
                        });
                    }
                });
            } else {
                for (var index = 0; index < clients.length; index++) {
                    clients[index].setMap(map);
                }
            }
        } else {
            for (var index = 0; index < clients.length; index++) {
                clients[index].setMap(null);
            }
        }
    });

    $("#afficheClientsIntervention").change(function () {
        if ($(this).is(':checked')) {
            if (clientsIntervention.length === 0) {
                $.ajax({
                    type: "POST",
                    url: "/airblio/member/mappemondeRequest",
                    data: {requete: 'afficheClientsIntervention'},
                    dataType: "json",
                    success: function (data) {
                        $.each(data, function (key, value) {
                            geocoder.geocode({address: value.adresse}, function (results, status) {
                                if (status == google.maps.GeocoderStatus.OK) {
                                    var oMarker = new google.maps.Marker({
                                        map: map,
                                        position: results[0].geometry.location,
                                        title: value.nom
                                    });
                                } else {
                                    console.log('Geocode was not successful for the following reason: ' + status);
                                }
                                var oInfo = new google.maps.InfoWindow({
                                    content: value.content
                                });
                                google.maps.event.addListener(oMarker, 'click', function () {
                                    oInfo.open(map, oMarker);
                                });
                                clientsIntervention.push(oMarker);
                            });
                        });
                    }
                });
            } else {
                for (var index = 0; index < clientsIntervention.length; index++) {
                    clientsIntervention[index].setMap(map);
                }
            }
        } else {
            for (var index = 0; index < clientsIntervention.length; index++) {
                clientsIntervention[index].setMap(null);
            }
        }
    });

    $("#afficheMaterielsSite").change(function () {
        if ($(this).is(':checked')) {
            if (materiauxSite.length === 0) {
                $.ajax({
                    type: "POST",
                    url: "/airblio/member/mappemondeRequest",
                    data: {requete: 'afficheMaterielsSite'},
                    dataType: "json",
                    success: function (dataSite) {
                        $.each(dataSite, function (key, value) {
                            var oMarker = new google.maps.Marker({
                                position: new google.maps.LatLng(value.latitude, value.longitude),
                                map: map,
                                title: value.nom
                            });
                            var oInfo = new google.maps.InfoWindow({
                                content: value.content
                            });
                            google.maps.event.addListener(oMarker, 'click', function () {
                                oInfo.open(map, oMarker);
                            });
                            materiauxSite.push(oMarker);
                        });

                    }
                });
            } else {
                for (var index = 0; index < materiauxSite.length; index++) {
                    materiauxSite[index].setMap(map);
                }
            }
        } else {
            for (var index = 0; index < materiauxSite.length; index++) {
                materiauxSite[index].setMap(null);
            }
        }
    });

    $("#afficheMaterielsClients").change(function () {
        if ($(this).is(':checked')) {
            if (materiauxClients.length === 0) {
                $.ajax({
                    type: "POST",
                    url: "/airblio/member/mappemondeRequest",
                    data: {requete: 'afficheMaterielsClients'},
                    dataType: "json",
                    success: function (dataClient) {
                        $.each(dataClient, function (key, value) {
                            var oMarker = new google.maps.Marker({
                                position: new google.maps.LatLng(value.latitude, value.longitude),
                                map: map,
                                title: value.nom
                            });
                            var oInfo = new google.maps.InfoWindow({
                                content: value.content
                            });
                            google.maps.event.addListener(oMarker, 'click', function () {
                                oInfo.open(map, oMarker);
                            });
                            materiauxClients.push(oMarker);
                        });
                    }
                });
            } else {
                for (var index = 0; index < materiauxClients.length; index++) {
                    materiauxClients[index].setMap(map);
                }
            }
        } else {
            for (var index = 0; index < materiauxClients.length; index++) {
                materiauxClients[index].setMap(null);
            }
        }
    });

    $("#selectMultiple").change(function () {
        if ($(this).val() == "intervention") {
            $("#multiple").val("");
            $("#multiple").prop('type', 'date');
        } else {
            $("#multiple").prop('type', 'text');
            $("#multiple").val("");
        }
    });

    $("#multipleButton").click(function () {
        var selectVal = $("#selectMultiple").val();
        var inputVal = $("#multiple").val();
        if (inputVal !== "") {
            if (selectVal === "equipe") {
                getEquipe(inputVal);
            } else if (selectVal === "client") {
                getClient(inputVal);
            } else if (selectVal === "intervention") {
                getIntervention(inputVal);
            } else if (selectVal === "clientPossedant") {
                getClientPossedant(inputVal);
            } else if (selectVal === "materiel") {
                getMateriel(inputVal);
            }
        } else {
            uneEquipe.setMap(null);
            unClient.setMap(null);
            unLieu.setMap(null);
            for (var index = 0; index < clientsPossedant.length; index++) {
                clientsPossedant[index].setMap(null);
            }
            for (var ind = 0; ind < interventionsDepuis.length; ind++) {
                interventionsDepuis[ind].setMap(null);
            }
            for (var inde = 0; inde < materiaux.length; inde++) {
                materiaux[inde].setMap(null);
            }
        }
    });

    function getClient(inputVal) {
        $.ajax({
            type: "POST",
            url: "/airblio/member/mappemondeRequest",
            data: {requete: 'afficheUnClient', nom: inputVal},
            dataType: "json",
            success: function (data) {
                geocoder.geocode({address: data.adresse}, function (results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        var oMarker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location,
                            title: data.nom
                        });
                        map.setCenter(results[0].geometry.location);
                    } else {
                        console.log('Geocode was not successful for the following reason: ' + status);
                    }
                    var oInfo = new google.maps.InfoWindow({
                        content: data.content
                    });
                    google.maps.event.addListener(oMarker, 'click', function () {
                        oInfo.open(map, oMarker);
                    });
                    unClient = oMarker;
                });
            }
        });
    }

    function getIntervention(inputVal) {
        $.ajax({
            type: "POST",
            url: "/airblio/member/mappemondeRequest",
            data: {requete: 'afficheInterventionDepuis', nom: inputVal},
            dataType: "json",
            success: function (data) {
                $.each(data, function (key, value) {
                    var oMarker = new google.maps.Marker({
                        position: new google.maps.LatLng(value.latitude, value.longitude),
                        map: map,
                        title: value.nom
                    });
                    var oInfo = new google.maps.InfoWindow({
                        content: value.content
                    });
                    google.maps.event.addListener(oMarker, 'click', function () {
                        oInfo.open(map, oMarker);
                    });
                    interventionsDepuis.push(oMarker);
                });
            }
        });
    }

    function getClientPossedant(inputVal) {
        $.ajax({
            type: "POST",
            url: "/airblio/member/mappemondeRequest",
            data: {requete: 'afficheClientPossedant', nom: inputVal},
            dataType: "json",
            success: function (data) {
                console.log(data);
                $.each(data, function (key, value) {
                    geocoder.geocode({address: value.adresse}, function (results, status) {
                        if (status == google.maps.GeocoderStatus.OK) {
                            var oMarker = new google.maps.Marker({
                                map: map,
                                position: results[0].geometry.location,
                                title: value.nom
                            });
                        } else {
                            console.log('Geocode was not successful for the following reason: ' + status);
                        }
                        var oInfo = new google.maps.InfoWindow({
                            content: value.content
                        });
                        google.maps.event.addListener(oMarker, 'click', function () {
                            oInfo.open(map, oMarker);
                        });
                        clientsPossedant.push(oMarker);
                    });
                });
            }
        });
    }

    function getMateriel(inputVal) {
        $.ajax({
            type: "POST",
            url: "/airblio/member/mappemondeRequest",
            data: {requete: 'afficheMateriel', nom: inputVal},
            dataType: "json",
            success: function (data) {
                $.each(data, function (key, value) {
                    var oMarker = new google.maps.Marker({
                        position: new google.maps.LatLng(value.latitude, value.longitude),
                        map: map,
                        title: value.nom
                    });
                    var oInfo = new google.maps.InfoWindow({
                        content: value.content
                    });
                    google.maps.event.addListener(oMarker, 'click', function () {
                        oInfo.open(map, oMarker);
                    });
                    materiaux.push(oMarker);
                });
            }
        });
    }

    function getEquipe(inputVal) {
        $.ajax({
            type: "POST",
            url: "/airblio/member/mappemondeRequest",
            data: {requete: 'arricheUneEquipe', nom: inputVal},
            dataType: "json",
            success: function (data) {
                var latlng = new google.maps.LatLng(data.latitude, data.longitude);
                var oMarker = new google.maps.Marker({
                    position: latlng,
                    map: map,
                    title: data.nom
                });
                map.setCenter(latlng);
                var oInfo = new google.maps.InfoWindow({
                    content: data.content
                });
                google.maps.event.addListener(oMarker, 'click', function () {
                    oInfo.open(map, oMarker);
                });
                uneEquipe = oMarker;
            }
        });
    }

});
