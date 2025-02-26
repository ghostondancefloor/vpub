package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Le Fameux
 */
public class Bar {
	private final List<Boisson> boissonFroide;
	private final List<Boisson> boissonAlcoolisee;
	private final List<Cocktail> cocktailSansAlcoole;
	private final List<Cocktail> cocktailAvecAlcoole;

	/**
	 * Constructor initializes all beverage lists.
	 */
	public Bar() {
		this.boissonFroide = new ArrayList<>();
		this.boissonAlcoolisee = new ArrayList<>();
		this.cocktailAvecAlcoole = new ArrayList<>();
		this.cocktailSansAlcoole = new ArrayList<>();
	}


	/**
	 * Adds a drink to the corresponding category.
	 *
	 * @param boisson The drink to add.
	 */
	public void add(Boisson boisson) {
		if (Boolean.TRUE.equals(boisson.isAlcoolise())) {
			this.boissonAlcoolisee.add(boisson);
		} else {
			this.boissonFroide.add(boisson);
		}
	}

	/**
	 * Adds a cocktail to the corresponding category.
	 *
	 * @param cocktail The cocktail to add.
	 */
	public void add(Cocktail cocktail) {
		if (Boolean.TRUE.equals(cocktail.alcoolFree())) {
			this.cocktailSansAlcoole.add(cocktail);
		} else {
			this.cocktailAvecAlcoole.add(cocktail);
		}
	}

	/**
	 * Serves a drink or cocktail based on the name.
	 *
	 * @param command The name of the drink or cocktail to serve.
	 * @return The served drink/cocktail or null if not found.
	 */
	public Object serv(String command) {
		for (Boisson boisson : this.boissonFroide) {
			if (boisson.getNom().equalsIgnoreCase(command)) {
				this.boissonFroide.remove(boisson);
				return boisson;
			}
		}

		for (Boisson boisson : this.boissonAlcoolisee) {
			if (boisson.getNom().equalsIgnoreCase(command)) {
				this.boissonAlcoolisee.remove(boisson);
				return boisson;
			}
		}

		for (Cocktail cocktail : this.cocktailSansAlcoole) {
			if (cocktail.getNom().equalsIgnoreCase(command)) {
				this.cocktailSansAlcoole.remove(cocktail);
				return cocktail;
			}
		}

		for (Cocktail cocktail : this.cocktailAvecAlcoole) {
			if (cocktail.getNom().equalsIgnoreCase(command)) {
				this.cocktailAvecAlcoole.remove(cocktail);
				return cocktail;
			}
		}

		return null;
	}

	/**
	 * Returns a string representation of the bar and its available drinks.
	 *
	 * @return A formatted string containing all available drinks and cocktails.
	 */
	public String toString() {
		StringBuilder retour = new StringBuilder();
		String eol = System.lineSeparator();

		retour.append("Bar:").append(eol);
		retour.append("\t Sans alcool").append(eol);
		for (Boisson boisson : this.boissonFroide) {
			retour.append("\t\t").append(boisson.toString()).append(eol);
		}

		retour.append("\t Avec alcool").append(eol);
		for (Boisson boisson : this.boissonAlcoolisee) {
			retour.append("\t\t").append(boisson.toString()).append(eol);
		}

		retour.append("\t Cocktail sans alcool").append(eol);
		for (Cocktail cocktail : this.cocktailSansAlcoole) {
			retour.append("\t\t").append(cocktail.toString()).append(eol);
		}

		retour.append("\t Cocktail avec alcool").append(eol);
		for (Cocktail cocktail : this.cocktailAvecAlcoole) {
			retour.append("\t\t").append(cocktail.toString()).append(eol);
		}


		return retour.toString();
	}


	public List<Boisson> getBoissonFroide() {
		return this.boissonFroide;
	}

	public List<Boisson> getBoissonAlcoolisee() {
		return this.boissonAlcoolisee;
	}

	public List<Cocktail> getCocktailSansAlcool() {
		return this.cocktailSansAlcoole;
	}

	public List<Cocktail> getCocktailAvecAlcool() {
		return this.cocktailAvecAlcoole;
	}
}
