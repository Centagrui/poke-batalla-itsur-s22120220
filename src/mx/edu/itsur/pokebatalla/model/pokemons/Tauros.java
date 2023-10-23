
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
        this.ataque = 198; 
        this.defensa = 183; 
        this.hp = 100; 
        this.nivel = 50; 
        this.precision = 5; 
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Proteccion");
        this.habilidades.add("Cara Susto");
        
    }
    
    public Tauros (String nombre)
    {
        this();
        this.nombre = nombre; 
        
    }
    
    public void atacar(Pokemon oponente, String habilidad)
    {
        if (habilidad.equals("Proteccion"))
                {
                    System.out.println(this.nombre + "Proteccion" + " y ataco a: " + oponente);
                }
        else if(habilidad.equals("Cara Susto"))
        {
            System.out.println(this.nombre + "Cara Susto" + " y ataco a: " + oponente);
        }
    }
    
    public void atacar(Pokemon oponente, Tauros.Movimientos movimientoAUtilizar) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;        
        switch (movimientoAUtilizar) {
            case Placaje:
                instanciaMovimiento = new Placaje();
                break;
            case Cabezazo_zen:
                instanciaMovimiento = new CabezazoZen();
                break;
            case Sania:
                instanciaMovimiento = new Sania();
                break;

            //Otros movimientos aquí...                
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento.
        instanciaMovimiento.utilizar(this, oponente);
    }
}
