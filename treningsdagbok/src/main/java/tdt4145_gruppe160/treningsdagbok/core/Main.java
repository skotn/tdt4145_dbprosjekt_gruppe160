package tdt4145_gruppe160.treningsdagbok.core;

import java.util.ArrayList;

import tdt4145_gruppe160.treningsdagbok.core.ApparatCtrl.Apparat;
import tdt4145_gruppe160.treningsdagbok.core.TreningsØktCtrl.TreningsØkt;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ApparatØvelse;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.FriØvelse;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ØvelseResultat;
import tdt4145_gruppe160.treningsdagbok.core.ØvelsesGruppeCtrl.ØvelsesGruppe;


public class Main {

	public static void main(String[] args) {
		//Tester apparatCtrl
		/*
		ApparatCtrl apparatTest = new ApparatCtrl();
		apparatTest.connect();
		apparatTest.insertApparat("Spinningsykkel", "Brukes til innendørs sykling");
		ArrayList<Apparat> apparater=apparatTest.getApparat();
		for (Apparat a : apparater) {
			System.out.println(a.navn+" "+a.beskrivelse);
		}*/
		
		
		
		//Tester treningsøktCtrl
		/*
		TreningsØktCtrl øktTest = new TreningsØktCtrl();
		øktTest.connect();
		int nyID=øktTest.insertTreningsØkt("2018-02-19 00:00:00", 3, 6, 6);
		
		ArrayList<TreningsØkt> økter=øktTest.getNLastTreningsØkt(4);
		for (TreningsØkt ø : økter) {
			System.out.println(ø.datoTid+" "+ø.treningsformål+" "+ø.opplevelse);
		}
		if (øktTest.insertNotat(nyID, "Få trent litt", "Hyggelig økt")){
			System.out.println("La inn notat til "+nyID);
		}
		økter=øktTest.getNLastTreningsØkt(4);
		for (TreningsØkt ø : økter) {
			System.out.println(ø.datoTid+" "+ø.treningsformål+" "+ø.opplevelse);
		}
		if (øktTest.insertØktØvelse(nyID, "Markløft",100,3)){
			System.out.println("La inn øvelseøkt til "+nyID);
		}*/
		
		
		
		//Tester ØvelsesGruppeCtrl
		/*
		ØvelsesGruppeCtrl gruppeTest = new ØvelsesGruppeCtrl();
		gruppeTest.connect();
		if (gruppeTest.insertØvelsesGruppe("Beinstyrke", "Øvelser som styrker beina")){
			System.out.println("La inn ny gruppe");
		}
		ArrayList<ØvelsesGruppe> grupper = gruppeTest.getØvelsesGruppe();
		for (ØvelsesGruppe g : grupper) {
			System.out.println(g.navn+" "+g.beskrivelse);
		}*/
		
		
		
		//Tester øvelseCtrl
		
		ØvelseCtrl øvelsetest= new ØvelseCtrl();
		øvelsetest.connect();/*
		if (øvelsetest.insertApparatØvelse("Innendørs sykling", "Kondisjon", "Spinningsykkel")){
			System.out.println("La inn ny apparatøvelse");
		}
		if (øvelsetest.insertFriØvelse("Sykling", "Kondisjon","Sykling ute")){
			System.out.println("La inn ny friøvelse");
		}*/
		ArrayList<FriØvelse> friøvelser = øvelsetest.getFriØvelse();
		for (FriØvelse f : friøvelser) {
			System.out.println(f.navn+" "+f.beskrivelse);
		}
		ArrayList<ApparatØvelse> apparatøvelser = øvelsetest.getApparatØvelse();
		for (ApparatØvelse a : apparatøvelser) {
			System.out.println(a.navn+" "+a.apparatNavn);
		}
		ArrayList<ØvelseResultat> resultater = øvelsetest.getØvelseMedResultat("Markløft", "2017-01-01 00:00:00", "2019-01-01 00:00:00");
		for (ØvelseResultat ør : resultater) {
			System.out.println(ør.datoTid+" "+ør.sett+" "+ør.vekt);
		}
		ArrayList<String> navn = øvelsetest.getØvelserIGruppe("Kondisjon");
		for (String n : navn) {
			System.out.println(n);
		}
		
	}

}
