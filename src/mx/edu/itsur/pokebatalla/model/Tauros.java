
package model;

import java.util.ArrayList;

/**
 *
 * @author  Maria Centagrui Perez  Alvarez
 */
public class Tauros extends Pokemon {
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
    
}
