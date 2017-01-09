
public abstract class Paladin extends Personnage implements Combat, Heal {
	protected int capa_soin;
	protected int capa_atk;
	
	public Paladin(String name){
		super(name);

	}
	
	public int getCapaAtk(){
		return this.capa_atk;
	}
	
	public int getCapaSoin(){
		return this.capa_soin;
	}
	
	public void setCapaAtk(int p_atk){
		this.capa_atk = p_atk;
	}
	
	public void setCapaSoin(int p_soin){
		this.capa_soin = p_soin;
	}

	public String allInfo(){
			return nom+"("+this.getClass().getName()+ ")"+"\nvie : "+vie+"\npoint atk : "+capa_atk+"\npoint soin : "+capa_soin+"\n___\n";
		}


}
