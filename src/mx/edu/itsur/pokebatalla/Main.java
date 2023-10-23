/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.pokebatalla;

import mx.edu.itsur.pokebatalla.model.pokemons.Bullbasaur;
import mx.edu.itsur.pokebatalla.model.pokemons.Charmander;
import mx.edu.itsur.pokebatalla.model.pokemons.Mew;
import mx.edu.itsur.pokebatalla.model.pokemons.Pikachu;
import mx.edu.itsur.pokebatalla.model.pokemons.Snorlax;
import mx.edu.itsur.pokebatalla.model.pokemons.Tauros;

/**
 *
 * @author Maria Centagrui Perez Alarez
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello PokeBatalla!");

        Pikachu pika = new Pikachu();
        Charmander charm = new Charmander();
        Bullbasaur bullb = new Bullbasaur();

        System.out.println("->Pikachu se encuentra con un Charmander y ataca");
        pika.atacar(charm, Pikachu.Movimientos.IMPACTRUENO);

        System.out.println("->Charmander se molesta y responde ");
        charm.atacar(pika, Charmander.Movimientos.ATAQUE_RAPIDO);

        System.out.println("->Bullbasaur se enoja porque atacaron a su amigo Pikachu y...");
        bullb.atacar(charm, Bullbasaur.Movimientos.LATIGO);
        // pelea entre los pokemones añadidos por centagrui
        Mew pan = new Mew();
        Snorlax waton = new Snorlax();
        Tauros griego = new Tauros();

        System.out.println("aparece wARON en  ");
        pan.atacar(waton, Mew.Movimientos.PoderPasado);

        System.out.println("Waton sentado siente el ataque de Pan y llega su amigo griego  ");
        griego.atacar(griego, Tauros.Movimientos.Sania);

        System.out.println(" Pan llega y pelan   ");
        waton.atacar(pan, Snorlax.Movimientos.Mordisco);
    }

}
