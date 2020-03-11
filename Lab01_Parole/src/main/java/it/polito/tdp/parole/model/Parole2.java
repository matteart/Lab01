package it.polito.tdp.parole.model;

import java.util.*;

public class Parole2 {
		private List <String> parole = new ArrayList <String>();
		
	public Parole2() {
		
	}
	
	public void addParola(String p) {
		
		parole.add(p);
	}
	public Boolean isPresente(String p) {
		List<String> tempL = new ArrayList <String>(this.getElenco());
		for(String s:tempL)
			if(s!=null && s.contentEquals(p))
				return true;
		
		return false;
	}
	public void remove(String p) {
		parole.remove(p);
	}
	public List<String> getElenco() {
	    List <String>tempL= new ArrayList<String>(parole);
	    Collections.sort(tempL);
	    
		return tempL;
	}
	public String getElencoString() {
		List<String> tempL = new ArrayList <String>(this.getElenco());
		String str= "";
		for(String   s: tempL)
			if(s!=null )
				str += s+"\n";
		return str;
	}
	public void reset() {
		parole.clear();
		
	}

}
