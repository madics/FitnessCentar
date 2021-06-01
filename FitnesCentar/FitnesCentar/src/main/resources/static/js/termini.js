$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/termini",             
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);              

            for (let termin of response) {                  
                let row = "<tr>";                             
                row += "<td>" + termin.id + "</td>";      
                row += "<td>" + termin.dan + "</td>";     
                row += "<td>" + termin.cena+ "</td>";
                row += "<td>" + termin.naziv + "</td>";     
                row += "<td>" + termin.opis + "</td>";      
                row += "<td>" + termin.TipTreninga + "</td>";
                row += "<td>" + termin.trajanje + "</td>";  
                

                $('#termini').append(row);                     
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});
