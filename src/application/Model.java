package application;

import java.util.LinkedList;
import java.util.List;

import bean.Corso;
import bean.Studente;
import db.Dao;

public class Model {
	
	Dao dao = new Dao();

	public List<Corso> getCorsi(Studente s ){
		List<Corso> corsi = new LinkedList<Corso>();
		corsi = dao.getCorsi(s);
		return corsi;
	}
	
	public List<Studente> cerca(String iniziali){
		List<Studente> studenti = dao.cerca(iniziali);
		return studenti;
	}
}
