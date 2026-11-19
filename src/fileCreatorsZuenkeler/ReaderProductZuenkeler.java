package fileCreatorsZuenkeler;

import java.io.IOException;

public abstract class ReaderProductZuenkeler {
	abstract public String[] leseAusDatei() throws IOException;
	
	abstract public void schliesseDatei() throws IOException;
	
	
}
