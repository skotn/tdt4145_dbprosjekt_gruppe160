CREATE DATABASE treningsdagbok;

CREATE TABLE Treningsøkt(
	ID INTEGER NOT NULL,
    Dato INTEGER, 
    Tidspunkt INTEGER,
    Varighet INTEGER,
    Personlig_Form INTEGER,
    Prestasjon INTEGER,
    CONSTRAINT økt_pk PRIMARY KEY (ID),
    CONSTRAINT Personlig_form_Ck CHECK (Personlig_form BETWEEN 1 AND 10),
    CONSTRAINT Prestasjon_Ck CHECK (Prestasjon BETWEEN 1 AND 10)
);
CREATE TABLE Apparat(
	ID INTEGER NOT NULL,
    BESKRIVELSE VARCHAR(450),
    CONSTRAINT apparat_pk PRIMARY KEY (ID)
);
CREATE TABLE Øvelse(
	NAVN VARCHAR(45) NOT NULL,
    GRUPPE_NAVN VARCHAR(45),
    CONSTRAINT øvelse_pk PRIMARY KEY (NAVN),
    CONSTRAINT gruppe_ref_fk FOREIGN KEY (GRUPPE_NAVN)
    references Øvelsesgruppe(NAVN)
		on update cascade
        on delete cascade
);

CREATE TABLE ApparatØvelse(
	NAVN VARCHAR(45) NOT NULL,
    APPARAT_ID INTEGER,
    CONSTRAINT apparat_øvelse_pk PRIMARY KEY (NAVN),
    CONSTRAINT apparat_øvelse_fk FOREIGN KEY (NAVN)
    references Øvelse(NAVN)
		on update cascade
        on delete cascade,
    CONSTRAINT apparat_id_fk FOREIGN KEY (APPARAT_ID)
    references Apparat(ID)
        on update cascade
        on delete cascade
);
CREATE TABLE FriØvelse(
	NAVN VARCHAR(45) NOT NULL,
    BESKRIVELSE VARCHAR(450),
    CONSTRAINT fri_pk PRIMARY KEY (NAVN),
	CONSTRAINT friøvelse_fk FOREIGN KEY (NAVN)
    references Øvelse(NAVN)
		on update cascade
        on delete cascade
);

CREATE TABLE TreningsøktØvelse(
    ID INTEGER NOT NULL,
    NAVN VARCHAR(45) NOT NULL,
    CONSTRAINT tøø_pk PRIMARY KEY (ID, NAVN),
    CONSTRAINT økt_fk FOREIGN KEY (ID)
    references Treningsøkt(ID)
		on update cascade
        on delete cascade,
    CONSTRAINT øvelse_fk FOREIGN KEY (NAVN)
    references Øvelse(NAVN)
		on update cascade
        on delete cascade
);

CREATE TABLE Øvelsesgruppe(
	NAVN VARCHAR(45) NOT NULL,
    BESKRIVELSE VARCHAR(450),
    CONSTRAINT gruppe_pk PRIMARY KEY (NAVN)
);

CREATE TABLE Notat(
	ID INTEGER NOT NULL,
    Treningsformål VARCHAR(450),
    Opplevelse VARCHAR(450),
    CONSTRAINT notat_pk PRIMARY KEY (ID),
    CONSTRAINT notat_fk FOREIGN KEY (ID)
    references Treningsøkt(ID)
		on update cascade
        on delete cascade

);
