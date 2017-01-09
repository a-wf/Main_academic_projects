

public class Archer extends Guerrier implements Combat {


	public Archer(String name){
		
		super(name);
		int a = rand.nextInt(DegMAX);
		this.capa_atk = a;
	}
	
	
	public void fight(Personnage[] p) throws  action_taux_echec
	  {  
		int b = rand.nextInt(3);
		 if(b == 2 )
		      throw new action_taux_echec();
		    else
		    {
			
				for (int i = 0; i<p.length && i < 3; i++){
					if((p[i].vie > 0)){ 
						
						p[i].perd_vie(this.capa_atk);
						
						if(p[i].vie < 0){
							p[i].vie = 0;
						}
					}
					
					
				}
		
			}
	  }


	public String allInfo(){
		return nom+"("+this.getClass().getName()+ ")"+"\nvie : "+vie+"\npoint atk : "+capa_atk+"\nNb de cible\npossible: 3"+"\n___\n";
	}

}
