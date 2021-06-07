$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/termini",             
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let termin of response) {                  
                let row = "<tr>";                             
                row += "<td>" + termin.id + "</td>";      
                row += "<td>" + termin.dan + "</td>";     
                row += "<td>" + termin.cena+ "</td>";
                row += "<td>" + termin.naziv + "</td>";     
                row += "<td>" + termin.opis + "</td>";      
                row += "<td>" + termin.tip + "</td>";
                row += "<td>" + termin.trajanje + "</td>";  
                $('#termini').append(row);                  
				
				popuniSelect(termin.dan      ,"dani		"     );
				popuniSelect(termin.cena     ,"cene		"     );
				popuniSelect(termin.naziv    ,"nazivi	"   );
				popuniSelect(termin.opis     ,"opisi	"    );
				popuniSelect(termin.tip      ,"tipovi	"   );
				popuniSelect(termin.trajanje ,"trajanja" );
				
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});

        function popuniSelect(polje,id) {
				var opt = document.createElement('option');
				opt.appendChild( document.createTextNode(polje) );
				opt.value = polje;
				if ($("#"+id+" option[value='"+polje+"']").length == 0)document.getElementById(id).appendChild(opt);
		}
		
        function getOption() {
            polje= document.querySelector('#sortiranjePo').value;
			nacin= document.querySelector('#nacinSortiranja').value;
			var table, rows, switching, i, x, y;
			
					table = document.getElementById("termini");
					switching = true;
					while (switching) {
							switching = false;
							rows = table.rows;
							for (i = 1; i < (rows.length - 1); i++) {
								  x = rows[i].getElementsByTagName("TD")[polje];
								  y = rows[i + 1].getElementsByTagName("TD")[polje];
								  if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()&&nacin==0) {             
									rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
									switching = true;
									break;
								  }
								  if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()&&nacin==1) {             
									rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
									switching = true;
									break;
								  }
							}
					}
		}

$(document).on("submit", "#pretragaTermina", function (event) {     
    event.preventDefault();                            	             // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let Dan			 =$("#dani		").val();
    let Cena		 =$("#cene		").val();
    let Naziv		 =$("#nazivi	").val();
    let Opis	 	 =$("#opisi		").val();
    let Tip	 		 =$("#tipovi	").val();
    let Trajanje	 =$("#trajanja	").val();
	
    let zaPretragu = {
		
	dan			:Dan	,		 
	cena		:Cena	,	 
	naziv		:Naziv	,	 
	opis		:Opis	,	 
	tip			:Tip	,		 
	trajanje	:Trajanje
	}
	
    $.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/RegistracijaClana",   
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(zaPretragu),                       
        success: function (response) {   
		console.log("Ime je "+zaPretragu.ime);                         
		console.log(response);
		alert("Korisnik " +response.ime +" " + response.id+ " je uspešno kreiran!");
            // window.location.href = "RegistracijaClana.html";           	     
        },
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});
		

		
		
		
		
	