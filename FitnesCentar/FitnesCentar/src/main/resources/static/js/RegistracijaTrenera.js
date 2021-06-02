
$(document).on("submit", "#noviTrenerForma", function (event) {     
    event.preventDefault();                            	             // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let Ime     = $("#ime").val();
    let Prezime      =$("#prezime").val();
    let Username            =$("#username").val();
    let Password       =$("#password").val();
    let KontaktTelefon= $("#broj").val();
    let Email         = $("#email").val();
    let DatumRodjenja =  $("#datum").val();
	
    let noviKorisnik = {
		
	username	:Username          ,
	password	:Password          ,
	ime			:Ime               ,
	prezime		:Prezime           ,
	telefon		:KontaktTelefon    ,
	email		:Email             ,
	datum		:DatumRodjenja
	} 
	
    $.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/RegistracijaTrenera",   
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(noviKorisnik),                       
        success: function (response) {   
		console.log("Ime je "+noviKorisnik.ime);                         
		console.log(response);
		alert("Korisnik " +response.ime +" " + response.id+ " je uspešno kreiran!");
            // window.location.href = "RegistracijaClana.html";           	     
        },
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});