
package model;

import java.util.ArrayList;

/**
 *
 * @author Maria Centagrui Perez  Alvarez
 */
public class Snorlax extends Pokemon{
  
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
}

