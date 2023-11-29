/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

/**
 *
 * @author  Maria Centagrui Perez Alvarez
 */
import Pokebatalla.Batalla.Batalla;
import java.io.*;

public class FileManager {
     
    public static final String pokemones = "batalla.txt";

   /* public static void PartidaGuardad(Batalla b) {
        try (ObjectOutputStream guardarObjectos = new ObjectOutputStream(new FileOutputStream(pokemones))) {
            guardarObjectos.writeObject(b);
        } catch (IOException ex) {
        }
    }
*/
    public static Batalla leerPartida() {
        Batalla b = null;
        try (ObjectInputStream leerObjectos = new ObjectInputStream(new FileInputStream(pokemones))) {
            b = (Batalla) leerObjectos.readObject();
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException ex) {
        }
        return b;
    }
     public void write() {
        try {
            String filename = "batalla.txt"; // Nombre del archivo de salida
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);

            StringBuilder acu = new StringBuilder();
            
               // acu.append(" |"++"|" +"\n");
            
            bw.write(acu.toString());
            System.out.println("Texto escrito en el archivo correctamente.");
            
            bw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

