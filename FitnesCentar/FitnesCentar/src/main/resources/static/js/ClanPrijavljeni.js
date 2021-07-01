let odabran=0;

function myFunction(id) {
	odabran=id;
	}


$(document).on("submit", "#prijaviTermin", function (event) {     
    event.preventDefault();        
    let id = odabran;
   

    $.ajax({
        type: "PUT",                                               
        url: "http://localhost:8081/api/RegistracijaClana/odjava/"+localStorage.getItem("id"),                
        dataType: "json",                                           
        contentType: "application/json",                            
        data: JSON.stringify(id),                        
        success: function (response) {                              
            console.log(response);                              

            alert(" termin prijavljen!");     
			
        },
        error: function () {                                        
		console.log(localStorage.getItem("id")+","+id);
              window.location.href = "ClanPrijavljeni.html";      
            alert("Greška!");
        }
    });
});



$(document).ready(function () {   
           
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/RegistracijaClana/"+localStorage.getItem("id"),                
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
                row += "<td>" + termin.tipTreninga + "</td>";
                row += "<td>" + termin.trajanje + "</td>";  
				row += "<td  width='150' >" + "<input type='submit' id='"+termin.id+"' class='btnRegister'  value='Odjavi se' onclick='myFunction(" +termin.id+ ")'/></td></tr>";     
                
                $('#termini').append(row);              

            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});


		
		
		
		
	
		
		
		
	