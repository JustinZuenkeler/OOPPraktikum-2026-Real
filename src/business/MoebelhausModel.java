package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MoebelhausModel {
	public Moebelstueck moebelstueck;

	public void schreibeMoebelstueckeInCsvDatei() throws IOException {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", true));
			aus.write(moebelstueck.gibMoebelstueckZurueck(';'));
			aus.close();

	}
	
	public void leseAusDatei(String typ) throws IOException{

      			BufferedReader ein = new BufferedReader(new FileReader("Moebelstueck.csv"));
      			String[] zeile = ein.readLine().split(";");
      			moebelstueck = new Moebelstueck(zeile[0], 
      				zeile[1], 
      				zeile[2], 
      				Float.parseFloat(zeile[3]), 
      				zeile[4].split("_"));
      				ein.close();
	}
}
