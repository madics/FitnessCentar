

$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/RegistracijaTrenera",   
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let fc of response)
				 popuniSelect(fc.naziv,fc.id,"fitnesCentar");
			 document.getElementById("fcPlaceHolder").style.display = "none";

        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});

        function popuniSelect(tekst,fcid,id) {
				var opt = document.createElement('option');
				opt.appendChild( document.createTextNode(tekst) );
				opt.value = fcid;
				document.getElementById(id).appendChild(opt);
		}

$(document).on("submit", "#noviTrenerForma", function (event) {     
    event.preventDefault();                           
    let Ime     = $("#ime").val();
    let Prezime      =$("#prezime").val();
    let Username            =$("#username").val();
    let Password       =$("#password").val();
    let KontaktTelefon= $("#broj").val();
    let Email         = $("#email").val();
    let DatumRodjenja =  $("#datum").val();
	let Fcid = document.querySelector('#fitnesCentar').value;

    let noviKorisnik = {
	fcid		:Fcid,
	username	:Username          ,
	password	:Password          ,
	ime			:Ime               ,
	prezime		:Prezime           ,
	telefon		:KontaktTelefon    ,
	email		:Email             ,
	datum		:DatumRodjenja
	} 
	
		console.log(noviKorisnik.fcid);                         
    $.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/RegistracijaTrenera",   
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(noviKorisnik),                       
        success: function (response) {   
		console.log(response);
		alert("Korisnik " +response.ime +" " + response.id+ " radi u"+response.fcid);
             window.location.href = "Login.html";           	     
        },
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});