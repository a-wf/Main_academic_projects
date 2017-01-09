
public class Joueur {
	protected Personnage deck[]; 
	
	
	public Joueur (){
		deck = new Personnage[5];
		deck[0] = new Chevalier("Flyer");
		deck[1] = new Archer("Oeildufacon");
		deck[2] = new MoineRouge("Sage");
		deck[3] = new MageBlanc("Bonhomme");
		deck[4] = new Infirmiere("Oreal");	
		
	}
	
	public Personnage[] getjouer(){
		
		return deck;
		
	}
	
}
