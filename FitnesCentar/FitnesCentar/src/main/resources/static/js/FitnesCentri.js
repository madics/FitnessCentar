
let odabran=0;
let pritisnut=false;
function myFunction(id) {
	odabran=id;
	console.log(odabran);
	y=document.getElementById(odabran);
	x=y.getElementsByTagName("TD")[0];
	console.log(x.innerText);
	
	x=y.getElementsByTagName("TD")[1];
	document.getElementById("nazivi").value=x.innerText;
	x=y.getElementsByTagName("TD")[2];
	document.getElementById("adrese").value=x.innerText;
	x=y.getElementsByTagName("TD")[3];
	document.getElementById("brojevi").value=x.innerText;
	x=y.getElementsByTagName("TD")[4];
	document.getElementById("email").value=x.innerText;
	if(pritisnut)document.getElementById('collapseExample').id = 'collapseExampleLock';
	pritisnut=true;
	}
$(document).on("submit", "#izmeniFC", function (event) {     //PUT ZA IZMENU
    event.preventDefault();        
    let Id = odabran;
    let Naziv		 =$("#nazivi	").val();
    let Adresa	 	 =$("#adrese		").val();
    let Br	 		 =$("#brojevi	").val();
    let Email		 =$("#email	").val();
	
    let Izmene = {
		
	id			:odabran,
	naziv		:Naziv	,		 
	adresa		:Adresa	,		 
	broj		:Br	,	 
	email		:Email
	}
	console.log(Izmene);

    $.ajax({
        type: "PUT",                                               
        dataType: "json",                                           
        url: "http://localhost:8081/api/zahtevi/izmena/"+odabran,   
        contentType: "application/json",                            
        data: JSON.stringify(Izmene),                        
        success: function (response) {                              
            console.log(response);                              
			
             window.location.href = "FitnesCentri.html";  
        },
        error: function () {                                    
            alert("Greška!");
        }
    });
});


$(document).on('click', '.brisi', function () {// Brisanje postojećeg zaposlenog
    
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/api/zahtevi/" +odabran,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + odabran + '"]').parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
             window.location.href = "FitnesCentri.html";  
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});

		$(document).ready(function () {   //GET ZA DOBIJANJE FITNES Centara
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/zahtevi/fitnes",               
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let fc of response) {                  
                let row = "<tr id='"+fc.id+"'>";                             
                row += "<td>" + fc.id + "</td>";      
                row += "<td>" + fc.naziv + "</td>";     
                row += "<td>" + fc.adresa+ "</td>";
                row += "<td>" + fc.broj + "</td>";     
                row += "<td>" + fc.email + "</td>";      
				row += "<td   width='150' >" + "<input  data-toggle='collapse' href='#collapseExample'   type='button' class='btnRegister'  value='Izmeni' onclick='myFunction(" +fc.id+ ")'/></td>";     
				
				row += "<td   width='150' >" + "<input   type='button' class='btnRegister brisi'  value='Obrisi' onclick='myFunction(" +fc.id+ ")'/></td></tr>";     
				
                $('#fitnesi').append(row);              
				
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});       

