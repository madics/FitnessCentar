
$(document).on("submit", "#noviClanForma", function (event) {     
    event.preventDefault();                            	             // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let aime = $("#ime").val();
    let aprezime = $("#prezime").val();
    let ausername = $("#username").val();
    let apassword = $("#password").val();
    let abroj = $("#broj").val();
    let aemail = $("#email").val();
    let adatum = $("#datum").val();
	
	console.log(aime);
    let noviKorisnik = {
		Ime:			aime ,
		Prezime:		aprezime ,
		Username :		ausername,
		Password :		apassword,
		KontaktTelefon:	abroj,
		Email:			aemail,
		DatumRodjenja: 	adatum
		}
		
	console.log(noviKorisnik.Ime);
    $.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/RegistracijaKorisnika",   
        dataType: "json",                                         
        contentType: "application/json",                          
        data: JSON.stringify(noviKorisnik),                       
        success: function (response) {                            
		console.log(response);
		alert("Korisnik " +response.ime +response.id+ " je uspešno kreiran!");
            // window.location.href = "RegistracijaClana.html";           	     
        },
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});