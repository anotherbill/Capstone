/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
   loadAssetTypes();
    
});

function loadAssetTypes() {
    $('#assetType-list').empty();
    $.ajax({
        url: "http://localhost:8080/CapstoneProject/rest/assetTypes"
    }).then(function(data, status) {
       $.each(data, function(index, assetType){
          $('#assetType-list').append('<p>' + assetType.assetId + " " + assetType.category + '</p>');
       });
    });
}