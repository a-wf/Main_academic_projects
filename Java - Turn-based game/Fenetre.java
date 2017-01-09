import javax.swing.*;
import javax.swing.event.*;

import java.util.List;
import java.awt.*;
import java.awt.event.*;



@SuppressWarnings("serial")  //pour supprimer le warning serial version UID....
public class Fenetre extends JFrame implements champ_text_Res{
	private int i = 0;
	private int nb_tour; 
	
	protected int bool;
	protected JButton attaque;
	protected JButton soigne;
	protected List<String> listCibleselect;
	protected Personnage acteur1;
	private Personnage acteur2;
	private Personnage [] cible1 = new Personnage[0];  //joueur 1 est cibler
	private Personnage [] cible2  = new Personnage[0];  //joueur 2 est cibler
	private String [] Scible;
	private Personnage [] cibles_t  = new Personnage[0]; //tous les cibles d'un joueur   max = 4
	protected To_String jlist1;
	protected To_String jlist2;	
	
	//ListSelectionModel listSelectionModel;
	
	public Fenetre (Joueur j1, Joueur j2, int b1) {
		
		
		
		 jlist1 = new To_String(j1);
		 jlist2 = new To_String(j2);		
		
		if(b1 == 0){
		this.bool = 1;
		}else if (b1 == 1){
			this.bool =2;
		}
		
		this.nb_tour = 1;
		
		
		this.setTitle("J1 VS J2! Duel!");
		this.setBounds(100,100,660,370);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		
		/*JMenuBar mbar = new JMenuBar();   // à ignorer, car pas demandé dans l'énoncé du TP
		JMenu men1 = new JMenu("Menu");
		JMenuItem m1 = new JMenuItem("Start");
		JMenuItem m2 = new JMenuItem("Give up");
		mbar.add(men1);
		men1.add(m1);
		men1.add(m2);
		this.setJMenuBar(mbar);*/
		
		
		
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		
		/*JPanel pan2_1 = new JPanel();
		JPanel pan3_1 = new JPanel();
		JPanel pan2_2 = new JPanel();
		JPanel pan3_2 = new JPanel();
		JPanel pan2_3 = new JPanel();
		JPanel pan3_3 = new JPanel();*/
		
		JPanel pan4 = new JPanel();
		JPanel pan4_2 = new JPanel();
		JPanel pan4_1 = new JPanel();
		
		JPanel pan5 = new JPanel();
		JPanel pan5_1 = new JPanel();
		JPanel pan5_2 = new JPanel();
		JPanel pan5_3 = new JPanel();
		JPanel pan5_4 = new JPanel();
		JPanel pan6_1 = new JPanel();
		JPanel pan6_2 = new JPanel();
		JPanel pan7 = new JPanel();
		
		JButton attaque = new JButton("Combat");
		JButton soigne = new JButton("Soigne");
		
		
		
		final TextArea text_bas1 = new TextArea(7, 15);
		To_String text_bas2 = new To_String(j1);
		To_String text_bas3 = new To_String(j2);
		final TextArea text_bas4 = new TextArea(7, 15);
		final TextArea text_vie1 = new TextArea(6, 7);
		final TextArea text_vie2 = new TextArea(6, 7);
		
		TextField text_tour = new TextField(12);
		
		text_tour.setText("Tour n°"+nb_tour+" : Joueur"+bool);
		
		
		JLabel label_1 = new JLabel(" Joueur 1"
				+ "                                                                                        |"
				+ "                                                                                      "
				+ "Joueur 2 ");
		JLabel label_7 = new JLabel("    Cibles 1 :                                         Cibles 2 :");
		JLabel label_7_ = new JLabel("                                     ");
		
		pan7.setLayout(new BorderLayout());
		
		

	    //Au nord
		pan7.add(label_7_, BorderLayout.NORTH);
		pan7.add(text_Res, BorderLayout.CENTER);
	    //Au sud
		pan7.add(label_7, BorderLayout.SOUTH);
		
		
		
		pan1.add(label_1);
		
		
		
		
		
		
		pan2.add(jlist1.get_list());
		
		pan3.add(jlist2.get_list());

		
		/*pan2_3.add(label_2);
		pan3_3.add(label_2);
				
		pan2_1.add(l1);
		
		pan3_1.add(l2);
		
		pan2_2.add(l1);
		
		pan3_2.add(l2);*/
		
		
	
		
		pan4.add(text_tour);
		pan4_1.add(attaque);
		pan4_2.add(soigne);
	
		
		
		pan5_1.add(text_bas1);
		pan5_2.add(text_bas2.get_list());
		pan6_1.add(text_vie1);
		pan6_2.add(text_vie2);
		pan5_3.add(text_bas3.get_list());
		pan5_4.add(text_bas4);
		
		
		pan5.add(pan5_1);
		pan5.add(pan6_1);
		pan5.add(pan5_2);
		pan5.add(pan6_2);
		pan5.add(pan5_3);
		pan5.add(pan5_4);
		

		/*
		JPanel content1 = new JPanel();
		content1.setLayout(new GridBagLayout());
		content1.setPreferredSize(new Dimension(100,100));
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridheight = 1;
	    gbc1.gridwidth = 1; 
		
	    gbc1.gridx = 0;
	    gbc1.gridy =1; 
	    content1.add(pan2_1, gbc1); 
	    
	    gbc1.gridx = 1;
	    gbc1.gridy = 1; 
	    content1.add(pan2_2, gbc1);
	    
	    
	    gbc1.gridx = 1;
	    gbc1.gridy = 0; 
	    content1.add(pan2_3, gbc1); 
	    */
	    
	    
	    JPanel content2 = new JPanel();
		content2.setLayout(new GridBagLayout());
		content2.setPreferredSize(new Dimension(1, 1));
		GridBagConstraints gbc2 = new GridBagConstraints();
	
		
		gbc2.gridx = 2;
		gbc2.gridy =0; 
		content2.add(pan4, gbc2); 
	    
	    gbc2.gridx = 1;
	    gbc2.gridy = 2; 
	    content2.add(pan4_1, gbc2);
	    
	    gbc2.gridx = 3;
	    gbc2.gridy = 2; 
	    content2.add(pan4_2, gbc2); 
	    
	    gbc2.gridx = 2;
	    gbc2.gridy = 3; 
	    content2.add( new JLabel("______________________________________"), gbc2);
	    gbc2.gridx = 1;
	    gbc2.gridy = 3; 
	    content2.add( new JLabel("_____________"), gbc2);
	    gbc2.gridx = 3;
	    gbc2.gridy = 3; 
	    content2.add( new JLabel("____________"), gbc2);
	
	    gbc2.gridx = 2;
	    gbc2.gridy = 4; 
	    content2.add(pan7, gbc2); 
	    	    
	    /*
	    JPanel content3 = new JPanel();
	    content3.setLayout(new GridBagLayout());
	    content3.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc3 = new GridBagConstraints();

		gbc3.gridx = 0;
		gbc3.gridy =1; 
		content3.add(pan3_1, gbc3); 
	    
		gbc3.gridx = 1;
		gbc3.gridy = 1; 
	    content3.add(pan3_2, gbc3);
	    
	    gbc3.gridx = 1;
	    gbc3.gridy = 0; 
	    content3.add(pan3_3, gbc3); 
	    
	    */
	    	
		JPanel prin_pan = new JPanel();
		
		prin_pan.setLayout(new BorderLayout());
		
		//Au centre
		prin_pan.add(content2, BorderLayout.CENTER);
	    //Au nord
		prin_pan.add(pan1, BorderLayout.NORTH);
	    //Au sud
		prin_pan.add(pan5, BorderLayout.SOUTH);

		
		//Ã€ l'ouestbibibi
		//prin_pan.add(content1, BorderLayout.WEST);
		//Ã€ l'est
		//prin_pan.add(content3, BorderLayout.EAST); 
		
	    //Ã€ l'ouest
		prin_pan.add(pan2, BorderLayout.WEST);
	    //Ã€ l'est
		prin_pan.add(pan3, BorderLayout.EAST); 
	
		//ne marche pas
		//m1.addMouseListener(new EcouteurStart(j1, j2,text_vie1, text_vie2, bool, nb_tour, text_tour,text_bas2, text_bas3 ));
		
		selectlist_joueur( jlist1,  text_bas1,  text_vie1,  text_vie2,  j1,  j1,  j2, 1 );
		selectlist_joueur( jlist2,  text_bas4,  text_vie1,  text_vie2,  j2,  j1,  j2, 2 );
	    
	    
		selectlist_cible(text_bas2, text_vie1, text_vie2, j1, j1, j2, 1);
		selectlist_cible(text_bas3, text_vie1, text_vie2, j2, j1, j2, 2);
	 
		//capable d'attaquer seulement ennemies 
		//attaque.addMouseListener(new EcouteurClickAttqSimple(j1, j2, text_vie1, text_vie2, bool)); 
		
		
		
		//capable d'attaquer ennemies et alliés
		attaque.addMouseListener(new EcouteurClickAttq(j1, j2, text_vie1, text_vie2, /*bool,*/ nb_tour, text_tour,text_bas2, text_bas3 , text_Res)); 
		
		
		//capable de soigner ennemeie et alliés
		soigne.addMouseListener(new EcouteurClickSoin(j1, j2, text_vie1, text_vie2, nb_tour, text_tour, text_bas2, text_bas3, text_Res)); 
		
		
		
		
		
		
	
		
	this.setContentPane(prin_pan);
		
		
		this.setVisible(true);
	
		
	}
	
	
	
	
	 protected void Bilan_vie(Joueur j1, Joueur j2, TextArea t1, TextArea t2 ){
			
			t1.setText("Joueur1:\n vie:  "+j1.deck[0].get_vie()+"\n vie:  "+j1.deck[1].get_vie()+"\n vie:  "+j1.deck[2].get_vie()
					+"\n vie:  "+j1.deck[3].get_vie()+"\n vie:  "+j1.deck[4].get_vie());//Refresh info1
			t2.setText("Joueur2:\n vie:  "+j2.deck[0].get_vie()+"\n vie:  "+j2.deck[1].get_vie()+"\n vie:  "+j2.deck[2].get_vie()+
					"\n vie:  "+j2.deck[3].get_vie()+"\n vie:  "+j2.deck[4].get_vie());//Refresh info2
			
		}
	 
	
	 
