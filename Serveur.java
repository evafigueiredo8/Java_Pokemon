package pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class Serveur {
    static int i = 0;
    static int nbPokemon = 0;
    private String nomPokemon;
    ArrayList<Pokemon> pokemonsCombatd1 = new ArrayList<>();
    ArrayList<Pokemon> pokemonsCombatd2 = new ArrayList<>();
    
    public void mortPokemon(){
        global pokemons;
        if (i = 1){
            for (int p; p < pokemons; p++){
                pokemonsCombatd1.add(d1.getPokemon().get(p));
                pokemonsCombatd2.add(d2.getPokemon().get(p));
            }
        }
        if (d1.getPokemon().get(nbPokemon).getPV() <= 0){
            pokemonsCombatd1.remove(nbPokemon);
            nomPokemon = d1.getPokemon().get(nbPokemon).getNom();
            ajoutBonbon(d2);
        }
        
        if (d2.getPokemon().get(nbPokemon).getPV() <= 0){
            pokemonsCombatd2.remove(nbPokemon);
            nomPokemon = d2.getPokemon().get(nbPokemon).getNom();
            ajoutBonbon(d2);
        }
    }

    public void ajoutBonbon(Dresseur dresseur){
        if (dresseur.getBonbon().containsKey(nomPokemon)){
            int valeur = dresseur.getBonbon().get(nomPokemon);
            valeur += 1;
            dresseur.getBonbon().put(nomPokemon, valeur);
        }
    }

    public void combattre(Dresseur d1, Dresseur d2){
        i += 1;

        for (int choix = 1; choix < 3; choix++){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Dresseur 1, entrer le numéro du " + p + "e pokemon que vous voulez utiliser.");
            pokemonsCombatd1.add(d1.getPokemon().get(myObj.nextLine()));
        }
        System.out.println("Pokemons du dresseur 1 pour ce combat : " + pokemonsCombatd1);
        for (int choix = 1; choix < 3; choix++){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Dresseur 2, entrer le numéro du " + p + "e pokemon que vous voulez utiliser.");
            pokemonsCombatd2.add(d1.getPokemon().get(myObj.nextLine()));
        }
            System.out.println("Pokemons du dresseur 2 : " + pokemonsCombatd2);

        if (i%2 != 0){
            int PCd1 = d1.getPokemon().get(nbPokemon).getPC();
            int PVd2 = d2.getPokemon().get(nbPokemon).getPV();
            d2.getPokemon().get(nbPokemon).diminuerPV();
            System.out.println("PV du pokemon du dresseur 2 pour ce combat : " + pokemonsCombatd2);
        }
        if (i%2 != 1){
            int PCd2 = d2.getPokemon().get(nbPokemon).getPC();
            int PVd1 = d1.getPokemon().get(nbPokemon).getPV();
            d1.getPokemon().get(nbPokemon).diminuerPV();
            System.out.println("PV du pokemon du dresseur 1 : " + d1.getPokemon().get(nbPokemon).getPV());
        }
        mortPokemon();
        nbPokemon += 1;
        if (pokemonsCombatd1.isEmpty() || pokemonsCombatd2.isEmpty()){
            return;
        } else {
            combattre(d1, d2);
        }
        
    }


}
