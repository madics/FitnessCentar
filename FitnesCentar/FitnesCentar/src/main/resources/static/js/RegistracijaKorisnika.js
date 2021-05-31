
$(document).on("submit", "#noviClanForma", function (event) {     
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let aime = $("#ime").val();
    let aprezime = $("#prezime").val();
    let ausername = $("#username").val();
    let apassword = $("#password").val();
    let abroj = $("#broj").val();
    let aemail = $("#email").val();
    let adatum = $("#datum").val();
	
	
    let noviKorisnik = {
		Ime:			aime ,
		Prezime:		aprezime ,
		Username :		ausername,
		Password :		apassword,
		KontaktTelefon:	abroj,
		Email:			aemail,
		DatumRodjenja: 	adatum
		UlogaKorisnika: 2;
		Aktivan: TRUE;
		}
    
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8081/api/RegistracijaKorisnika",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(noviKorisnik),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Korisnik " +response+ " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            // window.location.href = "RegistracijaClana.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("greska!!!!");
        }
    });
});