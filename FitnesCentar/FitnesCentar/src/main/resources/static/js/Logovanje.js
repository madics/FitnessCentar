
$(document).on("submit", "#logovanjeForma", function (event) {     
    event.preventDefault();                            	             // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let Username = $("#user").val();
    let Password = $("#pass").val();
	
	console.log(Username);
    let Korisnik = {
		Username,
		Password
		}
		
	console.log(Korisnik.Username);
    
	$.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/Logovanje",
        dataType: "json",                                         
        contentType: "application/json",                          
        data: JSON.stringify(Korisnik),                       
        success: function (response) {                            
		console.log(response);
		alert("Korisnik " +response.ime +response.id+ " je ulogovan!");
            // window.location.href = "RegistracijaClana.html";           	     
        },
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});