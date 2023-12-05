
package mx.edu.itsur.pokebatalla.model.pokemons;

import java.util.ArrayList;
import mx.edu.itsur.pokebatalla.model.moves.Imagen;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;
import mx.edu.itsur.pokebatalla.model.moves.PoderPasado;
import mx.edu.itsur.pokebatalla.model.moves.Teraexplosion;



/**
 *
 * @author  Maria Centagrui Perez  Alvarez
 */
public class Mew extends Pokemon {
    private final ArrayList<Object> habilidades;
     public enum Movimientos {
        PoderPasado,
        Imagen,
        Teraexplosion,

        //Otros movimientos...
    }
      
    public Mew ()
    {
         this.tipo = "Siquico";
        this.ataque = 18; 
        this.defensa = 169; 
        this.hp = 100; 
        this.nivel = 50; 
        this.precision = 3; 
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Derribo");
        this.habilidades.add("Bofetón lodo");
        
    }
    
    public Mew(String nombre){
        this();
        this.nombre = nombre;
    }
    
    public Enum[] getMovimientos(){
        return Mew.Movimientos.values();
    }
    
    public void atacar(Pokemon oponente, int ordinalMovimiento){
        Movimiento instanciaMovimiento;
       Mew.Movimientos movimientoAUtilizar = Mew.Movimientos.values()[ordinalMovimiento];
        switch(movimientoAUtilizar){
            case PoderPasado :
                instanciaMovimiento = new PoderPasado();
                break;
            case Imagen:
                instanciaMovimiento = new Imagen();
                break;
            case Teraexplosion:
                instanciaMovimiento = new Teraexplosion();
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
    public void atacar (Pokemon oponente, Mew.Movimientos movimientosAutilizar){
        Movimiento instanciaMovimiento;
        switch(movimientosAutilizar){
            case PoderPasado:
                instanciaMovimiento = new PoderPasado();
                break;
            case Imagen:
                instanciaMovimiento = new Imagen ();
                break;
            case Teraexplosion:
                instanciaMovimiento = new Teraexplosion();
                break;
            default:
                throw new AssertionError();
        }
    } 
}