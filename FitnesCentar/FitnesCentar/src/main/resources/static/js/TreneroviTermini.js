
let odabran=0;
let pritisnut=false;
function myFunction(id) {
	odabran=id;
	console.log(odabran);
	y=document.getElementById(odabran);
	x=y.getElementsByTagName("TD")[0];
	console.log(x.innerText);
	
	x=y.getElementsByTagName("TD")[1];
	document.getElementById("dani").value=x.innerText;
	x=y.getElementsByTagName("TD")[2];
	document.getElementById("cene").value=x.innerText;
	x=y.getElementsByTagName("TD")[3];
	document.getElementById("nazivi").value=x.innerText;
	x=y.getElementsByTagName("TD")[4];
	document.getElementById("opisi").value=x.innerText;
	x=y.getElementsByTagName("TD")[5];
	document.getElementById("tipovi").value=x.innerText;
	x=y.getElementsByTagName("TD")[6];
	document.getElementById("trajanja").value=x.innerText;
	if(pritisnut)document.getElementById('collapseExample').id = 'collapseExampleLock';
	pritisnut=true;
	}
$(document).on("submit", "#izmeniTermin", function (event) {     //PUT ZA IZMENU
    event.preventDefault();        
    let Id = odabran;
    let Dan			 =$("#dani		").val();
    let Cena		 =$("#cene		").val();
    let Naziv		 =$("#nazivi	").val();
    let Opis	 	 =$("#opisi		").val();
    let Tip	 		 =$("#tipovi	").val();
    let Trajanje	 =$("#trajanja	").val();
	
    let Izmene = {
		
	id			:odabran,
	dan			:Dan	,		 
	cena		:Cena	,	 
	naziv		:Naziv	,	 
	opis		:Opis	,	 
	tipTreninga :Tip	,		 
	trajanje	:Trajanje
	}


    $.ajax({
        type: "PUT",                                               
        url: "http://localhost:8081/api/RegistracijaTrenera/izmena",               
        dataType: "json",                                           
        contentType: "application/json",                            
        data: JSON.stringify(Izmene),                        
        success: function (response) {                              
            console.log(response);                              
			
        },
        error: function () {                                    
            alert("Greška!");
             window.location.href = "ClanTermini.html";      
        }
    });
});


		$(document).ready(function () {   //GET ZA DOBIJANJE TRENEROVIH TERMINA
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/RegistracijaTrenera/moji/"+localStorage.getItem("id"),               
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let termin of response) {                  
                let row = "<tr id='"+termin.id+"'>";                             
                row += "<td>" + termin.id + "</td>";      
                row += "<td>" + termin.dan + "</td>";     
                row += "<td>" + termin.cena+ "</td>";
                row += "<td>" + termin.naziv + "</td>";     
                row += "<td>" + termin.opis + "</td>";      
                row += "<td>" + termin.tipTreninga + "</td>";
                row += "<td>" + termin.trajanje + "</td>";  
				row += "<td   width='150' >" + "<input  data-toggle='collapse' href='#collapseExample'   type='button' class='btnRegister'  value='Izmeni' onclick='myFunction(" +termin.id+ ")'/></td></tr>";     
                

                $('#termini').append(row);              
				
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});       

