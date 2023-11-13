/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.pokemons;

import mx.edu.itsur.pokebatalla.model.moves.AtaqueRapido;
import mx.edu.itsur.pokebatalla.model.moves.Latigo;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;
import mx.edu.itsur.pokebatalla.model.pokemons.Pokemon;

/**
 *
 * @author Maria Centagrui PEREZ Alvarez
 */
public class Bullbasaur extends Pokemon {

    public enum Movimientos {
        ATAQUE_RAPIDO,
        LATIGO
       
    }

    public Bullbasaur() {
        tipo = "PLANTA/VENENO";
        hp = 45;
        ataque = 49;
        defensa = 49;
        nivel = 1;
        precision = 4;
    }

   
    public  Bullbasaur(String nombre){
        this();
        this.nombre = nombre;
    }
    
    public Enum[] getMovimientos(){
        return Bullbasaur.Movimientos.values();
    }
    
    public void atacar(Pokemon oponente, int ordinalMovimiento){
        Movimiento instanciaMovimiento;
        Bullbasaur.Movimientos movimientoAUtilizar =  Bullbasaur.Movimientos.values()[ordinalMovimiento];
        switch (movimientoAUtilizar) {
            case ATAQUE_RAPIDO:
                instanciaMovimiento = new AtaqueRapido();
                break;
            case LATIGO:
                instanciaMovimiento = new Latigo();
                break;
            default:
                throw new AssertionError();
                
        }
        if(this.hp<=0){
            System.out.println(" Charmander esta agotado y ya no puede realizar mas movimientos");
            return;
        }
        instanciaMovimiento.utilizar(this, oponente);
    }
    public void atacar (Pokemon oponente, Bullbasaur.Movimientos movimientosAutilizar){
        Movimiento instanciaMovimiento;
        switch(movimientosAutilizar){
           
            case ATAQUE_RAPIDO:
                instanciaMovimiento = new AtaqueRapido ();
                break;
            case  LATIGO:
                instanciaMovimiento = new  Latigo();
                break;
            default:
                throw new AssertionError();
        }
    } 


}

