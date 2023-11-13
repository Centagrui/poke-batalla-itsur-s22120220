
package mx.edu.itsur.pokebatalla.model.pokemons;

import java.util.ArrayList;
import mx.edu.itsur.pokebatalla.model.moves.Antojo;
import mx.edu.itsur.pokebatalla.model.moves.Mordisco;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;
import mx.edu.itsur.pokebatalla.model.moves.Reserva;

/**
 *
 * @author Maria Centagrui Perez  Alvarez
 */
public class Snorlax extends Pokemon{
    
    
    private final ArrayList<Object> habilidades;
  
    
      public enum Movimientos {
        Mordisco,
        Antojo,
        Reserva

        //Otros movimientos...
    }
    public Snorlax ()
    {
        this.ataque = 190; 
        this.defensa = 169; 
        this.hp = 100; 
        this.nivel = 50; 
        this.precision = 100; 
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Reciclaje ");
        this.habilidades.add("Azote");
        
    }
     public Snorlax(String nombre){
        this();
        this.nombre = nombre;
    }
    
    public Enum[] getMovimientos(){
        return Tauros.Movimientos.values();
    }
    
    public void atacar(Pokemon oponente, int ordinalMovimiento){
        Movimiento instanciaMovimiento;
        Snorlax.Movimientos movimientoAUtilizar = Snorlax.Movimientos.values()[ordinalMovimiento];
        switch(movimientoAUtilizar){
            case Mordisco :
                instanciaMovimiento = new Mordisco();
                break;
            case Reserva:
                instanciaMovimiento = new Reserva();
                break;
            case Antojo:
                instanciaMovimiento = new Antojo();
                break;
            default:
                throw new AssertionError();
        }
        if(this.hp<=0){
            System.out.println("Snorlax esta agotado y ya no puede realizar mas movimientos");
            return;
        }
        instanciaMovimiento.utilizar(this, oponente);
    }
    public void atacar (Pokemon oponente, Snorlax.Movimientos movimientosAutilizar){
        Movimiento instanciaMovimiento;
        switch(movimientosAutilizar){
            case Mordisco :
                instanciaMovimiento = new Mordisco();
                break;
            case Reserva:
                instanciaMovimiento = new Reserva ();
                break;
            case Antojo:
                instanciaMovimiento = new Antojo();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
}