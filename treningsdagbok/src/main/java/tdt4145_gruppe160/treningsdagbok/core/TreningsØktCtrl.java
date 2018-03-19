package tdt4145_gruppe160.treningsdagbok.core;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TreningsØktCtrl extends DBConn {
	//Brukes også til å legge inn øvelser til økt lenger ned
	
	static class TreningsØkt{
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
    public int insertTreningsØkt(String datoTid, int varighet, int form, int prestasjon) {
    	//Returnerer denne id som kan deretter brukes til å sette inn øvelser i denne økten
    	int id=-1; 
    	try {
    		//Genererer id basert på lengde på tabell
    		Statement getId=conn.createStatement();
    		ResultSet rs = getId.executeQuery("select count(*) as id from TreningsØkt");
    		rs.next();
    		id=rs.getInt("id");
    		if (id<0) {
    			return id;
    		}
    		id++;
    		
    		//Setter inn i treningsøkt
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO treningsøkt " + "VALUES (" + id + ",'" + datoTid +"',"+varighet+","+form+","+prestasjon+")");
            System.out.println("suksess treningsøkt");
            return id;
            
        } catch (Exception e) {
            System.out.println("db error during insert of Treningsøkt ");
            return -1;
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
    public boolean insertØktØvelse(int øktID, String øvelse, int vekt, int sett) {
    	try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO treningsøktøvelse " + "VALUES (" + øktID + ", '" + øvelse +"', "+vekt+", "+sett+ ") ");
            return true;
        } catch (Exception e) {
            System.out.println("db error during insert of øvelse i økt "+øktID);
            return false;
        }
    }
    
    public boolean insertNotat(int id, String formål, String opplevelse) {
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
