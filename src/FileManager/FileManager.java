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

    public static final String partida = "batalla";

    public static void escribirPartida(Batalla x) {
        try (ObjectOutputStream escritorDeObjetos = new ObjectOutputStream(new FileOutputStream(partida))) {
            escritorDeObjetos.writeObject(x);
        } catch (IOException ex) {
        }
    }

    public static Batalla leerPartida() {
        Batalla leer = null;
        try (ObjectInputStream lectorDeObjetos = new ObjectInputStream(new FileInputStream(partida))) {
            leer = (Batalla) lectorDeObjetos.readObject();
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException ex) {
        }
        return leer;
    }
    
    public static void borrarPartida() {
    File archivo = new File(partida);
    if (archivo.exists()) {
        archivo.delete();
        System.out.println("Partida anterior eliminada.");
    }
}
}

