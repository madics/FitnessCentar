
$(document).on('click', '.brisi', function () {// Brisanje postojećeg zaposlenog
    
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/api/RegistracijaTrenera/" +odabran,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + odabran + '"]').parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
         //    window.location.href = "Treneri.html";  
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});

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


     
$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/zahtevi/svi",             
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let trener of response) {                  
                let row = "<tr>";                             
                row += "<td>" + trener.ime + "</td>";      
                row += "<td>" + trener.prezime + "</td>";   
                row += "<td width='150' >" + "<input type='submit'  class='btnRegister brisi'  value='Obrisi' onclick='myFunction(" +trener.id+ ")'/></td></tr>";     
                $('#treneri').append(row);      
				
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});
