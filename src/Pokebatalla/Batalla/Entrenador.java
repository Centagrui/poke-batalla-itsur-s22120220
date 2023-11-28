/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokebatalla.Batalla;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mx.edu.itsur.pokebatalla.model.pokemons.Pokemon;
/**
 *
 * @author Maria Centagrui Perez Alvarez
 */
public class Entrenador implements Serializable {
    protected String nombre;
    protected List<Pokemon> pokemonsCapturados;
    protected Pokemon pokemonActual;
    
    public Entrenador(String nombre){
        this.nombre = nombre;
        this.pokemonsCapturados = new ArrayList<>();
    }
    
    public boolean capturarPokemon(Pokemon p){
        return pokemonsCapturados.add(p);
    }
    
    public void instruirMovimientoAlPokemonActual(Pokemon oponente, int ordinalMovimiento){
        if(pokemonActual == null){
            System.out.println("No has seleccionado ningun pokemon");
            return;
        }
        
        if(ordinalMovimiento < 0 || ordinalMovimiento >= pokemonActual.getMovimientos().length){
            System.out.println("no valido");
            return;
        }
        this.pokemonActual.atacar(oponente, ordinalMovimiento);
    }
    
    public boolean estaDerrotado(){
        for(Pokemon pokemon : pokemonsCapturados){
            if(pokemon.getHp() > 0){
                return false;
            }
        }
        return true;
    }
    //Getters y Setters
    public String getNombre(){
        return nombre;
    }
    
    public Pokemon getPokemonActual(){
        return pokemonActual;
    }
    
    public void setPokemonActual(Pokemon p){
        this.pokemonActual = p;
    }
    
    public List<Pokemon> getPokemonsCapturados(){
        return pokemonsCapturados;
    }
    
}
