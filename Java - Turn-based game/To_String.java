

import java.awt.TextArea;

import javax.swing.*;


public class To_String {
	private String [] data1 = new String[5];
	private JList<String> list1;
	
	public To_String(Joueur j1){

		for(int i = 0; i<5; i++){
			data1[i] = j1.deck[i].get_nom();
		}
		
		list1 = new JList<String> (data1);
		
	}
	
	
	public JList<String> get_list(){
		return this.list1;
	}
	
	public void nb_cibles_considérées(Personnage p, int taille, TextArea tx){
		if((p.getClass().getName().equals("Chevalier")||p.getClass().getName().equals("Infirmiere"))&&(taille)>1){
			tx.setText("Attention! Un chevalier ne peut avoir qu'un cible\nAinsi seulement la premiere cible selectionée a été prise en compte!!!\n");
		 }
		 if((p.getClass().getName().equals("Archer")||p.getClass().getName().equals("MageBlanc"))&&(taille)>3){
			 tx.setText("Attention! Un Archer ne peut avoir que trois cibles\nAinsi seulement les trois premieres cibles selectionées ont été prise en compte!!!\n");
		 }
		 if(p.getClass().getName().equals("MoineRouge")&&(taille)>4){
			 tx.setText("Attention! Un MoineRouge ne peut avoir que quatre cibles\nAinsi seulement les quatres premieres cibles selectionées ont été prises en compte!!!\n");
		 }
	}
}
