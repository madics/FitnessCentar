

$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/RegistracijaTrenera/sale/"+localStorage.getItem("id"),   
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let sala of response)
				 popuniSelect(sala.oznakaSale,sala.id,"sala");
			 document.getElementById("salaPlaceHolder").style.display = "none";

        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});
$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/RegistracijaTrenera/treninzi/"+localStorage.getItem("id"),   
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let trening of response)
				 popuniSelect(trening.naziv,trening.id,"trening");
			 document.getElementById("treningPlaceHolder").style.display = "none";

        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});

        function popuniSelect(tekst,salaid,id) {
				var opt = document.createElement('option');
				opt.appendChild( document.createTextNode(tekst) );
				opt.value = salaid;
				document.getElementById(id).appendChild(opt);
		}

// $(document).on("submit", "#noviTermin", function (event) {     
    // event.preventDefault();                           
    // let Ime     = $("#ime").val();
    // let Prezime      =$("#prezime").val();
    // let Username            =$("#username").val();
    // let Password       =$("#password").val();
    // let KontaktTelefon= $("#broj").val();
    // let Email         = $("#email").val();
    // let DatumRodjenja =  $("#datum").val();
	// let Fcid = document.querySelector('#sala').value;

    // let noviKorisnik = {
	// fcid		:Fcid,
	// username	:Username          ,
	// password	:Password          ,
	// ime			:Ime               ,
	// prezime		:Prezime           ,
	// telefon		:KontaktTelefon    ,
	// email		:Email             ,
	// datum		:DatumRodjenja
	// } 
	
		// console.log(noviKorisnik.fcid);                         
    // $.ajax({
        // type: "POST",                                             
        // url: "http://localhost:8081/api/RegistracijaTrenera",   
        // dataType: "json",                                         
        // contentType: "application/json",   
        // data: JSON.stringify(noviKorisnik),                       
        // success: function (response) {   
		// console.log(response);
		// if(response.username==null){
		// alert("username vec postoji unesite drugi");
           // window.location.href = "RegistracijaTrenera.html";           	
        // }else{
			// alert("Korisnik " +response.username +" " + response.id+ " radi u"+response.fcid);
             // window.location.href = "Login.html";           	     
        // }
		// },
        // error: function () {                                      				 
            // alert("greska!!!!");
        // }
    // });
// });