	 protected void selectlist_joueur( final To_String jlist, final TextArea tb, final TextArea t1, final TextArea t2, final Joueur j, final Joueur j1, final Joueur j2, final int b){
		 
		 jlist.get_list().addListSelectionListener(new ListSelectionListener(){
		    	public void valueChanged(ListSelectionEvent  e){
		    		i = 0;
		    		
		    		while(!j.deck[i].get_nom().equals((String)jlist.get_list().getSelectedValue())){
		    			i++;
		    		}
		    	//
			    		if(b == 1){
			    			acteur1 = j.deck[i];
			    			//text_Res.setText("joueur 1 : "+acteur1.get_nom()+"("+acteur1.getClass().getName()+")");
			    		} else if (b ==2){
			    			acteur2 = j.deck[i];
			    			//text_Res.setText("joueur 2 : "+acteur2.get_nom()+"("+acteur2.getClass().getName()+")");
			    		}
		    		
		    		
		    		tb.setText(j.deck[i].allInfo());
		    		
		    		
		    		Bilan_vie(j1, j2, t1, t2 );
		    		
		    	}
		    	
		    });
		
	 }
	 
	 protected void selectlist_cible(final To_String tb, final TextArea t1, final TextArea t2, final Joueur jp, final Joueur j1, final Joueur j2, final int b){
		 Scible = new String[0];
		 tb.get_list().addListSelectionListener(new ListSelectionListener() {
		        
	    	 public void valueChanged(ListSelectionEvent e)
		        {
		            if(!e.getValueIsAdjusting()) {
		            	listCibleselect = tb.get_list().getSelectedValuesList();
		                if(b == 1 && listCibleselect.size()!=0){
		                	text_Res.setText("joueur 1 est ciblé: "+listCibleselect);
			    		} else if (b ==2 && listCibleselect.size()!=0){
			    			text_Res.setText("joueur 2 est ciblé: "+listCibleselect);
			    		}
		                Scible = new String[listCibleselect.size()];
		                Scible =  listCibleselect.toArray(Scible);
		                if(b == 1){
		                	/*System.out.print(" scibles1 :");
		                	for(i = 0; i<Scible.length;i++){
			                	System.out.print(" "+Scible[i]);
			                }
		                	System.out.print("\n");*/
		                	cible1 = new Personnage[Scible.length];
			    		} else if (b ==2){
			    			
			    			/*for(i = 0; i<Scible.length;i++){
			                	System.out.print(" "+Scible[i]);
			                }
			    			System.out.print("\n");*/
			    			cible2 = new Personnage[Scible.length];
			    		}
		            }
		            
		           
		           	for(i = 0; i< Scible.length&&i<4; i++){
				        	   int j = 0;
				        	   while(!jp.deck[j].get_nom().equals(Scible[i])){
					    			j++;
				        	   }
				        	   if(b == 1 && cible1!=null){

					    			zero_cible(cible1);
					    			try{
				        		   cible1[i] = jp.deck[j];
					    			}catch(ArrayIndexOutOfBoundsException e1	){
					    			 continue;
					    			}
					    		} else if (b ==2&&cible2!= null){
					    			
					    			 zero_cible(cible2);
					    			try{
					    			cible2[i] = jp.deck[j];
					    			}catch(ArrayIndexOutOfBoundsException e1){
					    			continue;
					    			}
					    		}
				        	   
				     }/*
		            	 if(b == 1 && cible1!=null){
		            		 System.out.print(" cible1 :");
		 		         	for(i = 0; i<cible1.length;i++){
		 		             	System.out.print(" "+cible1[i].get_nom());
		 		             }
		 		         	System.out.print("\n");
		 			         
				    		} else if (b ==2 && cible2!=null){
				    			System.out.print(" cible2 :");
					         	for(i = 0; i<cible2.length;i++){
					             	System.out.print(" "+cible2[i].get_nom());
					             }
					         	System.out.print("\n");
						         
				    		}*/
		            
		           	
			         Bilan_vie(j1, j2, t1, t2 );
		        }
	    	 
	    	 
	    });   
		
		 
	 }
	 
	 
	 protected void zero_cible(Personnage [] c){
		 
		 if(c !=null){
		 c = null;
		 }
	 }
	 
	 
	 protected Personnage [] cible_total_joueur(Personnage [] c1, Personnage [] c2, Personnage [] ct){
		 zero_cible(ct);
		 
		 /*
		 System.out.print(" cible1 :");
       	for(i = 0; i<cible1.length;i++){
           	System.out.print(" "+cible1[i].get_nom());
           }
       	System.out.print("\n");
       	
       	
       	System.out.print(" cible2 :");
      	for(i = 0; i<cible2.length;i++){
          	System.out.print(" "+cible2[i].get_nom());
          }
      	System.out.print("\n");*/
      	
      	i = 0;
		 for(i= 0; i <c1.length&&i<4; i++){
			 ct[i] = c1[i];
		 }
		 if(i<3 && c2.length!= 0){
			
			 for(int n=0;n<c2.length&&n<4-i; n++){
				 ct[i+n] = c2[n];
			 }
	 	}
		 zero_cible(c1);
		 zero_cible(c2);
		 return ct;
	 }
	 
	 
	class EcouteurClickAttq extends MouseAdapter{  
		Joueur j_1;
		Joueur j_2;
		TextArea tt1;
		TextArea tt2;
		//int b;
		int nb_t;
		TextField tx;
		To_String tb1;
		To_String tb2;
		TextArea tr;
				public EcouteurClickAttq (Joueur j_1, Joueur j_2, TextArea tt1, TextArea tt2, /*int b,*/ int nb_t, TextField tx, To_String tb1, To_String tb2, TextArea tr){
					this.j_1 = j_1;
					this.j_2 = j_2;
					this.tt1 = tt1;
					this.tt2 = tt2;
					//this.b = b;
					this.nb_t = nb_t;
					this.tx = tx;
					this.tb1= tb1;
					this.tb2 = tb2;
					this.tr = tr;
				}
				public void mouseClicked(MouseEvent e){
					//System.out.print(" ciblettt :");
					
					int taille = cible1.length+cible2.length;
					if(cible1!=null && cible2!=null){
						
						 
						 
						if(cible1.length+cible2.length >=4){
							cibles_t = new Personnage[4];
						}else{
							cibles_t = new Personnage[cible1.length+cible2.length];
						}
					
					cible_total_joueur(cible1, cible2,cibles_t);
					}
					
					/*
 		         	for(i = 0; i<cibles_t.length;i++){
 		             	System.out.print(" "+cibles_t[i].get_nom());
 		             }
 		         	System.out.print("\n");
 			         */
					if(cibles_t!=null ){
						if(/*this.b*/bool%2!=0){
							try{
								if(acteur1.get_vie() > 0){
									 try {
										 acteur1.fight(cibles_t);
										 text_Res.setText("                                 Action reussi!");
										 tb1.nb_cibles_considérées(acteur1, taille, tr);
										
									 }catch(action_taux_echec e2){
									 } catch (Error e1) {
										 text_Res.setText("Attention! Le personnage choisi ne peut pas attaquer!!!\n");
										 bool--;
										 nb_tour--;
									 }
									tb1.get_list().clearSelection();
									tb2.get_list().clearSelection();
									//jlist1.get_list().clearSelection();
								}else{
					    			text_Res.setText("Votre personnage choisi est mort, rechoissisez\n");
					    			bool--;
									nb_tour--;
					    			
					    		}
							}catch(NullPointerException e1){
								 text_Res.setText("Attention! Joueur1 n'a pas choisi de personnage qui attaquera durant ce tour!!!\n");
								 bool--;
								 nb_tour--;
							}
						}else if(bool%2== 0){
					
							try{
								if(acteur2.get_vie() > 0){
									
									 try {
										 
										 acteur2.fight(cibles_t);
										 text_Res.setText("                                 Action reussi!");
										 tb2.nb_cibles_considérées(acteur2, taille, tr);
										
									 }catch(action_taux_echec e2){
									 } catch (Error e1) {
										 text_Res.setText("Attention! Le personnage choisi ne peut pas attaquer!!!\n");
										 bool--;
										 nb_tour--;
									 }
									tb1.get_list().clearSelection();
									tb2.get_list().clearSelection();
									//jlist2.get_list().clearSelection();
								}else{
					    			text_Res.setText("Votre personnage choisi est mort, rechoissisez\n");
					    			bool--;
									nb_tour--;
					    			
					    		}
							}catch(NullPointerException e1){
								 text_Res.setText("Attention! Joueur2 n'a pas choisi de personnage qui attaquera durant ce tour!!!\n");
								 bool--;
								 nb_tour--;
							}
						}
					}
					
					if(bool%2 != 0  ){
						nb_tour++;
						tx.setText("Tour n°"+nb_tour+" : Joueur 2");
		           		/*this.b++;*/
						bool++;
		           		
		    		} else if (bool%2 == 0){
		    			nb_tour++;
		    			tx.setText("Tour n°"+nb_tour+" : Joueur 1");
		    			bool++;
		    			
		    		}
					
					gagnant tmp = new gagnant(j_1, j_2);
					if(!tmp.Resulat().equals("")){
						tx.setText(tmp.Resulat());
					}
					 
					 Bilan_vie(this.j_1, this.j_2, this.tt1, this.tt2 );
					 zero_cible(cibles_t);
					}
				
				
			}
		 
/*class EcouteurClickAttqSimple extends MouseAdapter{  //attaque seulement ennemie possible
		Joueur j_1;
		Joueur j_2;
		TextArea tt1;
		TextArea tt2;
		
		int nb_t;
		TextField tx;
		To_String tb1;
		To_String tb2;
		TextArea tr;		
				public EcouteurClickAttqSimple (Joueur j_1, Joueur j_2, TextArea tt1, TextArea tt2,  int nb_t, TextField tx,To_String tb1, To_String tb2, TextArea tr){
					this.j_1 = j_1;
					this.j_2 = j_2;
					this.tt1 = tt1;
					this.tt2 = tt2;
					
					this.nb_t = nb_t;
					this.tx = tx;
					this.tb1= tb1;
					this.tb2 = tb2;
					this.tr = tr;
					}
				public void mouseClicked(MouseEvent e){
					
						if(bool%2!=0 && cible2 !=null){
						try{
							if(acteur1.get_vie() > 0){
							try {
								acteur1.fight(cible2);
								text_Res.setText("                                 Action reussi!");
								tb1.nb_cibles_considérées(acteur1, cible2.length, tr);
								 
									 }catch(action_taux_echec e2){
								 } catch (Error e1) {
									 text_Res.setText("Attention! Le personnage choisi ne peut pas attaquer!!!\n");
									 bool--;
									 nb_tour--;
								 }
								tb1.get_list().clearSelection();
								tb2.get_list().clearSelection();
								 zero_cible(cible2);
							}else{
					    			text_Res.setText("Votre personnage choisi est mort, rechoissisez\n");
					    			bool--;
									nb_tour--;
					    			
					    		}
							}catch(NullPointerException e1){
								 text_Res.setText("Attention! Joueur1 n'a pas choisi de personnage qui attaquera durant ce tour!!!\n");
								 bool--;
								 nb_tour--;
							}
						}else if(bool%2 == 0&& cible1 !=null){
						try{
							if(acteur2.get_vie() > 0){
							try {
								acteur2.fight(cible1);
								text_Res.setText("                                 Action reussi!");
								tb2.nb_cibles_considérées(acteur2, cible1.length, tr);
								 
									 }catch(action_taux_echec e2){
								 } catch (Error e1) {
									 text_Res.setText("Attention! Le personnage choisi ne peut pas attaquer!!!\n");
									 bool--;
									 nb_tour--;
								 }
								tb1.get_list().clearSelection();
								tb2.get_list().clearSelection();
								 zero_cible(cible1);
							}else{
					    			text_Res.setText("Votre personnage choisi est mort, rechoissisez\n");
					    			bool--;
									nb_tour--;
					    			
					    		}
							}catch(NullPointerException e1){
								 text_Res.setText("Attention! Joueur2 n'a pas choisi de personnage qui attaquera durant ce tour!!!\n");
								 bool--;
								 nb_tour--;
							}
						}
					
					
					if(bool%2 != 0  ){
						nb_tour++;
						tx.setText("Tour n°"+nb_tour+" : Joueur 2");
		           		bool++;
		           		
		    		} else if (bool%2 == 0){
		    			nb_tour++;
		    			tx.setText("Tour n°"+nb_tour+" : Joueur 1");
		    			bool++;
		    			
		    		}
		    		
		    		gagnant tmp = new gagnant(j_1, j_2);
					if(!tmp.Resulat().equals("")){
						tx.setText(tmp.Resulat());
					}
					
					 Bilan_vie(this.j_1, this.j_2, this.tt1, this.tt2 );
					
					}
				
				
			}*/
	
	
	class EcouteurClickSoin extends MouseAdapter{  
		Joueur j_1;
		Joueur j_2;
		TextArea tt1;
		TextArea tt2;
		//int b;
		int nb_t;
		TextField tx;
		To_String tb1;
		To_String tb2;
		TextArea tr;
				public EcouteurClickSoin(Joueur j_1, Joueur j_2, TextArea tt1, TextArea tt2, /*int b,*/ int nb_t, TextField tx,To_String tb1, To_String tb2, TextArea tr){
					this.j_1 = j_1;
					this.j_2 = j_2;
					this.tt1 = tt1;
					this.tt2 = tt2;
					//this.b = b;
					this.nb_t = nb_t;
					this.tx = tx;
					this.tb1= tb1;
					this.tb2 = tb2;
					this.tr = tr;
				}
				public void mouseClicked(MouseEvent e){
					//System.out.print(" ciblettt :");
					int taille = cible1.length+cible2.length; 
					if(cible1!=null && cible2!=null){
						
						
						if(cible1.length+cible2.length >=4){
							cibles_t = new Personnage[4];
						}else{
							cibles_t = new Personnage[cible1.length+cible2.length];
						}
					
					cible_total_joueur(cible1, cible2,cibles_t);
					}
					
					/*
 		         	for(i = 0; i<cibles_t.length;i++){
 		             	System.out.print(" "+cibles_t[i].get_nom());
 		             }
 		         	System.out.print("\n");
 			         */
					if(cibles_t!=null ){
						if(/*this.b*/bool%2!=0){
							try{
								if(acteur1.get_vie() > 0){
									try {
										
										acteur1.lifelight(cibles_t);
										text_Res.setText("                                 Action reussi!");
										tb1.nb_cibles_considérées(acteur1, taille, tr);
										 
									 }catch(action_taux_echec e2){
										
									}catch (Error e1) {
										 text_Res.setText("Attention! Le personnage choisi ne peut pas soigner!!!\n");
										 bool--;
										 nb_tour--;
									 }
									tb1.get_list().clearSelection();
									tb2.get_list().clearSelection();
						
								}else{
					    			text_Res.setText("Votre personnage choisi est mort, rechoissisez\n");
					    			bool--;
									nb_tour--;
					    			
					    		}
							}catch(NullPointerException e1){
								 text_Res.setText("Attention! Joueur1 n'a pas choisi de personnage qui soignera durant ce tour!!!\n");
								 bool--;
								 nb_tour--;
							}
						}else if(bool%2 == 0){
							try{
								if(acteur2.get_vie() > 0){						
									try {
									acteur2.lifelight(cibles_t);
									text_Res.setText("                                 Action reussi!");
									tb2.nb_cibles_considérées(acteur2, taille, tr);
									 
									 }catch(action_taux_echec e2){
									} catch (Error e1) {
										 text_Res.setText("Attention! Le personnage choisi ne peut pas soigner!!!\n");
										 bool--;
										 nb_tour--;
									 }
									tb1.get_list().clearSelection();
									tb2.get_list().clearSelection();
								}else{
					    			text_Res.setText("Votre personnage choisi est mort, rechoissisez\n");
					    			bool--;
									nb_tour--;
					    			
					    		}
							}catch(NullPointerException e1){
								 text_Res.setText("Attention! Joueur2 n'a pas choisi de personnage qui soignera durant ce tour!!!\n");
								 bool--;
								 nb_tour--;
							}
						}
					}
					
					
					if(/*this.b*/bool%2 != 0  ){
						nb_tour++;
						tx.setText("Tour n°"+nb_tour+" : Joueur 2");
		           		/*this.b*/bool++;
		           		
		    		} else if (bool%2 == 0){
		    			nb_tour++;
		    			tx.setText("Tour n°"+nb_tour+" : Joueur 1");
		    			bool++;
		    			
		    		}
					
					
					gagnant tmp = new gagnant(j_1, j_2);
					if(!tmp.Resulat().equals("")){
						tx.setText(tmp.Resulat());
					}
					
					 Bilan_vie(this.j_1, this.j_2, this.tt1, this.tt2 );
					 zero_cible(cibles_t);
					}
				
				
			}
	 
