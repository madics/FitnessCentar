
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
        url: "http://localhost:8081/api/RegistracijaTrenera/admin",   
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(noviKorisnik),                       
        success: function (response) {   
		console.log(response);
		if(response.username==null){
		alert("username vec postoji unesite drugi");
           window.location.href = "RegistracijaTrenera.html";           	
        }else{
			alert("Korisnik " +response.username +" " + response.id+ " radi u"+response.fcid);
             window.location.href = "Treneri.html";           	     
        }
		},
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});
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
                row += "<td width='150' >" + "<input type='submit'  class='btnRegister'  value='Odobri' onclick='myFunction(" +trener.id+ ")'/></td></tr>";     
                $('#treneri').append(row);      
				
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});

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



		
		
		
		
	