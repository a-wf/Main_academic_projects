// auteur: Alex WU FAN,    Spé: EI-SE3    Polytech'paris-UPMC







import java.util.Random;



public class Main {

	private static Joueur j1 = new Joueur();
	private static Joueur j2 = new Joueur();
	
	
	//avec fenetre 
	
	
	public static void main (String [] arg){  // ce main est utiliser seulement pour les decks de 5 cartes de chaque type de personnage. 
												//  A verifier pour plus de 5 cartes. 

		Random randm = new Random();
		int c = randm.nextInt(2);
		Fenetre fen_Duel = new Fenetre (j1, j2, c);
		
		System.out.println("Explication : Mode d'emploi");
		
		System.out.println("explication selon un plan de 8 figures,(noté F.1-F.8), voir en piece joint");
		
		System.out.println("#F.1 \nTout d'abord, sur la fenetre du jeu, il y a deux listes à gauche et à droite de la fenetre, que j'ai noté J1, et J2\n"
				+ "ces deux listes representent les personnages que les deux joueurs possedent, J1 pour les personnages du joueur1 et J2 pour les personnages du joueur2\n"
				+ "\n#F.2\nDurant le jeu, les joueurs pourront visualiser les informations concernant chaque personnage en cliquant sur les listes J1 et J2"
				+ "\nde plus, dans un premier temps, les joueurs durant chacun leur tour, devront choisir dans leur liste respectives j1 ou J2, un personnage qui sera désigné comme l'unique personnage qui réalisera une action durant le tour de jeu."
				+ "\n\n#F.3\nDans cet exemple, le jeu débute par joueur 2, mais ce ne sera pas toujours le cas, en effet, il y a une chance sur deux pour que l'un des deux joueurs commence en premier.\n"
				+ "\n#F.4\nle joueur 2 a choisi OeildeFacon du type <<Archer>>, ainsi il peut attaquer 3 personnages dans ce tour.\n"
				+ "On selectionne les cibles du joueur 2 dans les deux listes en bas du fenetre, nommées Cible1 pour les personnages du joueur1, et Cible2 pour ceux du joueur 2\n"
				+ "\n#F.5\nLe joueur 2 a choisi d'attaquer, ainsi il appuis sur le bouton <<combat>> (soigner sur <<soigne>>) si l'attaque a été réaliser, on remarque le message <<action reussi>>.\n"
				+ "\n#F.6\nLe joueur 1 choisi le sage de type<<MoineRouge>> il peut donc soit attaquer soit soigner 4 personnages,  remarquons qu'on peut cibler n'importe qui, soit ennemis soit alliés.\n"
				+ "En effet, ceci a été définie par l'auteur du programe(ie. moi, Alex WU FAN) \n"
				+ "on peut également changer cet originalité directement dans le code(voir les classes locals <<class EcouteurClickSoinSimple>> et <<class EcouteurClickSoinAttaq>>)\n"
				+ "\n#F.7\nDommage pour le joueur 1, son personnage Sage a raté ses cibles, ainsi son tour a été passé.\n"
				+ "\n#F.8\nAprès plusieur tours de jeu, le joueur 1 a finalement gagné le duel!"
				+ "\nEn effet, le jeu se termine, seulement quand un des joueurs ne possède plus d'attaquant avec des points de vie supérieur à 0, peu importe l'état des soigneurs");
	
	//___________END "avec fenetre" 
	
	
		
		
		// sans fenetre,  attention a ne pas utiliser en meme temps avec les instructions "avec fenetre" 
		// ce main est utiliser seulement pour les decks de 5 cartes de chaque type de personnage.
		//en mode sans fenetre,  il s'agit de deux joueur imaginaire(l'ordinateur) qui jouent entre eux.
		/*	
			int p;
			int bool1 = 0;
			int bool2 = 0;
			int b = 0;
			int c = 0;
			Personnage tab[];
			tab = new Personnage[4];
						
			
			Random randm = new Random();
			c = randm.nextInt(2);
			
			while (bool1 ==  0 && bool2 == 0){
				if(b == 0){
				System.out.println("=================BEGIN=================");
				System.out.println("joueur 1:");
				
				for(int i = 0; i<5; i++){
					System.out.println(j1.deck[i].allInfo());
				}
				System.out.println("================================================");
				System.out.println("joueur 2:");
				
				for(int i = 0; i<5; i++){
					System.out.println(j2.deck[i].allInfo());
				}
				System.out.println("================================================");
				
				b=1;
				
				}
				
				
					if(c>=1){
					for(int i = 0; i<5; i++){
						if(j1.deck[i].get_vie()<=0){
							continue;
						}
						System.out.println("================== Tour n."+c+": t joueur 1: ");
						if(i<3){
							System.out.println(j1.deck[i].get_nom() + "  fight : \n");
							for(int h = 0; h<=3;h++){
								p = randm.nextInt(5);
								tab[h]=j2.deck[p];
							}
							if(j1.deck[i].get_vie() > 0){
								j1.deck[i].fight(tab);
								for(int h = 0; h<=3; h++){
									if((j1.deck[i].getClass().getName() == "Chevalier"&&h>0)||(j2.deck[i].getClass().getName() == "Archer"&&h>2)){
										continue;
									}
									System.out.println("Cible : joueur2 "+tab[h].allInfo());
								}
							}
						}else{
							System.out.println(j1.deck[i].get_nom() + " heal : \n");
							for(int h = 0; h<=3;h++){
								p = randm.nextInt(5);
								tab[h]=j1.deck[p];
							}  
							if(j1.deck[i].get_vie() > 0){
								
								j1.deck[i].lifelight(tab);
								for(int h = 0; h<=3; h++){
									if((j1.deck[i].getClass().getName() == "InfirmiÃ¨re"&&h>0)||(j2.deck[i].getClass().getName() == "MageBlanc"&&h>2)){
										continue;
									}
									System.out.println("Cible : lui-meme "+tab[h].allInfo());
								}
							}
						}
					}
					
					c++;
					}
					System.out.println("================================================");
					
					if(c>=0){
					for(int i = 0; i<5; i++){
						if(j2.deck[i].get_vie()<=0){
							continue;
						}
						System.out.println("================== Tour n."+c+":  joueur 2: \n");
						if(i<3){
							System.out.println(j2.deck[i].get_nom() + "  fight : \n");
							for(int h = 0; h<=3;h++){
								p = randm.nextInt(5);
								tab[h]=j1.deck[p];
								
							}
							
							if(j2.deck[i].get_vie() > 0){
								j2.deck[i].fight(tab);
								for(int h = 0; h<=3; h++){
									if((j2.deck[i].getClass().getName() == "Chevalier"&&h>0)||(j2.deck[i].getClass().getName() == "Archer"&&h>2)){
										continue;
									}
									System.out.println("Cible : joueur1 "+tab[h].allInfo());
								}
							}
						}else{
							System.out.println(j2.deck[i].get_nom() + " heal : \n");
							for(int h = 0; h<=3;h++){
								p = randm.nextInt(5);
								tab[h]=j2.deck[p];
							}
							
							if(j2.deck[i].get_vie() > 0){
								j2.deck[i].lifelight(tab);
								
								for(int h = 0; h<=3; h++){
									if((j2.deck[i].getClass().getName() == "InfirmiÃ¨re"&&h>0)||(j2.deck[i].getClass().getName() == "MageBlanc"&&h>2)){
										continue;
									}
									System.out.println("Cible : lui-meme "+ tab[h].allInfo());
								}
							}
						}
					}
					c++;
					}
					
					
					
					
					System.out.println("================================================");
					System.out.println("joueur 1:");
					
					for(int i = 0; i<5; i++){
						System.out.println(j1.deck[i].allInfo());
					}
					System.out.println("================================================");
					System.out.println("joueur 2:");
					
					for(int i = 0; i<5; i++){
						System.out.println(j2.deck[i].allInfo());
					}
					System.out.println("================================================");
					
					
						if(j1.deck[0].get_vie() <= 0 && j1.deck[1].get_vie() <= 0 && j1.deck[2].get_vie() <= 0
								&& j1.deck[3].get_vie() <= 0 && j1.deck[4].get_vie() <= 0){
							bool1 = 1;
						}
						if(j2.deck[0].get_vie() <= 0 && j2.deck[1].get_vie() <= 0 && j2.deck[2].get_vie() <= 0
								&& j2.deck[3].get_vie() <= 0 && j2.deck[4].get_vie() <= 0){
							bool2 = 1;
						}
					
					
				}
			
			System.out.println("====================END====================");
			if(bool1 == 1 && bool2 == 0){
				System.out.println("\n\njoueur 2 a gagne!!!");
			}else if(bool1 == 0 && bool2 == 1){
				System.out.println("\n\njoueur 1 a gagne!!!");
			}else if(bool1 == 1 && bool2 == 1){
				System.out.println("\n\nmatch nul!!!");
			}
			
			
			
		*/	
			
		}
		
}
		
			
			
		

