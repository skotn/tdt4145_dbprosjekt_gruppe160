package tdt4145_gruppe160.treningsdagbok.core;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TreningsØktCtrl extends DBConn {
	private int ID=-1;
	public int getID() {
		return ID;
	}
	//Brukes også til å legge inn øvelser til økt lenger ned
	
	public static class TreningsØkt{
		public int id;
		public String datoTid;
		public int varighet;
		public int personlig_form;
		public int prestasjon;
		
		public String treningsformål;
		public String opplevelse;
		
		public TreningsØkt(int i, String dt, int v, int pf, int p) {
			id=i;
			datoTid=dt;
			varighet=v;
			personlig_form=pf;
			prestasjon=p;
		}
	}
    //Hva skal id være? hvordan vet man hva id skal være? Hente størrelse på tabellen med select * først prøves.
    public boolean insertTreningsØkt(String datoTid, int varighet, int form, int prestasjon) {
    	//Returnerer denne id som kan deretter brukes til å sette inn øvelser i denne økten
    	this.ID=-1; 
    	try {
    		//Genererer id basert på lengde på tabell
    		Statement getId=conn.createStatement();
    		ResultSet rs = getId.executeQuery("select count(*) as id from TreningsØkt");
    		rs.next();
    		ID=rs.getInt("id");
    		if (ID<0) {
    			return false;
    		}
    		ID++;
    		
    		//Setter inn i treningsøkt
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO treningsøkt " + "VALUES (" + ID + ",'" + datoTid +"',"+varighet+","+form+","+prestasjon+")");
            System.out.println("suksess treningsøkt");
            return true;
            
        } catch (Exception e) {
            System.out.println("db error during insert of Treningsøkt ");
            return false;
        }
    }

    //Punkt 2 hent n siste økter med notater, her returneres ikke med mindre notat eksisterer, vet ikke om det er godt nok?
    public ArrayList<TreningsØkt> getNLastTreningsØkt(int n) {
    	ArrayList<TreningsØkt> økter = new ArrayList<TreningsØkt>();
    	TreningsØkt t;
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * "+ "from treningsøkt inner join notat on (treningsøkt.id=notat.id)" + " order by DatoTid " + "limit "+ n+ ";");
            while (rs.next()) {
            	t = new TreningsØkt(rs.getInt("Treningsøkt.id"),rs.getString("datoTid"),rs.getInt("Varighet"),rs.getInt("Personlig_Form"),rs.getInt("Prestasjon"));
            	t.treningsformål=rs.getString("Treningsformål");
            	t.opplevelse=rs.getString("Opplevelse");
            	økter.add(t);
            }
            return økter;

        } catch (Exception e) {
            System.out.println("db error during select of treningsøkter = "+e);
            return null;
        }
    	
    }
    //Setter inn øvelse til økt, trenger id til spesifikk økt
    public boolean insertØktØvelse(String øvelse, int vekt, int sett) {
    	int øktID=this.ID;
    	try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO treningsøktøvelse " + "VALUES (" + øktID + ", '" + øvelse +"', "+vekt+", "+sett+ ") ");
            return true;
        } catch (Exception e) {
            System.out.println("db error during insert of øvelse i økt "+øktID);
            return false;
        }
    }
    
    public boolean insertNotat(String formål, String opplevelse) {
    	int id=this.ID;
    	try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO notat " + "VALUES (" + id + ", '" + formål + "', '"+opplevelse+ "')");
            return true;
        } catch (Exception e) {
            System.out.println("db error during insert of notat "+id);
            return false;
        }
    }

}
