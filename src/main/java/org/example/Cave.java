package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Pierre Le Fameux
 */
public class Cave {
	public final List<Boisson> rayons;

	public Cave() {
		this.rayons = new ArrayList<>();
	}

	public void add(Boisson b) {
		this.rayons.add(b);
	}

	public Boisson take(String nom) {
		Iterator<Boisson> iterator = this.rayons.iterator();
		while (iterator.hasNext()) {
			Boisson boisson = iterator.next();
			if (boisson.getNom().equalsIgnoreCase(nom)) {
				iterator.remove();
				return boisson;
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder retour = new StringBuilder();
		String eol = System.lineSeparator();
		retour.append("Cave : ").append(eol);

		for (Boisson boisson : this.rayons) {
			retour.append("\t").append(boisson.toString()).append(eol);
		}

		return retour.toString();
	}
}
