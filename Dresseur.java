package pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dresseur {
	private 
	String nom;
	int niveau; //chaque fois le dresseur gagne en ajoute +1 a ce niveau
	ArrayList<Pokemon> pokemons =new ArrayList<>();
	ArrayList<Evolution> evolution=new ArrayList<>();
	ArrayList<String> evolution1=new ArrayList<>();//list evolution pokemon 1
	ArrayList<String> evolution2=new ArrayList<>();//list evolution pokemon 2
	ArrayList<String> evolution3=new ArrayList<>();//list evolution pokemon 3
	HashMap<String ,Integer> bonbon=new HashMap<>();//gagne +2 equiveau +1 perdu+0

	public Dresseur(String nom, int niveau) {
		super();
		this.nom = nom;
		this.niveau = niveau;
	}

	public HashMap<String, Integer> getBonbon() {
		return bonbon;
	}

	public void setBonbon(HashMap<String, Integer> bonbon) {
		this.bonbon = bonbon;
	}

	public String getNom() {
		return nom;
	}

	public int getNiveau() {
		return niveau;
	}

	public ArrayList<Pokemon> getPokemons() { //les pokemons de adresseur 
		return pokemons;
	}
	
	public void SupprimerPokemon(Pokemon p) {
		pokemons.remove(p);
	}
	public void AjouterPokemon(Pokemon p) {
		pokemons.add(p);
	}
	public void AugmenterNiveau() {
		niveau+=1;
	}
	public void lootBox() {
		Random r =new Random();
		//chaque drisseur peut avoir seulement 3 pokemon
		int poke1=r.nextInt(0,10);
		int poke2=r.nextInt(0,10);
		int poke3=r.nextInt(0,10);
	    //les pc et les pv aleatoire
		int pcPoke1=r.nextInt(1,6);
	    float pvPoke1=r.nextFloat(1,6);
	    int pcPoke2=r.nextInt(1,6);
	    float pvPoke2=r.nextFloat(1,6);
	    int pcPoke3=r.nextInt(1,6);
	    float pvPoke3=r.nextFloat(1,6);
		String path="Liste Pokemon csv.csv";
		String line="";
		BufferedReader fi = null;
		  try {
	            fi = new BufferedReader(new FileReader(path));

	            int ligneCourante = 0;

	            while (ligneCourante < 10) {
	                 line = fi.readLine();

	                if (line == null) {
	                    // Si la ligne est null, nous avons atteint la fin du fichier
	                    break;
	                }
	                if (ligneCourante == poke1) {
	                        String[] ligne = line.split(";");
	                        String nomPoke1=ligne[0];
	                        String evolution1Poke1 = ligne[1];
	                        String evolution2Poke1 = ligne[2];
	                        String Type1Poke1 =ligne[3];
	                        String Type2Poke1=ligne[4];
	                        bonbon.put(nomPoke1,1);
	                       // System.out.println("nom: "+nomPoke1+" evolution1: " + evolution1Poke1+" evolution2: " + evolution2Poke1+" Type1: "+Type1Poke1+" Type2: " + Type2Poke1);
	                    Pokemon pokemon1=new Pokemon(nomPoke1,Type1Poke1,pcPoke1,pvPoke1,evolution1);//pokemon 1 de dresseur avec une list vide des evolutions 
	                    pokemons.add(pokemon1);
	                    if (evolution2Poke1.equals("none")) {
	                    Evolution evpok1 =new Evolution(evolution1Poke1);//list des evolution possible pour pokemon1 non affecter a le pokemon 1 seulement pour memoriser 
	                    evolution.add(evpok1);
	                    }
	                    else {
	                    	Evolution evpok1=new Evolution(evolution1Poke1,evolution2Poke1);
	                    	evolution.add(evpok1);
	                    }
	                  
	                }
	                if (ligneCourante == poke2) {
	                    String[] ligne = line.split(";");
	                        String nomPoke2=ligne[0];
	                        String evolution1Poke2 = ligne[1];
	                        String evolution2Poke2 = ligne[2];
	                        String Type1Poke2 =ligne[3];
	                        String Type2Poke2=ligne[4];
	                        //System.out.println("nom: "+nomPoke2+" evolution1: " + evolution1Poke2+" evolution2: " + evolution2Poke2+" Type1: "+Type1Poke2+" Type2: " + Type2Poke2);
	                       if (!bonbon.containsKey(nomPoke2)) { //si le bonbone n'existe pas dans la liste des bonbones alors on ajoute a la liste 
	                    	   bonbon.put(nomPoke2,1);
	                       }
	                       else {  // si le bonbone qu'on veut ajouter  existe deja  dans la liste des bonbones on incremente donc sa valeur 
	                    	   int ancieneValeur=bonbon.get(nomPoke2);
	                    	   bonbon.put(nomPoke2,ancieneValeur+1); 
	                       }
	                        
	                        Pokemon pokemon2=new Pokemon(nomPoke2,Type1Poke2,pcPoke2,pvPoke2,evolution2);//pokemon 1 de dresseur avec une list vide des evolutions 
		                    pokemons.add(pokemon2);
		                    if (evolution2Poke2.equals("none")) {
		                    Evolution evpok2 =new Evolution(evolution1Poke2);//list des evolution possible pour pokemon1 non affecter a le pokemon 1 seulement pour memoriser 
		                    evolution.add(evpok2);
		                    }
		                    else {
		                    	Evolution evpok2=new Evolution(evolution1Poke2,evolution2Poke2);
		                    	evolution.add(evpok2);
		                    }
	                }
	                if (ligneCourante == poke3) {
	                    String[] ligne = line.split(";");
	                        String nomPoke3=ligne[0];
	                        String evolution1Poke3 = ligne[1];
	                        String evolution2Poke3 = ligne[2];
	                        String Type1Poke3 =ligne[3];
	                        String Type2Poke3=ligne[4];
	                       // System.out.println("nom: "+nomPoke3+" evolution1: " + evolution1Poke3+" evolution2: " + evolution2Poke3+" Type1: "+Type1Poke3+" Type2: " + Type2Poke3);
	                       
	                        if (!bonbon.containsKey(nomPoke3)) { //si le bonbone n'existe pas dans la liste des bonbones alors on ajoute a la liste 
		                    	   bonbon.put(nomPoke3,1);
		                       }
		                       else {  // si le bonbone qu'on veut ajouter  existe deja  dans la liste des bonbones on incremente donc sa valeur 
		                    	   int ancieneValeur=bonbon.get(nomPoke3);
		                    	   bonbon.put(nomPoke3,ancieneValeur+1); 
		                       }
	                        Pokemon pokemon3=new Pokemon(nomPoke3,Type1Poke3,pcPoke3,pvPoke3,evolution3);//pokemon 1 de dresseur avec une list vide des evolutions 
		                    pokemons.add(pokemon3);
		                    if (evolution2Poke3.equals("none")) {
		                    Evolution evpok3 =new Evolution(evolution1Poke3);//list des evolution possible pour pokemon1 non affecter a le pokemon 1 seulement pour memoriser 
		                    evolution.add(evpok3);
		                    }
		                    else {
		                    	Evolution evpok3=new Evolution(evolution1Poke3,evolution2Poke3);
		                    	evolution.add(evpok3);
		                    }
	                }

	                ligneCourante++;
	            }
//                System.out.println(pokemons);
//                 System.out.println(evolution);
//                 System.out.println(bonbon);
               //  pokemons.get(0).ajouerEvolution(evolution.get(0).getEvolution1());
               //  System.out.println(pokemons);
//                 System.out.println(evolution.get(1).getEvolution1());//pour acceder au premier evolution 
//                 System.out.println(evolution.get(1).getEvolutionList().size());//pour savoir combien d'evolution possible pour le pokemon 1
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (fi != null) {
	                    fi.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	
//	    System.out.println("pc "+pcPoke1 +" pv " + pvPoke1);
//	    System.out.println("pc "+pcPoke2 +" pv " + pvPoke2);
//	    System.out.println("pc "+pcPoke3 +" pv " + pvPoke3);
	}//a partire de fichier en ratrappe le nom pokemon et son type et ses evolutions .generer pc et pv aleatoire
 
	public void evoluer(Pokemon p) { //le parametre c'est le pokemon adversaire 
		
		int indicePokInListPok=0;
		int i=0;
		if (pokemons.contains(p)) {
			for(Pokemon r :pokemons) {
				if (r==p) {
				 if(bonbon.get(r.getNom())==5) { // evoluer seulement si le nombre de bonbone de meme type que le nom de pokemon adeversaire egal 5 
					if (r.getEvolution().size()==0) {
						r.ajouerEvolution(evolution.get(i).getEvolution1());
						r.setNom(evolution.get(i).getEvolution1());
						r.setPc(1);
						r.setPv(1);
						bonbon.put(r.getNom(),0);
						return ;
						}
					else if (r.getEvolution().size()==1)
					{
					     r.ajouerEvolution(evolution.get(i).getEvolution2());
					     r.setPc(1);
						 r.setPv(1);
						 bonbon.put(r.getNom(),0);
					     return ;
					       }
				}
				 else System.out.println("nombre de bonbone n'est pa suffisant");
				 return;
				 }
				
				i++;
			}
		}
	}
	
	public ArrayList<Evolution> getEvolution() {//pour voir les evolution possible de pokemon
		return evolution;
	}

	@Override
	public String toString() {
		return "Dresseur [nom=" + nom + ", niveau=" + niveau + ", pokemons=" + pokemons + ", bonbon=" + bonbon + "]";
	}
	
	public static void main(String[] args) {
		Dresseur d1 =new Dresseur("ss",1);
		Dresseur d2 =new Dresseur("ss",1);
		d.lootBox();
		d.evoluer(d.getPokemons().get(0));
        System.out.println(d.getPokemons());
		Serveur serveur = new Serveur();
		serveur.combattre(d1,d2);
	}
}
