
let odabran=0;
let pritisnut=false;
function myFunction(id) {
	odabran=id;
	console.log(odabran);
	y=document.getElementById(odabran);
	x=y.getElementsByTagName("TD")[0];
	console.log(x.innerText);
	x=y.getElementsByTagName("TD")[1];
	document.getElementById("kapaciteti").value=x.innerText;
	x=y.getElementsByTagName("TD")[2];
	document.getElementById("oznake").value=x.innerText;
	if(pritisnut)document.getElementById('collapseExample').id = 'collapseExampleLock';
	else pritisnut=true;
	}
$(document).on("submit", "#izmeniSalu", function (event) {     //PUT ZA IZMENU
    event.preventDefault();        
    let Id = odabran;
    let Kapacitet		 =$("#kapaciteti").val();
    let Oznaka	 	 =$("#oznake").val();
	
    let Izmene = {
		
	id			:odabran,
	kapacitet	:Kapacitet	,		 
	oznakaSale		:Oznaka	
	}
	console.log(Izmene);

    $.ajax({
        type: "PUT",                                               
        dataType: "json",                                           
        url: "http://localhost:8081/api/sala/"+odabran,   
        contentType: "application/json",                            
        data: JSON.stringify(Izmene),                        
        success: function (response) {                              
            console.log(response);                              
			
             window.location.href = "Sale.html";  
        },
        error: function () {                                    
            alert("Greška!");
        }
    });
});


$(document).on('click', '.brisi', function () {// Brisanje postojece sale
    
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/api/sala/" +odabran,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + odabran + '"]').parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
             window.location.href = "Sale.html";  
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});

		$(document).ready(function () {   //GET ZA DOBIJANJE SALA
		
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/sala",               
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			
            for (let sala of response) {                  
                let row = "<tr id='"+sala.id+"'>";                             
                row += "<td>" + sala.id + "</td>";      
                row += "<td>" + sala.kapacitet + "</td>";     
                row += "<td>" + sala.oznakaSale+ "</td>";    
				row += "<td   width='150' >" + "<input  data-toggle='collapse' href='#collapseExample'   type='button' class='btnRegister'  value='Izmeni' onclick='myFunction(" +sala.id+ ")'/></td>";     
				
				row += "<td   width='150' >" + "<input   type='button' class='btnRegister brisi'  value='Obrisi' onclick='myFunction(" +sala.id+ ")'/></td></tr>";     
				
                $('#fitnesi').append(row);              
				
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
}); 
$(document).ready(function () {   //select fitness
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

$(document).on("submit", "#pretragaTermina", function (event) {     
    event.preventDefault();                            	            
    $.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/fitnes/pretraga",   
        dataType: "json",                                         
        contentType: "application/json",   
        data: JSON.stringify(document.querySelector('#fitnesCentar').value),                       
        success: function (response) {   
		console.log(response);                         
		
			$("#fitnesi tr").remove(); 
			let row = "<tr><th>Id</th><th>Kapacitet</th><th>Oznaka</th></tr>"; 
			$('#fitnesi').append(row);   
			
			
            for (let sala of response) {                  
                let row = "<tr id='"+sala.id+"'>";                             
                row += "<td>" + sala.id + "</td>";      
                row += "<td>" + sala.kapacitet + "</td>";     
                row += "<td>" + sala.oznakaSale+ "</td>";    
				row += "<td   width='150' >" + "<input  data-toggle='collapse' href='#collapseExample'   type='button' class='btnRegister'  value='Izmeni' onclick='myFunction(" +sala.id+ ")'/></td>";     
				
				row += "<td   width='150' >" + "<input   type='button' class='btnRegister brisi'  value='Obrisi' onclick='myFunction(" +sala.id+ ")'/></td></tr>";     
				
                $('#fitnesi').append(row);              
				
            }
		},
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});
		

		
		
		
