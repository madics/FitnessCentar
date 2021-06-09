



INSERT INTO FITNES_CENTAR (Naziv,Adresa,broj_telefona,Email) VALUES ('Naziv1', 'Adresa 1', '111111','email@1');
INSERT INTO FITNES_CENTAR (Naziv,Adresa,broj_telefona,Email) VALUES ('Naziv2', 'Adresa 2', '222222','email@2');
INSERT INTO FITNES_CENTAR (Naziv,Adresa,broj_telefona,Email) VALUES ('Naziv3', 'Adresa 3', '333333','email@3');


INSERT INTO KORISNIK (Username,Password,Ime,Prezime,kontakt_telefon,Email,datum_rodjenja,uloga_korisnika,Aktivan
) VALUES ('Username1','Password1','Ime1','Prezime1','KontaktTelefon1','Email1','2001-11-11',1,FALSE);
INSERT INTO KORISNIK (Username,Password,Ime,Prezime,kontakt_telefon,Email,datum_rodjenja,uloga_korisnika,Aktivan
) VALUES ('Username2','Password2','Ime2','Prezime2','KontaktTelefon2','Email2','2002-2-22',2,TRUE);
INSERT INTO KORISNIK (Username,Password,Ime,Prezime,kontakt_telefon,Email,datum_rodjenja,uloga_korisnika,Aktivan
) VALUES ('Username3','Password3','Ime3','Prezime3','KontaktTelefon3','Email3','2003-3-3',2,TRUE);
INSERT INTO KORISNIK (Username,Password,Ime,Prezime,kontakt_telefon,Email,datum_rodjenja,uloga_korisnika,Aktivan
) VALUES ('Username4','Password4','Ime4','Prezime4','KontaktTelefon4','Email4','2004-4-4',0,TRUE);

INSERT INTO TRENER  (prosecna_ocena,id,fitnescentar_id
) VALUES (5,1,1);

INSERT INTO SALA  (Kapacitet,oznaka_sale,fitnescentar_id
) VALUES (500,'Oznaka1',2);
INSERT INTO SALA  (Kapacitet,oznaka_sale,fitnescentar_id
) VALUES (6600,'Oznaka2',1);

INSERT INTO TRENING  (Naziv,Opis,tip_treninga,Trajanje
) VALUES ('naziv1','opis1','tip1','trajanje1');
INSERT INTO TRENING  (Naziv,Opis,tip_treninga,Trajanje
) VALUES ('naziv2','opis2','tip2','trajanje2');

INSERT INTO TERMIN (cena,dan,sala_id,trener_id,trening_id
) VALUES (200,'2001-11-11',1,1,1);
INSERT INTO TERMIN (cena,dan,sala_id,trener_id,trening_id
) VALUES (150,'2002-12-22',2,1,2);
INSERT INTO TERMIN (cena,dan,sala_id,trener_id,trening_id
) VALUES (10,'2004-12-22',2,1,2);
INSERT INTO TERMIN (cena,dan,sala_id,trener_id,trening_id
) VALUES (1520,'2004-12-22',2,1,1);
INSERT INTO TERMIN (cena,dan,sala_id,trener_id,trening_id
) VALUES (1520,'2035-12-22',2,1,1);
 

INSERT INTO CLAN (id
) VALUES (2);

INSERT INTO CLAN (id
) VALUES (3);


INSERT INTO LISTA_PRIJAVLJENIH (clan_id,termin_id
) VALUES (2,1);
INSERT INTO LISTA_PRIJAVLJENIH (clan_id,termin_id
) VALUES (3,2);

INSERT INTO LISTA_POSETIOCA (clan_id,termin_id
) VALUES (3,2);


INSERT INTO OCENA (ocena,clan_id,termin_id
) VALUES (10,3,2);


INSERT INTO ADMINISTRATOR (id
) VALUES (4);


