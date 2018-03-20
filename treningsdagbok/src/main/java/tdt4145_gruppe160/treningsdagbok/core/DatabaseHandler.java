package tdt4145_gruppe160.treningsdagbok.core;

import java.util.ArrayList;

import tdt4145_gruppe160.treningsdagbok.core.ApparatCtrl.Apparat;
import tdt4145_gruppe160.treningsdagbok.core.TreningsØktCtrl.TreningsØkt;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ApparatØvelse;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.FriØvelse;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ØvelseResultat;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ØvelseTilRobert;
import tdt4145_gruppe160.treningsdagbok.core.ØvelsesGruppeCtrl.ØvelsesGruppe;

public class DatabaseHandler extends DBConn {
	private ApparatCtrl apparatCtrl;
	private TreningsØktCtrl øktCtrl;
	private ØvelseCtrl øvelseCtrl;
	private ØvelsesGruppeCtrl gruppeCtrl;
	
	public DatabaseHandler() {
		this.apparatCtrl=new ApparatCtrl();
		this.øktCtrl=new TreningsØktCtrl();
		this.øvelseCtrl=new ØvelseCtrl();
		this.gruppeCtrl=new ØvelsesGruppeCtrl();
		
	}
	//Denne funksjon må kjøres før insert og get kan funke, setter connection til alle kontrollere mot databasen
	public void connectToDatabase() {
		this.connect();
		
		this.apparatCtrl.setConnection(this.conn);
		this.øktCtrl.setConnection(this.conn);
		this.øvelseCtrl.setConnection(this.conn);
		this.gruppeCtrl.setConnection(this.conn);
	}
	public int getID() {
		return this.øktCtrl.getID();
	}
	//Setter inn apparat, navn er nøkkel
	public boolean insertApparat(String navn, String beskrivelse) {
		return this.apparatCtrl.insertApparat(navn, beskrivelse);
	}
	//Returnerer arraylist over alle apparater med navn og beskrivelse som attributter
	public ArrayList<Apparat> getApparat() {
		return this.apparatCtrl.getApparat();
	}
	
	//Setter inn ny treningsøkt, øktCtrl har en attributt som heter ID som settes brukes til insert av notat og øvelser til denne ID
	//NB! datoTid må være på formatet "YYYY-MM-DD HH:MM:SS", form og prestasjon må være mellom 1 og 10
	public boolean insertTreningsØkt(String datoTid, int varighet, int form, int prestasjon) {
		return this.øktCtrl.insertTreningsØkt(datoTid, varighet, form, prestasjon);
	}
	//Returnerer en arraylist over n siste økter med notater
    public ArrayList<TreningsØkt> getNLastTreningsØkt(int n) {
    	return this.øktCtrl.getNLastTreningsØkt(n);
    }
    
    //Må ha kjørt insertTreningsØkt først!
    //øvelse refererer til en øvelse
    public boolean insertØktØvelse(String øvelse, int vekt, int sett) {
    	return this.øktCtrl.insertØktØvelse(øvelse, vekt, sett);
    }
    //Må ha kjørt insertTreningsØkt først!
    //Setter inn 
    public boolean insertNotat(String formål, String opplevelse) {
    	return this.øktCtrl.insertNotat(formål, opplevelse);
    }
    //Setter inn friøvelse, gruppenavn refererer til øvelsesgruppe
    public boolean insertFriØvelse(String navn, String gruppeNavn, String beskrivelse) {
    	return this.øvelseCtrl.insertFriØvelse(navn, gruppeNavn, beskrivelse);
    }
    //Setter inn apparatøvelse, gruppenavn refererer til øvelsesgruppe, apparatnavn til apparat
    public boolean insertApparatØvelse(String navn, String gruppeNavn, String apparatNavn) {
    	return this.øvelseCtrl.insertApparatØvelse(navn, gruppeNavn, apparatNavn);
    }
    //returnerer arraylist over alle friøvelser
    public ArrayList<FriØvelse> getFriØvelse() {
    	return this.øvelseCtrl.getFriØvelse();
    }
    //REturnerer arraylist over alle apparatøvelser
    public ArrayList<ApparatØvelse> getApparatØvelse() {
    	return this.øvelseCtrl.getApparatØvelse();
    }
    //REturnerer alle øvelser slik at Robert kan vise de i grensensittet sitt
    public ArrayList<ØvelseTilRobert> getØvelser() {
    	return this.øvelseCtrl.getØvelser();
    }
    //Navn er en øvelse, start og slutt er datotid på formatet "YYYY-MM-DD HH:MM:SS"
    //Returnerer arraylist over resultatobjekter for denne øvelsen, med datotid, vekt og sett for denne øvelsen
    public ArrayList<ØvelseResultat> getØvelseMedResultat(String navn, String start, String slutt){
    	return this.øvelseCtrl.getØvelseMedResultat(navn, start, slutt);
    }
    //REturnerer arraylist over alle navnene på øvelser i gruppenavn
    public ArrayList<String> getØvelserIGruppe(String gruppenavn) {
    	return this.øvelseCtrl.getØvelserIGruppe(gruppenavn);
    }
    
    //Insert ny øvelsesgruppe med beskrivelse
    public boolean insertØvelsesGruppe (String navn, String beskrivelse) {
    	return this.gruppeCtrl.insertØvelsesGruppe(navn, beskrivelse);
    }
    //REturnererr alle øvelsesgrupper
    public ArrayList<ØvelsesGruppe> getØvelsesGruppe () {
    	return this.gruppeCtrl.getØvelsesGruppe();
    }
}
