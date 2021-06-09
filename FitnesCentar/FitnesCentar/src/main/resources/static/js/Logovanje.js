
$(document).on("submit", "#logovanjeForma", function (event) {     
    event.preventDefault();                 
    let Username = $("#user").val();
    let Password = $("#pass").val();
	
    let Korisnik = {
		username: Username,
		password: Password
		}
		
	console.log(Korisnik.username);
    
	$.ajax({
        type: "POST",                                             
        url: "http://localhost:8081/api/Logovanje",
        dataType: "json",                                         
        contentType: "application/json",                          
        data: JSON.stringify(Korisnik),                       
        success: function (response) {                            
		console.log(response);
		alert(response.uloga+" " +response.id+ " je ulogovan!");
           if(response.uloga=="CLAN")window.location.href = "Clan.html";           	     
           if(response.uloga=="TRENER")window.location.href = "Trener.html";           	     
           if(response.uloga=="ADMINISTRATOR")window.location.href = "Admin.html";           	     
        },
        error: function () {                                      				 
            alert("greska!!!!");
        }
    });
});