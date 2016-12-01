package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import bean.Corso;
import bean.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {
	
	private Model model = new Model();
	
	public void setModel(Model model){
		this.model= model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCerca;

    @FXML
    private ComboBox<Studente> combo;

    @FXML
    private Button btnElenco;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCerca(ActionEvent event) {
    	String s = txtCognome.getText();
    	if(s.isEmpty()){
    		return;
    	}
    	for(int i = 0; i<s.length(); i++){
    		if(!Character.isLetter(s.charAt(i))){
    			return;
    		}
    	}
    	
    	List<Studente > studentiTrovati = model.cerca(s);
    	combo.getItems().addAll(studentiTrovati);

    }

    @FXML
    void doElenco(ActionEvent event) {
    	if(combo.getValue()!= null){
    	Studente s = combo.getValue();
    	List <Corso> corsiDelloStudente = model.getCorsi(s);
    	txtResult.appendText("I corsi dello studente sono : " +corsiDelloStudente.toString());
    	
    	}
    }

    @FXML
    void initialize() {
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Sample.fxml'.";
        assert combo != null : "fx:id=\"combo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnElenco != null : "fx:id=\"btnElenco\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
