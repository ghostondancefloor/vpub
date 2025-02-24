package org.example;

/**
 * Virtual PUB
 */

public class Pub {

	
	public Bar bar;
	public Cave cave;
	
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
	 * @param args
	 */
	public static void main(String[] args) {
		/* Creation du pub */
		Pub pub = new Pub();

		Boisson coca = new Boisson("Coca");
		Boisson eau = new Boisson("Eau");
		Boisson sky = new Boisson("Whisky", new Float(40));
		Boisson bierre = new Boisson("Bierre", new Float(8));
		
		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(sky);
		pub.cave.add(sky);
		pub.cave.add(bierre);
		pub.cave.add(bierre);
		pub.cave.add(eau);
		
		System.out.println("Cave initiale :");
		System.out.println(pub.cave);

		pub.approvisionnerBar("bierre");
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("eau");
		
		Cocktail maz = new Cocktail("Mazout");
		maz.add("bierre", new Double(50));
		maz.add("coca", new Double(50));
		pub.bar.add(maz);
		
		Boisson cafe = new Boisson("cafe");
		pub.bar.boissonChaude.add(cafe);
		
		System.out.println(pub.cave);
		System.out.println(pub.bar);
		
		System.out.println("Boisson servie : " + pub.bar.serv("cafe"));
		System.out.println(pub.bar);
	}

}
