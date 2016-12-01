package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bean.Corso;
import bean.Studente;

public class Dao {
	
	public List<Corso> getCorsi(Studente studente){
		Connection conn =DBConnect.getConnection();
		String query = "select * from corso, iscrizione where iscrizione.codins = corso.codins and matricola=?; ";
		PreparedStatement st ;
	
	try{ st= conn.prepareStatement(query);
	     st.setInt(1,studente.getMatricola());
	     List<Corso> corsi = new LinkedList<Corso>();
	     ResultSet res = st.executeQuery();
	     while(res.next()){
	    	 Corso c = new Corso(res.getString("codins"), res.getInt("crediti"), res.getString("nome"), res.getInt("pd"));
	    	 corsi.add(c);
	    	 conn.close();
	    	 return corsi;
	     }
	}catch(SQLException e ){
		e.printStackTrace();
	}
	return null;
		
	}
		

	public List<Studente> cerca(String inizialiCognome){
		Connection conn = DBConnect.getConnection();
		String query = "select * from studente where cognome like ?; ";
		PreparedStatement st ;
		
		try{
			st = conn.prepareStatement(query);
			List<Studente> stud = new LinkedList<Studente> ();
			st.setString(1, inizialiCognome + "%");		
			ResultSet res = st.executeQuery();
			while(res.next()){
				Studente s = new Studente (res.getInt("matricola"), res.getString("cognome"), res.getString("nome"), res.getString("cds"));
				stud.add(s);
				conn.close();
				return stud;
			}
		}catch (SQLException e ){
			e.printStackTrace();
		}
		return null;
	}

}
