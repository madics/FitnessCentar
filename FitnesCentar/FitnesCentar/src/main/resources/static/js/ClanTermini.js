let odabran=0;

function myFunction(id) {
	odabran=id;
	}

$(document).on("submit", "#prijaviTermin", function (event) {     
    event.preventDefault();        
    let id = odabran;
   

    $.ajax({
        type: "PUT",                                               
        url: "http://localhost:8081/api/RegistracijaClana/prijava/"+localStorage.getItem("id"),               
        dataType: "json",                                           
        contentType: "application/json",                            
        data: JSON.stringify(id),                        
        success: function (response) {                              
            console.log(response);                              

            alert(" termin prijavljen!");                
		console.log(localStorage.getItem("id")+","+id);
             window.location.href = "ClanPrijavljeni.html";      
			
        },
        error: function () {                             
            alert("Greška!");
        }
    });
});



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
                row += "<td>" + termin.tipTreninga + "</td>";
                row += "<td>" + termin.trajanje + "</td>";  
				row += "<td   width='150' >" + "<input type='submit' id='"+termin.id+"' class='btnRegister'  value='Prijavi se' onclick='myFunction(" +termin.id+ ")'/></td></tr>";     
                
                $('#termini').append(row);              
				
				 popuniSelect(termin.dan,"dani"     );
				 popuniSelect(termin.cena,"cene"     );
				 popuniSelect(termin.naziv,"nazivi"   );
				 popuniSelect(termin.opis,"opisi"    );
				 popuniSelect(termin.tipTreninga,"tipovi"   );
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
    event.preventDefault();                            	            

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
	tipTreninga :Tip	,		 
	trajanje	:Trajanje
	}
	
    $.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/termini",   
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(zaPretragu),                       
        success: function (response) {   
		console.log(response);                         
		
			$("#termini tr").remove(); 
			let row = "<tr><th>Id</th><th>Dan</th><th>Cena</th><th>Naziv</th><th>Opis</th><th>Tip</th><th>Trajanje</th></tr>"; 
			$('#termini').append(row);   
			
			for (let termin of response) {                  
				row = "<tr>";                             
				row += "<td>" + termin.id + "</td>";      
				row += "<td>" + termin.dan + "</td>";     
				row += "<td>" + termin.cena+ "</td>";
				row += "<td>" + termin.naziv + "</td>";     
				row += "<td>" + termin.opis + "</td>";      
				row += "<td>" + termin.tipTreninga + "</td>";
				row += "<td>" + termin.trajanje + "</td>"; 
				row += "<td   width='150' >" + "<input type='submit' id='"+termin.id+"' class='btnRegister'  value='Prijavi se' onclick='myFunction(" +termin.id+ ")'/></td></tr>";     
      				
				$('#termini').append(row);                  
				
			}
		},
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});
		

		
		
		
		
	
		
		
		
	