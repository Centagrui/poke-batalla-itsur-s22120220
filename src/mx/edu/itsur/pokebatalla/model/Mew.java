
package model;

import java.util.ArrayList;

/**
 *
 * @author  Maria Centagrui Perez  Alvarez
 */
public class Mew extends Pokemon {
    public Mew ()
    {
        this.ataque = 210; 
        this.defensa = 210; 
        this.hp = 100; 
        this.nivel = 50; 
        this.precision = 5; 
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
    
}


