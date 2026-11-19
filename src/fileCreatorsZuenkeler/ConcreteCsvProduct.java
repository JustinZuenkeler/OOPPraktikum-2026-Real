package fileCreatorsZuenkeler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import business.Moebelstueck;

public class ConcreteCsvProduct extends ReaderProductZuenkeler{
	
	public BufferedReader ein;
	
	public ConcreteCsvProduct() {
		try {
			ein = new BufferedReader(new FileReader("Moebelstueck.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String[] leseAusDatei() throws IOException {
			String[] zeile = this.ein.readLine().split(";");
			/*moebelstueck = new Moebelstueck(zeile[0], 
				zeile[1], 
				zeile[2], 
				Float.parseFloat(zeile[3]), 
				zeile[4].split("_"));
				ein.close();*/
			return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	}

}
