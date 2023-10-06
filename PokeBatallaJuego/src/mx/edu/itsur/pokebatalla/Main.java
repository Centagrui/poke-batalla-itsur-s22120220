/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.pokebatalla;
import model.Bullbasaur;
import model.Charmander;
import model.Mew;
import model.Pikachu;
import model.Pokemon;
import model.Snorlax;
import model.Tauros;
/**
 *
 * @author Maria Centagrui Perez Alarez 
 */
public class Main {

/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello PokeBatalla!");
        
        Pikachu pikachuSalvaje = new Pikachu();
        Charmander charmanderSalvaje = new Charmander() ;
        Mew mewSalvaje=new  Mew ();
        Snorlax snorlaxSalvaje=new Snorlax();
        Tauros TauroSalvaje=new Tauros();
        Bullbasaur bullSalvaje=new Bullbasaur();
        
        
        
        //Realizar la captura del pikachu salvaje
        pikachuSalvaje.setNombre("Pedro");        
        Pikachu miPikachu = pikachuSalvaje;
        
        miPikachu.atacar(charmanderSalvaje);
        
        miPikachu.atacar(charmanderSalvaje, "ATACKTRUENO");
        
        //Pelea entre  Bullbasaur y Squirtle
        
        mewSalvaje.setNombre("pan");
         Mew pan= mewSalvaje;
         
         pan.atacar(bullSalvaje);
         pan.atacar(bullSalvaje, "BURBUJA");
         
         bullSalvaje.setNombre("BULLBU");
         Bullbasaur bullbu=bullSalvaje;
         
         bullbu.atacar(pan);
         bullbu.atacar(pan, "Derribo");
                 
         
         //Pelea entre   pato y vaca
         snorlaxSalvaje.setNombre("pato");
         Snorlax pato=snorlaxSalvaje;
         
         pato.atacar(TauroSalvaje);
         pato.atacar(TauroSalvaje, "Azote");
         
        
         TauroSalvaje.setNombre("vaca");
        Tauros vaca=TauroSalvaje;
         
        vaca.atacar(snorlaxSalvaje);
        vaca.atacar(snorlaxSalvaje, "ATAQUE ALA");
        
         
         
         
         
        
        
    }
    
}

