package it.polito.tdp.parole;

import java.net.URL;
import java.util.*;

import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.Parole2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {
    Parole p = new Parole();
    Parole2 p2= new Parole2();
    private List <String > timeL = new LinkedList<String>();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;
    @FXML
    private TextArea txtTime;
    @FXML
    private Button btnCanella;
    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    private String getTimeString(long start, long end, char tipologia, char tipologia2) {
    	Long time= end-start;
    	String add ="";
    	String str="";
    	if(tipologia2=='L') {
    	if(tipologia=='I' )
    		add="Aggiunta parola tempo(Linked)="+ time;
    	if(tipologia=='C')
    		add= "Rimossa parola tempo(Linked)=" + time;
    	if(tipologia=='R')
    		add=" Rimosse tutte le parole tempo(Linked)=" + time;
    	}else {
    		if(tipologia=='I' )
        		add="Aggiunta parola tempo(Array)="+ time;
        	if(tipologia=='C')
        		add= "Rimossa parola tempo(Array)=" + time;
        	if(tipologia=='R')
        		add=" Rimosse tutte le parole tempo(Array)=" + time;
    	}
    		
    	timeL.add(add);
    	for(String s:timeL)
    		if(s!=null)
    			str+= s+"\n";
    	return str;
    }
    @FXML
    void doInsert(ActionEvent event) {
    	Long start = System.nanoTime();
         String parola = txtParola.getText();
         p.addParola(parola);
         txtResult.setText(p.getElencoString());
         Long end = System.nanoTime();
         String tempo=this.getTimeString(start, end, 'I', 'L');         
         txtTime.setText(tempo);
         
         start = System.nanoTime();
         String parola2= txtParola.getText();
         p2.addParola(parola2);
         txtResult.setText(p2.getElencoString());
         end = System.nanoTime();
         tempo=this.getTimeString(start, end, 'I', 'A');         
         txtTime.setText(tempo);
         
    }
    @FXML
    void handleCanella(ActionEvent event) {
    	Long start = System.nanoTime();
     String parola = txtResult.getSelectedText();
     if(p.isPresente(parola))
    	 p.remove(parola);
   
     Long end = System.nanoTime();
     String tempo=this.getTimeString(start, end, 'C', 'L');
     txtTime.setText(tempo);
     
     start = System.nanoTime();
     parola = txtResult.getSelectedText();
     if(p2.isPresente(parola))
    	 p2.remove(parola);
     end = System.nanoTime();
     tempo=this.getTimeString(start, end, 'C', 'A');
     txtTime.setText(tempo);
     
     txtResult.setText(p.getElencoString());
    }
    @FXML
    void doReset(ActionEvent event) {
    	Long start = System.nanoTime();
   p.reset();
   
   Long end = System.nanoTime();
   String tempo=this.getTimeString(start, end, 'R', 'L');
   txtTime.setText(tempo);
   
   start = System.nanoTime();
   p2.reset();
   
   end = System.nanoTime();
    tempo=this.getTimeString(start, end, 'R', 'A');
   txtTime.setText(tempo);
   
   txtResult.setText(p.getElencoString());
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
