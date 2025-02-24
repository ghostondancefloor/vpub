package org.example;

import java.util.Vector; 
import java.util.Enumeration;
/**
 * @author Pierre Le Fameux
 *
 */
public class Cave {
	public Vector<Boisson> rayons;

	public Cave(){
		this.rayons = new Vector<Boisson>();
	}

	public void add(Boisson b){
		this.rayons.add(b);
	}

	public Boisson take(String nom){
		Boisson retour = null;
		Enumeration e = this.rayons.elements ();
		while (e.hasMoreElements () && !((retour=(Boisson)e.nextElement()).nom.equalsIgnoreCase(nom))){}
		this.rayons.remove(retour);
		return retour;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String retour = new String();
		String eol = System.getProperty("line.separator"); 
		Enumeration e = this.rayons.elements ();
		retour = retour + "Cave : " + eol;
		while (e.hasMoreElements ()) {
			retour = retour + "\t" + e.nextElement().toString() + eol;
		}
		return retour;
	}
}
