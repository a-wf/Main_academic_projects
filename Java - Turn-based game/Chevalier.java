

public class Chevalier extends Guerrier implements Combat {


	public Chevalier(String name){
		
		super(name);
		int a = rand.nextInt(DegMAX);
		this.capa_atk = a;
	}
	
	public void fight(Personnage p[]) throws  action_taux_echec
		  {  
			int b = rand.nextInt(3);
			 if(b ==2 )
			      throw new action_taux_echec();
			    else
			    {
		  
					if((p[0].vie>0)){  
						
						p[0].perd_vie(this.capa_atk);
						if(p[0].vie<0){
							p[0].vie = 0;
						}
					}
			    }
		  }
	

		public String allInfo(){
			return nom+"("+this.getClass().getName()+ ")"+"\nvie : "+vie+"\npoint atk : "+capa_atk+"\nNb de cible\npossible: 1"+"\n___\n";
		}
	
	
}