	/*class EcouteurClickSoinSimple extends MouseAdapter{  //soingne seulement ennemie possible
	Joueur j_1;
	Joueur j_2;
	TextArea tt1;
	TextArea tt2;
	
	int nb_t;
	TextField tx;		
	To_String tb1;
	To_String tb2;
	TextArea tr;
			public EcouteurClickSoinSimple (Joueur j_1, Joueur j_2, TextArea tt1, TextArea tt2,  int nb_t, TextField tx,To_String tb1, To_String tb2, TextArea tr){
				this.j_1 = j_1;
				this.j_2 = j_2;
				this.tt1 = tt1;
				this.tt2 = tt2;
				
				this.nb_t = nb_t;
				this.tx = tx;
				this.tb1= tb1;
					this.tb2 = tb2;
					this.tr = tr;
			}
			public void mouseClicked(MouseEvent e){
				
					if(bool%2!=0 && cible2 !=null){
					try{
						if(acteur1.get_vie() > 0){
						try {
							acteur1.lifelight(cible2);
							text_Res.setText("                                 Action reussi!");
							tb1.nb_cibles_considérées(acteur1, cible2.length, tr);
							 
									 }catch(action_taux_echec e2){
							} catch (Error e1) {
									 text_Res.setText("Attention! Le personnage choisi ne peut pas soigner!!!\n");
									 bool--;
									 nb_tour--;
								 }
							tb1.get_list().clearSelection();
								tb2.get_list().clearSelection();
							 zero_cible(cible2);
						}else{
					    			text_Res.setText("Votre personnage choisi est mort, rechoissisez\n");
					    			bool--;
									nb_tour--;
					    			
					    		}
						}catch(NullPointerException e1){
								 text_Res.setText("Attention! Joueur1 n'a pas choisi de personnage qui soignera durant ce tour!!!\n");
								 bool--;
								 nb_tour--;
							}
					}else if(bool%2==0&& cible1 !=null){
					try{
						if(acteur2.get_vie() > 0){
						try {
							acteur2.lifelight(cible1);
							text_Res.setText("                                 Action reussi!");
							tb2.nb_cibles_considérées(acteur2, cible1.length, tr);
							 
									 }catch(action_taux_echec e2){
							} catch (Error e1) {
									 text_Res.setText("Attention! Le personnage choisi ne peut pas soigner!!!\n");
									 bool--;
									 nb_tour--;
								 }
							tb1.get_list().clearSelection();
								tb2.get_list().clearSelection();
							 zero_cible(cible1);
						}else{
					    			text_Res.setText("Votre personnage choisi est mort, rechoissisez\n");
					    			bool--;
									nb_tour--;
					    			
					    		}
						}catch(NullPointerException e1){
								 text_Res.setText("Attention! Joueur2 n'a pas choisi de personnage qui soignera durant ce tour!!!\n");
								 bool--;
								 nb_tour--;
							}
					}
				
				
					if(bool%2 != 0  ){
						nb_tour++;
						tx.setText("Tour n°"+nb_tour+" : Joueur 2");
		           		bool++;
		           		
		    		} else if (bool%2 == 0){
		    			nb_tour++;
		    			tx.setText("Tour n°"+nb_tour+" : Joueur 1");
		    			bool++;
		    			
		    		}
				 Bilan_vie(this.j_1, this.j_2, this.tt1, this.tt2 );
				
				}
			
			
		}*/
	
		
	
	
	
