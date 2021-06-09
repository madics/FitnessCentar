
$(document).on("submit", "#logovanjeForma", function (event) {     
    event.preventDefault();                            	             // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let Username = $("#user").val();
    let Password = $("#pass").val();
	
    let Korisnik = {
		username: Username,
		password: Password
		}
		
	console.log(Korisnik.username);
    
	$.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/Logovanje",
        dataType: "json",                                         
        contentType: "application/json",                          
        data: JSON.stringify(Korisnik),                       
        success: function (response) {                            
		console.log(response);
		alert(response.uloga+" " +response.id+ " je ulogovan!");
            // window.location.href = "RegistracijaClana.html";           	     
        },
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});