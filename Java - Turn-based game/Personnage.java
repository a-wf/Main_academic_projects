import java.util.Random;


public abstract class Personnage implements Combat, Heal {
	protected String nom;
	protected int vie;
	protected int vie_initial;
	static final protected Random rand = new Random();
	public Personnage(){
		this.nom = "no_name_guy";
		
		do{
		this.vie = rand.nextInt(31);
		}while(this.vie == 0);
		this.vie_initial = this.vie;
	}
	
	public Personnage (String name){
		this();
		this.nom = name;
	}

	public int get_vie(){
		return this.vie;
		
	}
	public String get_nom(){
		return "#"+this.nom;
		
	}
	
	
	public void gain_vie(int point){
		this.vie = this.vie + point;
	}
	
	public void perd_vie(int point){
		this.vie = this.vie - point;
	}
	
	public String allInfo(){
		return "("+this.getClass().getName()+ ")"+nom+" vie : "+vie+"\n";
	}
	

}
