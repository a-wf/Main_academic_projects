
public class MoineRouge extends Paladin implements Combat, Heal{



	
	
	public MoineRouge(String name){
		
		super(name);
		int a = rand.nextInt(DegMAX/2);
		int s = rand.nextInt(SoinMAX/2);
		this.capa_soin = s;
		this.capa_atk = a;
	}

	
	public void fight(Personnage p[]) throws  action_taux_echec
	  {  
		int b = rand.nextInt(3);
		 if(b == 2 )
		      throw new action_taux_echec();
		    else
		    {
			
				
				for (int i = 0; i<p.length && i < 4; i++){
					if( (p[i].vie > 0)){
						
						p[i].perd_vie(this.capa_atk);
						if(p[i].vie < 0){
							p[i].vie = 0;
						}
					}
					
				}
				
					this.perd_vie(this.capa_soin);
					if(this.vie < 0){
						this.vie = 0;
					
				}
		    }
	}



	public void lifelight(Personnage[] p) throws  action_taux_echec
	  {  
		int b = rand.nextInt(3);
		 if(b == 2 )
		      throw new action_taux_echec();
		    else
		    {
			
					
					for (int i = 0; i<p.length && i < 4; i++){
						if((p[i].vie < p[i].vie_initial)&& (p[i].vie > 0)){
							
							p[i].gain_vie(this.capa_soin);
							
							if(p[i].vie > p[i].vie_initial){
								p[i].vie = p[i].vie_initial;
							}
							if(p[i].vie < 0){
								p[i].vie = 0;
							}
						}
					}
			
						this.perd_vie(this.capa_soin);
						if(this.vie < 0){
							this.vie = 0;
					
					}
		    }

	}
	
	public String allInfo(){
		return nom+"("+this.getClass().getName()+ ")"+"\nvie : "+vie+"\npoint atk : "+capa_atk+"\npoint soin : "+capa_soin+"\nNb de cible\npossible: 4"+"\n___\n";
	}

}
