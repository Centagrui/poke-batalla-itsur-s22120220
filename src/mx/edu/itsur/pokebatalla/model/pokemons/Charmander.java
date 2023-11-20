/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.pokemons;

import mx.edu.itsur.pokebatalla.model.moves.AtaqueRapido;
import mx.edu.itsur.pokebatalla.model.moves.Impactrueno;
import mx.edu.itsur.pokebatalla.model.moves.Latigo;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Maria Centagrui PEREZ Alvarez
 */
public class Charmander extends Pokemon {

    /**
     * Movimientos que puede realizar el Pokémon
     */
    public enum Movimientos {
        ATAQUE_RAPIDO,
        Impactrueno,
        Latigo,
        //Otros movimientos...
    }

    public Charmander() {
        tipo = "FUEGO";
        hp = 39;
        ataque = 52;
        defensa = 43;
        nivel = 1;
        precision = 4;
    }

    
    public  Charmander(String nombre){
        this();
        this.nombre = nombre;
    }
    
    public Enum[] getMovimientos(){
        return  Charmander.Movimientos.values();
    }
    
    public void atacar(Pokemon oponente, int ordinalMovimiento){
        Movimiento instanciaMovimiento;
        Charmander.Movimientos movimientoAUtilizar =  Charmander.Movimientos.values()[ordinalMovimiento];
        switch(movimientoAUtilizar){
            case Latigo:
                instanciaMovimiento = new Latigo();
                break;
            case ATAQUE_RAPIDO:
                instanciaMovimiento = new AtaqueRapido();
                break;
            case  Impactrueno:
                instanciaMovimiento = new Impactrueno();
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
    public void atacar (Pokemon oponente, Pikachu.Movimientos movimientosAutilizar){
        Movimiento instanciaMovimiento;
        switch(movimientosAutilizar){
            case IMPACTRUENO:
                instanciaMovimiento = new Impactrueno();
                break;
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

