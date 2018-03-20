package tdt4145_gruppe160.treningsdagbok.core;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ApparatCtrl extends DBConn {
	public static class Apparat {
		public String navn;
	    public String beskrivelse;
	    
	    public Apparat(String n, String b) {
	        navn=n;
	        beskrivelse=b;
	    }
	}
    //Kan endres slik at den sender boolean til grensesnitt for å bekrefte at alt fungerte
	public boolean insertApparat (String navn, String beskrivelse) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("insert into apparat " + "values ('" + navn + "', '" + beskrivelse + "')");
            return true;
        } catch (Exception e) {
            System.out.println("db error during insert of Apparat "+navn);
            return false;
        }
    }
	public ArrayList<Apparat> getApparat() {
		ArrayList<Apparat> apparater = new ArrayList<Apparat>();
		try {
            Statement stmt = conn.createStatement();
            //ResultSet rs = stmt.executeQuery("select sekvnr, postnr, tid from Reg where brikkenr=" + brikkeNr + " order by sekvnr");
            ResultSet rs = stmt.executeQuery("select * from Apparat");
            while (rs.next()) {
            	apparater.add(new Apparat(rs.getString("navn"),rs.getString("beskrivelse")));
            }
            return apparater;

        } catch (Exception e) {
            System.out.println("db error during select of apparater = "+e);
            return null;
        }
	}

}
