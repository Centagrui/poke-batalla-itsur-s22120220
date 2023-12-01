/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokebatallaa;

import FileManager.FileManager;
//import mx.edu.itsur.pokebatalla.model.pokemons.Bullbasaur;
import mx.edu.itsur.pokebatalla.model.pokemons.Charmander;
import mx.edu.itsur.pokebatalla.model.pokemons.Mew;
//import mx.edu.itsur.pokebatalla.model.pokemons.Pikachu;
import mx.edu.itsur.pokebatalla.model.pokemons.Snorlax;
import mx.edu.itsur.pokebatalla.model.pokemons.Tauros;
import Pokebatalla.Batalla.Batalla;
import Pokebatalla.Batalla.Entrenador;

/**
 *
 * @author Maria Centagrui Perez Alarez
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello PokeBatalla!");
       Batalla b = FileManager.leerPartida();
        if(b==null){
        
        Mew Pan = new Mew("Pan");
         Snorlax Waton = new Snorlax("Gordo");
        Tauros Griego = new Tauros(" Dios");
         Charmander Holaa = new Charmander ("huu");
        // Pikachu Pika = new Pikachu ("pika");
          //Bullbasaur Bull= new Bullbasaur("BUll");
          
          Entrenador entrenador1 = new Entrenador("Draco");
       entrenador1.capturarPokemon(Pan);
       entrenador1.capturarPokemon(Waton);
       
       Entrenador entrenador2 = new Entrenador("Harry Pother");
       entrenador2.capturarPokemon(Holaa);
       entrenador2.capturarPokemon(Griego);
       b = new Batalla(entrenador1, entrenador2);
        }
        b.desarrollarBatalla();
       
    }
}
        
    

