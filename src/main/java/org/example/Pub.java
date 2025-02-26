package org.example;

import static java.lang.System.*;

/**
 * Virtual PUB
 */

public class Pub {

	
	private final Bar bar;
	private final Cave cave;
	
	/**
	 * 
	 */
	public Pub(){
		this.bar = new Bar();
		this.cave = new Cave();
	}
	
	public void approvisionnerBar(String nom){
		this.bar.add(this.cave.take(nom));
	}
	
	
	/**
	 * @param args main
	 */
	public static void main(String[] args) {
		/* Creation du pub */
		Pub pub = new Pub();

		Boisson coca = new Boisson("Coca");
		Boisson eau = new Boisson("Eau");
		Boisson sky = new Boisson("Whisky", 40.0f);
		Boisson bierre = new Boisson("Bierre", 8.0f);
		
		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(sky);
		pub.cave.add(sky);
		pub.cave.add(bierre);
		pub.cave.add(bierre);
		pub.cave.add(eau);
		
		out.println("Cave initiale :");
		out.println(pub.cave);

		pub.approvisionnerBar("bierre");
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("eau");
		
		Cocktail maz = new Cocktail("Mazout", true);
		maz.add("bierre",50.0);
		maz.add("coca", 50.0);
		pub.bar.add(maz);

		
		out.println(pub.cave);
		out.println(pub.bar);
		
		out.println("Boisson servie : " + pub.bar.serv("cafe"));
		out.println(pub.bar);
	}

}
