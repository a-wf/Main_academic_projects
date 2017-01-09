
public abstract class Soigneur extends Personnage implements Heal  {
	protected int capa_soin;
	
	
	public Soigneur(String name){
		super(name);
		

	}
	

	
	public int getCapaSoin(){
		return this.capa_soin;
	}
	

	public void setCapaSoin(int p_soin){
		this.capa_soin = p_soin;
	}
	public String allInfo(){
		return nom+"("+this.getClass().getName()+ ")"+"\nvie : "+vie+"\npoint soin : "+capa_soin+"\n___\n";
	}
}
