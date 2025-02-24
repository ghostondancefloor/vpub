package org.example;


/**
 * @author Pierre Le Fameux
 *
 */

public class Boisson {
	public String nom;
	public Boolean alcoolise;
	public Float degre;
	public Float volume; // volume de la bouteille, cennette, fut ...
	public Float prix;
	
	/**
	 * @param nom
	 */
	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = new Boolean(false);
	}
	
	/**
	 * @param nom
	 * @param degre
	 */
	public Boisson(String nom, Float degre){
		this.nom = nom;
		this.degre = degre;
		this.alcoolise = new Boolean(true);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String retour = this.nom;
		if(this.alcoolise){
			return retour + " (l'abus d'alcool est dangereux pour la sante)";
		}else{
			return retour;
		}
	}
}
