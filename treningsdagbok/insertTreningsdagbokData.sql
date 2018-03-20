/*Steder man kan sette inn alene, apparat, øvelsesgruppe, treningsøkt*/
insert into apparat values 
("Romaskin", "Brukes til å simulere innendørs roing i en stille posisjon"),
("Chin-up bar","Brukes til å løfte seg selv opp"),
("20kg vektstang","Brukes til diverse styrkeløft"),
("Smith-maskin","Brukes til diverse styrkeløft, sørger for at stangen går i kun en retning, så man kan fokusere mindre på balansen"),
("Tredemølle","Brukes til innendørs løping"),
("Vektede kabler","Brukes til diverse styrkeløft");

insert into øvelsesgruppe values 
("Kondisjon", "Øvelser som trener kondisjon"),
("Baseøvelse", "Styrkeøvelser som bruker flere muskelgrupper"),
("Ukjent","Øvelser som ikke nødvendigvis har en gruppetilhørighet"),
("Mageøvelse","Øvelser som trener muskulatur i mage"),
("Benstyrke","Øvelser som trener muskulatur i ben"),
("Overkroppstyrke","Øvelser som trener muskulatur i overkropp"),
("Balanseøvelser","Styrker balansen og kjernemuskulatur");

/*Her må man passe på å ikke legge inn ID større enn tabellstørrelsen, da JDBC legger inn basert på lengde på tabell
PS: dette burde kanskje endres i javakoden*/
insert into treningsøkt values 
(1, "2018-03-10 11:00:00",2,5,6),
(2, "2018-03-12 18:00:00",2,5,6),
(3, "2018-03-13 19:00:00",1,4,8),
(4, "2018-03-15 13:00:00",2,3,7),
(5, "2018-03-28 12:00:00",2,4,6);

/*notat trenger treningsøkt, burde kanskje legge inn automatisk null ved insert treningsøkt*/
insert into notat values
(1,"Formålet var å bli sprek","Det var en tung opplevelse"),
(2,"Rolig økt som skulle bidra til restitusjon","Gikk greit, kjente at jeg var overtrent");

/*øvelse trenger en øvelsesgruppe*/
insert into øvelse values
("Løping 1km","Kondisjon"),
("Svømming", "Kondisjon"),
("Push-up","Overkroppstyrke"),
("Pull-up","Overkroppstyrke"),
("Pistol Squat","Benstyrke"),

("Squats","Benstyrke"),
("Benkpress","Overkroppstyrke"),
("Innendørs løping 1km", "Kondisjon"),
("Innendørs roing 1km","Kondisjon"),
("Chin-up","Overkroppstyrke"),
("Markløft","Baseøvelse");

/*apparat og friøvelse trenger en øvelse, apparatøvelse trenger også apparat*/
insert into friøvelse values 
("Løping 1km","Løping i 1km utendørs, enkelt og greit"),
("Svømming", "Frisvømming i basseng, hvert sett tilsvarer 25 meter"),
("Push-up","Rett opp og ned på bakken"),
("Pull-up","Rett opp og ned hengende fra hva som helst"),
("Pistol Squat","Enfots squat");

insert into apparatøvelse values 
("Innendørs roing 1km","Romaskin"),
("Squats","20kg vektstang"),
("Benkpress","20kg vektstang"),
("Innendørs løping 1km", "Tredemølle"),
("Chin-up","Chin-up bar"),
("Markløft","20kg vektstang");

/*treningsøktøvelse trenger øvelse og økt*/
insert into treningsøktøvelse values 
(1, "Løping 1km",0,10),
(1,"Markløft", 140, 5),
(1,"Squats", 100, 5),
(1,"Pistol Squat", 0, 10),

(2,"Benkpress", 80, 5),
(2,"Chin-up", 20, 5),
(2,"Push-up", 0, 10),
(2, "Løping 1km",0,5),

(3,"Markløft", 140, 5),
(3,"Squats", 80, 10),

(4,"Innendørs roing 1km", 0, 10),

(5,"Markløft", 160, 5),
(5, "Innendørs løping 1km",0,5),
(5,"Svømming", 0, 40);
