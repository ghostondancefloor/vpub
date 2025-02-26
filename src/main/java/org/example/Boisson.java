package org.example;


/**
 * @author Pierre Le Fameux
 *
 */

public class Boisson {
	private final String nom;
	private final Boolean alcoolise;
	private final Float degre;
	private final Float volume; // volume de la bouteille, cennette, fut ...
	private final Float prix;
	
	/**
	 * @param nom name of the drink
	 */
	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = false;
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

	public Float getVolume() {
		return volume;
	}

	public Float getPrix() {
		return prix;
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
