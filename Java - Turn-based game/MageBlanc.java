
public class MageBlanc extends Soigneur implements Heal{



	public MageBlanc(String name){
		
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
			
				for (int i = 0; i<p.length && i < 3; i++){
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
		    }

	}
	public String allInfo(){
		return nom+"("+this.getClass().getName()+ ")"+"\nvie : "+vie+"\npoint soin : "+capa_soin+"\nNb de cible\npossible: 3"+"\n___\n";
	}

}
