package org.example;


/**
 * @author Pierre Le Fameux
 *
 */

public class Boisson {
	private final String nom;
	private final Boolean alcoolise;
	private final Float degre;
	
	/**
	 * @param nom name of the drink
	 */
	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = false;
		this.degre = 0.0f;
	}
	
	/**
	 * @param nom name of the drink
	 * @param degre degre of the drink
	 */
	public Boisson(String nom, Float degre){
		this.nom = nom;
		this.degre = degre;
		this.alcoolise = true;
	}

	public String getNom() {
		return nom;
	}

	public Boolean isAlcoolise() {
		return alcoolise;
	}

	public Float getDegre() {
		return degre;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String retour = this.nom;
		if(Boolean.TRUE.equals(this.alcoolise)){
			return retour + " (l'abus d'alcool est dangereux pour la sante)";
		}else{
			return retour;
		}
	}
}
