$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/zahtevi",             
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let trener of response) {                  
                let row = "<tr>";                             
                row += "<td>" + trener.ime + "</td>";      
                row += "<td>" + trener.prezime + "</td>";   
                row += "<td>" + "<input type='submit'  class='btnRegister'  value='Odobri' onclick='myFunction(" +trener.id+ ")'/></td></tr>";     
                $('#treneri').append(row);      
				
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on("submit", "#dodajCentar", function (event) {     
    event.preventDefault();                                     
    let naziv = $("#naziv").val();
    let adresa = $("#adresa").val();
    let broj = $("#broj").val();
    let email = $("#email").val();


    let noviCentar = {
        naziv,
        adresa,
        broj,
        email     
    }
    

    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8081/api/fitnes",                
        dataType: "json",                                           
        contentType: "application/json",                            
        data: JSON.stringify(noviCentar),                        
        success: function (response) {                              
            console.log(response);                              

            alert(response.naziv + " je uspešno kreiran!");
            window.location.href = "FitnesCentri.html";              
        },
        error: function () {                                        
            alert("Greška prilikom dodavanja fitness centra!");
        }
    });
});

let odabran=0;

function myFunction(id) {
	odabran=id;
	}

$(document).on("submit", "#odobravanjeTrenera", function (event) {     
    event.preventDefault();        
    let id = odabran;
   
	console.log(id);

    $.ajax({
        type: "PUT",                                               
        url: "http://localhost:8081/api/zahtevi/"+id,                
        dataType: "json",                                           
        contentType: "application/json",                            
        data: JSON.stringify(id),                        
        success: function (response) {                              
            console.log(response);                              

            alert(response.ime+ " trener odobren!");     
             window.location.href = "Admin.html";      
			
        },
        error: function () {                                        
            alert("Greška prilikom dodavanja fitness centra!");
        }
    });
});



		
		
		
		
	