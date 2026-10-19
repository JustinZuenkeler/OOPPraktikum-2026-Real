package gui;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;

import business.*;
import javafx.stage.Stage;

public class MoebelhausControl {
	private MoebelhausModel moebelModel;
	private MoebelhausView moebelView;
		
	 
	public MoebelhausControl(Stage primaryStage){
		this.moebelModel = new MoebelhausModel();
		this.moebelView = new MoebelhausView(primaryStage, this, moebelModel);
	}
	
	
		public void nehmeMoebelstueckAuf(){
	    	try{ 
	    		moebelModel.moebelstueck = new Moebelstueck(
	    			moebelView.txtName.getText(), 
	   	            moebelView.txtWohnraum.getText(),
	   	            moebelView.txtStil.getText(),
	   	            Float.parseFloat(moebelView.txtPreis.getText()),
	    		    moebelView.txtMaterialien.getText().split(";"));
	    		moebelView.zeigeInformationsfensterAn("Das Moebelstueck wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		moebelView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
		
	void zeigeMoebelstueckAn(){
    	if(moebelModel.moebelstueck != null){
    		moebelView.txtAnzeige.setText(
    			moebelModel.moebelstueck.gibMoebelstueckZurueck(' '));
    	}
    	else{
    		moebelView.zeigeInformationsfensterAn("Bisher wurde keine Moebelstueck aufgenommen!");
    	}
    }
	public void schreibeMoebelstueckeInCsvDatei() {
		try {
			moebelModel.schreibeMoebelstueckeInCsvDatei();
			moebelView.zeigeInformationsfensterAn(
					"Die Moebelstuecke wurden gespeichert!");
		}
		catch(IOException exc){
			moebelView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			moebelView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			moebelModel.leseAusDatei(typ);
      		}
       		else{
	   			moebelView.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			moebelView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			moebelView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
	
}
