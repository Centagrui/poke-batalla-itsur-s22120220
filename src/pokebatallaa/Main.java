package pokebatallaa;

import FileManager.FileManager;
import mx.edu.itsur.pokebatalla.model.pokemons.Charmander;
import mx.edu.itsur.pokebatalla.model.pokemons.Mew;
import mx.edu.itsur.pokebatalla.model.pokemons.Snorlax;
import mx.edu.itsur.pokebatalla.model.pokemons.Tauros;
import Pokebatalla.Batalla.Batalla;
import Pokebatalla.Batalla.Entrenador;
import java.io.IOException;

/**
 *
 * @author Maria Centagrui Perez Alvarez
 */
public class Main {

    public static void main(String[] args) {
        Batalla b = FileManager.leerPartida();
        if (b == null) {
            System.out.println("Hello PokeBatalla!");

            Mew Pan = new Mew("Pan");
            Snorlax Waton = new Snorlax("Gordo");
            Tauros Griego = new Tauros("Dios");
            Charmander Holaa = new Charmander("huu");
            // Pikachu Pika = new Pikachu ("pika");
            //Bullbasaur Bull= new Bullbasaur("BUll");

            Entrenador entrenador1 = new Entrenador("Draco");
            entrenador1.capturarPokemon(Pan);
            entrenador1.capturarPokemon(Waton);

            Entrenador entrenador2 = new Entrenador("Harry Pother");
            entrenador2.capturarPokemon(Holaa);
            entrenador2.capturarPokemon(Griego);
           // Batalla batalla = new Batalla(entrenador1, entrenador2);
            //Batalla.desarrollarBatalla();
            //guardar progreso
            b = new Batalla(entrenador1, entrenador2);
        }
        b.desarrollarBatalla();

    }
}
