$(document).ready(function () {   
    $.ajax({
        type: "GET",                                          
        url: "http://localhost:8081/api/termini",             
        dataType: "json",                                     
        success: function (response) {                        
            console.log("SUCCESS:\n", response);
			// switch(expression) {
			// case x:
			// break;
			// case y:
			// break;
			// default:
			// }
			// response.sort((a, b) => (a.cena > b.cena) ? 1 : -1);
			
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
            }
        },
        error: function (response) {                             
            console.log("ERROR:\n", response);
        }
    });
});

        function getOption() {
            polje= document.querySelector('#sortiranjePo').value;
			nacin= document.querySelector('#nacinSortiranja').value;
			console.log(polje+" "+nacin);
			<!-- document.querySelector('.output').textContent= output; -->
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
		
		
		
		
		
		
		
	