package tdt4145_gruppe160.treningsdagbok.core;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ØvelseCtrl extends DBConn {
	public static class ØvelseTilRobert{
		public String navn;
		public String gruppeNavn;
		
		public ØvelseTilRobert(String n, String g) {
			navn=n;
			gruppeNavn=g;
		}
	}
	
	static class Øvelse {
		public String navn;
		public String gruppeNavn;
    	
    }
    public static class FriØvelse extends Øvelse{
    	public String beskrivelse;
    	
    	public FriØvelse(String n, String b) {
    		navn=n;
    		beskrivelse=b;
    	}
    }
    public static class ApparatØvelse extends Øvelse{
    	public String apparatNavn;
    	
    	public ApparatØvelse(String n, String a) {
    		navn=n;
    		apparatNavn=a;
    	}
    }
    //Hjelpeklasse som brukes til krav 3, inneholder resultat fra tidspunkt datoTid
    static class ØvelseResultat{
    	public String datoTid;
    	public int vekt;
    	public int sett;
    	public ØvelseResultat(String dt,int v, int s) {
    		datoTid=dt;
    		vekt=v;
    		sett=s;
    	}
    }
    //Denne brukes kun fra apparat og friøvelse for å opprettholde relasjonene til grupper
    private boolean insertØvelse(String navn, String gruppeNavn) {
    	try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Øvelse " + "VALUES ('" + navn + "', '" + gruppeNavn + "')");
            return true;
        } catch (Exception e) {
            System.out.println("db error during insert of øvelse "+navn);
            return false;
        }
    }
    //Må settes inn med gruppenavn som kan være "ingen". Burde endres til "uspesifisert"
    public boolean insertFriØvelse(String navn, String gruppeNavn, String beskrivelse) {
    	if(!this.insertØvelse(navn, gruppeNavn)){
    		return false;
    	}
    	try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO FriØvelse " + "VALUES ('" + navn + "', '" + beskrivelse +"')");
            return true;
        } catch (Exception e) {
            System.out.println("db error during insert of friøvelse "+navn);
            return false;
        }
    }
    //Sjekker at apparat eksisterer før den setter inn, så man ikke setter inn i øvelse før man vet at man kan sette inn apparatøvelse
    public boolean checkApparatExists(String navn) {
    	try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Apparat where navn='"+navn+"'");
            if(!rs.next()) {
            	System.out.println("db error during select of apparater could not find apparat "+rs.getString("navn"));
            	return false;
            }
            return true;
           
        } catch (Exception e) {
            System.out.println("db error during select of apparater = "+e);
            return false;
        }
    }
    public boolean insertApparatØvelse(String navn, String gruppeNavn, String apparatNavn) {
    	//Sjekk om apparat eksisterer først
    	if (!this.checkApparatExists(apparatNavn)) {
    		return false;
    	}
    	//Setter inn i øvelse først for å sjekke om den ikke eksisterer som en anne type øvelse
    	if(!this.insertØvelse(navn, gruppeNavn)){
    		return false;
    	}
    	try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO ApparatØvelse " + "VALUES ('" + navn + "', '" + apparatNavn+ "')");
            return true;
        } catch (Exception e) {
            System.out.println("db error during insert of apparatøvelse "+navn);
            return false;
        }
    }
  //Returnerer liste over alle friøvelser, kan brukes i representasjon av mulig øvelser man kan velge mellom når man registrerer øvelser til økten
    public ArrayList<FriØvelse> getFriØvelse() {
    	ArrayList<FriØvelse> øvelser = new ArrayList<FriØvelse>();
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from friøvelse");
            while (rs.next()) {
            	øvelser.add(new FriØvelse(rs.getString("navn"),rs.getString("beskrivelse")));
            }
            return øvelser;

        } catch (Exception e) {
            System.out.println("db error during select of apparater = "+e);
            return null;
        }
    }
    //Samme som over med apparatøvelser
    public ArrayList<ØvelseTilRobert> getØvelser() {
    	ArrayList<ØvelseTilRobert> øvelser = new ArrayList<ØvelseTilRobert>();
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from øvelse order by navn asc");
            while (rs.next()) {
            	øvelser.add(new ØvelseTilRobert(rs.getString("NAVN"),rs.getString("GRUPPE_NAVN")));
            }
            return øvelser;

        } catch (Exception e) {
            System.out.println("db error during select of øvelser = "+e);
            return null;
        }
    }
   //Samme som over med alle øvelser
    public ArrayList<ApparatØvelse> getApparatØvelse() {
    	ArrayList<ApparatØvelse> øvelser = new ArrayList<ApparatØvelse>();
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from apparatøvelse");
            while (rs.next()) {
            	øvelser.add(new ApparatØvelse(rs.getString("navn"),rs.getString("apparat_navn")));
            }
            return øvelser;

        } catch (Exception e) {
            System.out.println("db error during select of apparater = "+e);
            return null;
        }
    	
    }
    
    //Punkt 3 i kravene, returnerer en liste basert på øvelsenavn, start og slutttid som må være på format "YYYY-MM-DD TT:MM:SS"
    public ArrayList<ØvelseResultat> getØvelseMedResultat(String navn, String start, String slutt){
    	ArrayList<ØvelseResultat> resultat = new ArrayList<ØvelseResultat>();
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select datotid, vekt, sett  from treningsøkt inner join treningsøktøvelse on (treningsøkt.id=treningsøktøvelse.id and treningsøktøvelse.navn='"+navn+"') where (treningsøkt.DatoTid > '"+start+"' and treningsøkt.DatoTid < '"+slutt+"') " + " order by DatoTid asc");
            while (rs.next()) {
            	resultat.add(new ØvelseResultat(rs.getString("datotid"),rs.getInt("vekt"),rs.getInt("sett")));
            }
            return resultat;
            
        } catch (Exception e) {
            System.out.println("db error during select of resultat av øvelser = "+e);
            return null;
        }
    	
    }
    //Punkt 4 i krav, hente liste med Strings over øvelser basert på gruppenavn
    public ArrayList<String> getØvelserIGruppe(String gruppenavn) {
    	ArrayList<String> øvelser = new ArrayList<String>();
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select øvelse.navn from øvelsesgruppe inner join øvelse on (øvelsesgruppe.navn=øvelse.GRUPPE_NAVN) where øvelsesgruppe.navn='"+gruppenavn+"'");
            while (rs.next()) {
            	øvelser.add(rs.getString("navn"));
            }
            return øvelser;

        } catch (Exception e) {
            System.out.println("db error during select of øvelser i gruppe = "+gruppenavn);
            return null;
        }
    }

}
