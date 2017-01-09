
public class Infirmiere extends Soigneur implements Heal{



	public Infirmiere(String name){
		
		super(name);
		int s = rand.nextInt(SoinMAX);
		this.capa_soin = s;
	}


	public void lifelight(Personnage p[]) throws  action_taux_echec
	  {  
		int b = rand.nextInt(3);
		 if(b == 2 )
		      throw new action_taux_echec();
		    else
		    {
			
				if((p[0].vie < p[0].vie_initial)&& (p[0].vie > 0) ){ 
					
					p[0].gain_vie(this.capa_soin);
					
					if(p[0].vie > p[0].vie_initial){
						p[0].vie = p[0].vie_initial;
					}
					if(p[0].vie < 0){
						p[0].vie = 0;
					}
				}
		    }

	}
	
	public String allInfo(){
		return nom+"("+this.getClass().getName()+ ")"+"\nvie : "+vie+"\npoint soin : "+capa_soin+"\nNb de cible\npossible: 1"+"\n___\n";
	}
}
