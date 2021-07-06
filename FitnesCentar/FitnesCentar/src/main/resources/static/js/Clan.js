
let odabran=0;
let ocena=0;

function myFunction(id,oc) {
	odabran=id;
	ocena=oc;
		console.log(odabran);
		console.log(ocena);   
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
        url: "http://localhost:8081/api/termini/odradjeni/"+localStorage.getItem("id"),             
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
				row += "<td   width='80' >" + "<input type='submit' id='"+termin.id+"' class='btnRegister'  value='1' onclick='myFunction(" +termin.id+",1)'/></td>";     
				row += "<td   width='80' >" + "<input type='submit' id='"+termin.id+"' class='btnRegister'  value='2' onclick='myFunction(" +termin.id+",2)'/></td>";     
				row += "<td   width='80' >" + "<input type='submit' id='"+termin.id+"' class='btnRegister'  value='3' onclick='myFunction(" +termin.id+",3)'/></td>";     
				row += "<td   width='80' >" + "<input type='submit' id='"+termin.id+"' class='btnRegister'  value='4' onclick='myFunction(" +termin.id+",4)'/></td>";     
				row += "<td   width='80' >" + "<input type='submit' id='"+termin.id+"' class='btnRegister'  value='5' onclick='myFunction(" +termin.id+",5)'/></td></tr>";     
                
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

$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/RegistracijaClana/podaci/"+localStorage.getItem("id"),             
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
     document.getElementById('ime').innerHTML = response.ime;
     document.getElementById('prezime').innerHTML = response.prezime;
     document.getElementById('broj').innerHTML = response.telefon;
     document.getElementById('email').innerHTML = response.email;


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

$(document).on("submit", "#Oceni", function (event) {     
    event.preventDefault();                            	            
    let oc= ocena;
    let termin = odabran;
	let clan =localStorage.getItem("id");
		
    let novaOcena = {
	ocena			:oc	,		 
	clanId		:clan	,	 
	terminId		:termin	
	}
	
    $.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/RegistracijaClana/oceni",             
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(novaOcena),                       
        success: function (response) {   
		console.log(response);                         
		

		},
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});
		

		
		
		
		
	
		
		
		
	