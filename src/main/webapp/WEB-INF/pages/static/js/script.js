$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "/api/asset/type/list/",
        success: function (data) {
            var selectAssetType = $('#selectAssetType');
            for (var i = 0; i < data.length; i++) {
                selectAssetType.append($("<option/>", {
                    value: data[i]["id"],
                    text: data[i]["name"]
                })).selectpicker('refresh');
            }
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log("Error: " + errorThrown + xhr.status + xhr.responseText);
        }
    });

    $.ajax({
        type: "GET",
        url: "/api/asset/list/",
        success: function (data) {
            var tableAsset = $('#tableAsset');
            var total = 0;
            for (var i = 0; i < data.length; i++) {
                tableAsset
                    .append($('<tr>')
                        .append($('<td>')
                            .text(data[i]["name"])
                        )
                        .append($('<td>')
                            .text(data[i]["assetType"]["name"])
                        )
                        .append($('<td>')
                            .text(data[i]["value"])
                        )
                    );
                var value = parseInt(data[i]["value"]);
                if (!isNaN(value)) {
                    total += value;
                }
            }
            tableAsset
                .find('tfoot tr th')
                .eq(2)
                .text(total);
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log("Error: " + errorThrown + xhr.status + xhr.responseText);
        }
    });



    $.ajax({
        type: "GET",
        url: "/api/liability/type/list/",
        success: function (data) {
            var selectLiabilityType = $('#selectLiabilityType');
            for (var i = 0; i < data.length; i++) {
                selectLiabilityType.append($("<option/>", {
                    value: data[i]["id"],
                    text: data[i]["name"]
                })).selectpicker('refresh');
            }
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log("Error: " + errorThrown + xhr.status + xhr.responseText);
        }
    });

    $.ajax({
        type: "GET",
        url: "/api/liability/list/",
        success: function (data) {
            var tableLiability = $('#tableLiability');
            var total = 0;
            for (var i = 0; i < data.length; i++) {
                tableLiability
                    .append($('<tr>')
                        .append($('<td>')
                            .text(data[i]["name"])
                        )
                        .append($('<td>')
                            .text(data[i]["liabilityType"]["name"])
                        )
                        .append($('<td>')
                            .text(data[i]["value"])
                        )
                    );
                var value = parseInt(data[i]["value"]);
                if (!isNaN(value)) {
                    total += value;
                }
            }
            tableLiability
                .find('tfoot tr th')
                .eq(2)
                .text(total);
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log("Error: " + errorThrown + xhr.status + xhr.responseText);
        }
    });

    $('.selectpicker').selectpicker({
        style: 'btn-default',
        width: '100%'
    });

});