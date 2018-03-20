/*Eksperimenterer litt her, bare kjører funksjoner for å teste databasen, f.eks se om data er registrert i JDBC*/
/*Krav 2,3 og 4 løses nederst*/
select *
from øvelse;

update øvelse
set navn="Løping 1km"
where navn="Løping 10km";

select *
from treningsøktøvelse;

/*Krav 2 3 og 4 løses under her, bare enkle eksempler*/
/*n settes i limit*/
select treningsøkt.id, datoTid, varighet, Personlig_Form, Prestasjon, treningsformål, opplevelse
from treningsøkt inner join notat on (treningsøkt.id=notat.id)
order by DatoTid desc
limit 2;

/*Markløft er valgt øvelse, tidsperioden settes i where*/
select datotid, vekt, sett
from treningsøkt inner join treningsøktøvelse on (treningsøkt.id=treningsøktøvelse.id and treningsøktøvelse.navn="Markløft")
where (treningsøkt.DatoTid > "2018-03-18 00:00:00" and treningsøkt.DatoTid < "2018-03-18 23:00:00")
order by DatoTid asc;

/*Setter valgt øvelsesgruppe i where*/
select øvelse.navn
from øvelsesgruppe inner join øvelse on (øvelsesgruppe.navn=øvelse.GRUPPE_NAVN)
where øvelsesgruppe.navn="Kondisjon";