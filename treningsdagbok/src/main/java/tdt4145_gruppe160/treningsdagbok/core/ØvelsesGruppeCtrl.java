package tdt4145_gruppe160.treningsdagbok.core;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ØvelsesGruppeCtrl extends DBConn {
	public static class ØvelsesGruppe {
		public String navn;
	    public String beskrivelse;
	    
	    public ØvelsesGruppe(String n, String b) {
	        navn=n;
	        beskrivelse=b;
	    }
	}
    public boolean insertØvelsesGruppe (String navn, String beskrivelse) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO øvelsesgruppe " + "VALUES ('" + navn + "', '" + beskrivelse + "')");
            return true;
        } catch (Exception e) {
            System.out.println("db error during insert of Øvelsesgruppe "+navn);
            return false;
        }
    }
    public ArrayList<ØvelsesGruppe> getØvelsesGruppe () {
    	ArrayList<ØvelsesGruppe> grupper = new ArrayList<ØvelsesGruppe>();
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Øvelsesgruppe");
            while (rs.next()) {
            	grupper.add(new ØvelsesGruppe(rs.getString("navn"),rs.getString("beskrivelse")));
            }
            return grupper;

        } catch (Exception e) {
            System.out.println("db error during select of apparater = "+e);
            return null;
        }
	}

}
