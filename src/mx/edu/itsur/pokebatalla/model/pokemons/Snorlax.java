
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
    
    public Snorlax (String nombre)
    {
        this();
        this.nombre = nombre; 
        
    }
    public void atacar (Pokemon oponente, String habilidad)
            {
                
                if (habilidad.equals("Reciclaje"))
                {
                    System.out.println(this.nombre + "Reciclaje" + " y ataco a: " + oponente);
                }
                else if (habilidad.equals("Azote"))
                {
                    System.out.println(this.nombre + "Azote" + " y ataco a: " + oponente);
                }
            }
     public void atacar(Pokemon oponente,Snorlax.Movimientos movimientoAUtilizar) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;        
        switch (movimientoAUtilizar) {
            case Mordisco:
                instanciaMovimiento = new Mordisco();
                break;
            case Antojo:
                instanciaMovimiento = new Antojo();
                break;
            case Reserva:
                instanciaMovimiento = new Reserva ();
                break;

            //Otros movimientos aquí...                
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento.
        instanciaMovimiento.utilizar(this, oponente);
    }

}

