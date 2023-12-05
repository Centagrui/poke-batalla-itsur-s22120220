
package mx.edu.itsur.pokebatalla.model.pokemons;

import java.util.ArrayList;
import mx.edu.itsur.pokebatalla.model.moves.CabezazoZen;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;
import mx.edu.itsur.pokebatalla.model.moves.Placaje;
import mx.edu.itsur.pokebatalla.model.moves.Sania;
import static mx.edu.itsur.pokebatalla.model.pokemons.Tauros.Movimientos.Cabezazo_zen;
import static mx.edu.itsur.pokebatalla.model.pokemons.Tauros.Movimientos.Placaje;

/**
 *
 * @author  Maria Centagrui Perez  Alvarez
 */
public class Tauros extends Pokemon {
     public enum Movimientos {
        Placaje,
        Cabezazo_zen,
        Sania,
        

        //Otros movimientos...
    }
    private final ArrayList<Object> habilidades;
    public Tauros ()
    {
        this.ataque = 12; 
        this.defensa = 183; 
        this.hp = 100; 
        this.nivel = 50; 
        this.precision = 5; 
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Proteccion");
        this.habilidades.add("Cara Susto");
        
    }
   public Tauros(String nombre){
        this();
        this.nombre = nombre;
    }
    
    public Enum[] getMovimientos(){
        return Tauros.Movimientos.values();
    }
    
    public void atacar(Pokemon oponente, int ordinalMovimiento){
        Movimiento instanciaMovimiento;
        Tauros.Movimientos movimientoAUtilizar = Tauros.Movimientos.values()[ordinalMovimiento];
        switch(movimientoAUtilizar){
            case Placaje :
                instanciaMovimiento = new Placaje();
                break;
            case Cabezazo_zen:
                instanciaMovimiento = new CabezazoZen();
                break;
            case Sania:
                instanciaMovimiento = new Sania();
                break;
            default:
                throw new AssertionError();
        }
        if(this.hp<=0){
            System.out.println("Tauros esta agotado y ya no puede realizar mas movimientos");
            return;
        }
        instanciaMovimiento.utilizar(this, oponente);
    }
    public void atacar (Pokemon oponente, Tauros.Movimientos movimientosAutilizar){
        Movimiento instanciaMovimiento;
        switch(movimientosAutilizar){
            case Placaje :
                instanciaMovimiento = new Placaje();
                break;
            case Cabezazo_zen:
                instanciaMovimiento = new CabezazoZen ();
                break;
            case Sania:
                instanciaMovimiento = new Sania();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
}