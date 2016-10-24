$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "/api/asset/type/list/",
        success: function (data) {
            var selectAssetType = $('#selectAssetType');
            selectAssetType
                .find('option')
                .remove()
                .end()
                .selectpicker('refresh')
            ;
            for (var i = 0; i < data.length; i++) {
                selectAssetType.append($("<option/>", {
                    value: data[i]["id"],
                    text: data[i]["name"]
                })).selectpicker('refresh');
            }
            selectAssetType.trigger("change");
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
            selectLiabilityType
                .find('option')
                .remove()
                .end()
                .selectpicker('refresh')
            ;
            for (var i = 0; i < data.length; i++) {
                selectLiabilityType.append($("<option/>", {
                    value: data[i]["id"],
                    text: data[i]["name"]
                })).selectpicker('refresh');
            }
            selectLiabilityType.trigger("change");
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