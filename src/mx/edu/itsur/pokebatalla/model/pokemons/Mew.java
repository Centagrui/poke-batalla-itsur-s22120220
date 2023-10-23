
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
        this.ataque = 190; 
        this.defensa = 169; 
        this.hp = 100; 
        this.nivel = 50; 
        this.precision = 3; 
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Derribo");
        this.habilidades.add("Bofetón lodo");
        
    }
    
    public Mew (String nombre)
    {
        this();
        this.nombre = nombre; 
        
    }
    
    public void atacar(Pokemon oponente, String habilidad)
    {
        if (habilidad.equals("Derribo"))
                {
                    System.out.println(this.nombre + "Derribo" + " y ataco a: " + oponente);
                }
        else if(habilidad.equals("Bofetón lodo"))
        {
            System.out.println(this.nombre + "Bofetón lodo" + " y ataco a: " + oponente);
        }
    }
    
    public void atacar(Pokemon oponente, Mew.Movimientos movimientoAUtilizar) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;        
        switch (movimientoAUtilizar) {
            case PoderPasado :
                instanciaMovimiento = new PoderPasado();
                break;
            case Imagen:
                instanciaMovimiento = new Imagen();
                break;
            case Teraexplosion:
                instanciaMovimiento = new Teraexplosion();
                break;

            //Otros movimientos aquí...                
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento.
        instanciaMovimiento.utilizar(this, oponente);
    }

}


