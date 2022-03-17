/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.ResourceBundle;

//import it.polito.tdp.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Map<String,HashSet<String>> dizionario = new HashMap<String,HashSet<String>>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAlienWord;

    @FXML
    private TextArea txtTranslation;

    @FXML
    void handleClear(ActionEvent event) {
    	txtAlienWord.clear();
    	txtTranslation.clear();
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	//Sintassi regex non corretta
    	//il programma non funziona, chiedere ai professori
    	
    	/*
    	if(!txtAlienWord.getText().matches("([a-zA-Z])\\w+")) {
    		txtAlienWord.clear();
    		return;
    	}*/
    	
    	String s[] = txtAlienWord.getText().toLowerCase().split(" ");
    	
    	if(s.length>1) {
    		HashSet<String> ss = new HashSet<String>();
    		
    		if(dizionario.get(s[0])!=null) {
    			ss.addAll(dizionario.get(s[0]));
    		}
    	
    		ss.add(s[1]);
    		dizionario.put(s[0], ss);
    		txtTranslation.setText("Parola aliena aggiunta");
    	}
    	else {
    		if(dizionario.get(s[0])!=null) {
    			txtTranslation.clear();
    			for(String i: dizionario.get(s[0]))
    				txtTranslation.appendText(i+"\n");
    		}
    		else {
    			txtTranslation.setText("Parola aliena non trovata");
    		}
    	}
    	
    	txtAlienWord.clear();
    }

    @FXML
    void initialize() {
        assert txtAlienWord != null : "fx:id=\"txtAlienWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTranslation != null : "fx:id=\"txtTranslation\" was not injected: check your FXML file 'Scene.fxml'.";

        
        
    }

}

