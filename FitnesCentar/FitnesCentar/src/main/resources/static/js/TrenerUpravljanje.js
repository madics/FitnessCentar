

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
        url: "http://localhost:8081/api/RegistracijaTrenera/treninzi/",   
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

$(document).on("submit", "#noviTermin", function (event) {     
    event.preventDefault();                           
	
    let Dan			 	 =$("#dani		").val();
    let Cena			 =$("#cene		").val();
    let Trener			 =localStorage.getItem("id");
    let Sala	 		 = document.querySelector('#sala').value;
    let Trening	 		 = document.querySelector('#trening').value;
	
	
    let noviTermin = {
		
	dan			:Dan	,		 
	cena		:Cena	,	 	 
	trenerId		:Trener	,	 	 
	salaId		:Sala	,	 	 
	treningId		:Trening	,	 
	}
 
	                         
    $.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/RegistracijaTrenera/noviTermin",   
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(noviTermin),                       
        success: function (response) {  
		console.log(response);
		
            alert("Termin "+response.id+" je kreiran!");
             window.location.href = "TreneroviTermini.html";      
		
		},
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});