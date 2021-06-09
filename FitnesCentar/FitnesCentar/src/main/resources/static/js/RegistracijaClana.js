
$(document).on("submit", "#noviClanForma", function (event) {     
    event.preventDefault();              
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
        url: "http://localhost:8081/api/RegistracijaClana",   
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(noviKorisnik),                       
        success: function (response) {   
		console.log("Ime je "+noviKorisnik.ime);                         
		console.log(response);
		alert("Korisnik " +response.ime +" " + response.id+ " je uspešno kreiran!");
             window.location.href = "Login.html";           	     
        },
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});