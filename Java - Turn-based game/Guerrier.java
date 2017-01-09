
public abstract class Guerrier extends Personnage implements Combat {
	
	protected int capa_atk;
	
	public Guerrier(String name){
		super(name);
		
		
	}
	
	public int getCapaAtk(){
		return this.capa_atk;
	}
	

	public void setCapaAtk(int p_atk){
		this.capa_atk = p_atk;
	}
	
	public String allInfo(){
		return nom+"("+this.getClass().getName()+ ")"+"\nvie : "+vie+"\npoint atk : "+capa_atk+"\n___\n";
	}
}
