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

    public static void guardarBatalla(Batalla batalla, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(batalla);
            System.out.println("Batalla guardada exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar la batalla en " + nombreArchivo);
        }
    }

    public static Batalla cargarBatalla(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Batalla batalla = (Batalla) ois.readObject();
            System.out.println("Batalla cargada exitosamente desde " + nombreArchivo);
            return batalla;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la batalla desde " + nombreArchivo);
            return null;
        }
    }
}

