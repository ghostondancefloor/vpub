package org.example;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Pierre Le Fameux
 */
public class Cocktail {

	// Inner static class for ingredients
	private static class Ingredient {
		private final String name;
		private final Double quantity;

		public Ingredient(String name, Double quantity) {
			this.name = name;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return name + " " + quantity + "%";
		}
	}

	private final String nom;
	private final List<Ingredient> ingredients;
	private final Boolean alcoolise;

	/**
	 * Creates a Cocktail with its name
	 * @param nom name of the cocktail
	 */
	public Cocktail(String nom) {
		this.nom = nom;
		this.ingredients = new ArrayList<>();
		this.alcoolise = false;
	}

	public String getNom(){
		return this.nom;
	}
	public Boolean getAlcoolise(){
		return this.alcoolise;
	}

	/**
	 * Adds a new ingredient into the Cocktail.
	 * @param ingredient Name of the ingredient.
	 * @param quantity Quantity of the ingredient.
	 */
	public void add(String ingredient, Double quantity) {
		this.ingredients.add(new Ingredient(ingredient, quantity));
	}

	/**
	 * Tests if the Cocktail is alcohol-free.
	 * @return true if the Cocktail is free of alcohol.
	 */
	public Boolean alcoolFree() {
		return !this.alcoolise;
	}

	/**
	 * Returns a string representation of the cocktail ingredients.
	 * @return Formatted ingredient list.
	 */
	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		for (Ingredient ingredient : this.ingredients) {
			retour.append(ingredient.toString()).append("\t");
		}
		return retour.toString();
	}
}