	class gagnant {
		Joueur j1;
		Joueur j2;
		public gagnant(Joueur j1, Joueur j2){
			this.j1 = j1;
			this.j2=j2;
		}
		
		public String Resulat(){
			int i1;
			int cmpt1 = 0;
			int cmpt2 = 0;
			for (i1=0; i1< this.j1.deck.length; i1++){
				
				if(j1.deck[i1].get_vie() <=0 && (j1.deck[i1].getClass().getName().equals("Archer")|| j1.deck[i1].getClass().getName().equals("MoineRouge")|| j1.deck[i1].getClass().getName().equals("Chevalier"))){
					cmpt1++;
				}
			}
			
			for (i1=0; i1< this.j2.deck.length; i1++){
				
				if(j2.deck[i1].get_vie() <=0 && (j2.deck[i1].getClass().getName().equals("Archer")|| j2.deck[i1].getClass().getName().equals("MoineRouge")||j2.deck[i1].getClass().getName().equals("Chevalier"))){
					cmpt2++;
				}
			}
			
			if(cmpt1 == 3 && cmpt2 <3 ){
				return "Joueur 2 a gagné!";
			}else if(cmpt2 == 3 && cmpt1 < 3){
				return "Joueur 1 a gagné!";
			}else if(cmpt1 == 3 && cmpt2 == 3){
				return "Egalité!";
			}
			
			return "";
		}
	}
	
	
	

	


}	

