// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8081/api/termini",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let employee of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + employee.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + employee.dan + "</td>";      // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + employee.cena+ "</td>";
                // kreiramo button i definisemo custom data atribut id = id zaposlenog
                let btn = "<button class='btnSeeMore' data-id=" + employee.id + ">See More</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#employees').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});
