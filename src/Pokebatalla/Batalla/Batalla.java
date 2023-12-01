/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokebatalla.Batalla;

import FileManager.FileManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Scanner;
import mx.edu.itsur.pokebatalla.model.pokemons.Pokemon;

/**
 *
 * @author Maria Centagrui Perez Alvarez
 * 
 */

 public class Batalla implements Serializable {
protected Entrenador entrenador1;
    protected Entrenador entrenador2;
    protected int turno = 1;
    protected boolean batallaFinalizada = false;

    // Constructor
    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    // Métodos
    public void salvarProgreso() {
        FileManager.escribirPartida(this);
    }

    public void desarrollarBatalla() {
        // Variables que se utilizarán
        Entrenador entrenadorEnTurno = null;
        Entrenador entrenadorOponente = null;

        System.out.println("Los juegos del hambre ITSUR 2023, han comenzado  ");
      System.out.println(entrenador1.getNombre() + " Contra  " + entrenador2.getNombre());
 
        // La primera vez ambos entrenadores se elegirán Pokémon
        // 1. El primer entrenador selecciona su pokemon.
        do {

            try {
                seleccionarPokemon(entrenador1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR ,SOLO TIENES "
                        + entrenador1.getPokemonsCapturados().size()
                        + " ESCOGE ");
                entrenador1.setPokemonActual(null);
            }
        } while (entrenador1.getPokemonActual() == null);

        // 2. El segundo entrenador selecciona su pokemon.
        do {
            try {
                seleccionarPokemon(entrenador2);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR ,SOLO TIENES "
                        + entrenador2.getPokemonsCapturados().size()
                        + " ESCOGE ");
                entrenador2.setPokemonActual(null);
            }
        } while (entrenador2.getPokemonActual() == null);

        while (!batallaFinalizada) {

            // 1. Asignar variables de entrenador acorde al turno.
            if (turno == 1) {
                entrenadorEnTurno = entrenador1;
                entrenadorOponente = entrenador2;
            } else {
                entrenadorEnTurno = entrenador2;
                entrenadorOponente = entrenador1;
            }
            System.out.println("Es el turno de: " + entrenadorEnTurno.nombre);

            // 2. Se da opción al entrenador en turno de que cambie de Pokemon antes de escoger movimiento.
            if (entrenadorEnTurno.getPokemonActual().gethp() > 0 && entrenadorOponente.getPokemonActual().gethp() > 0) {
                System.out.println(entrenadorEnTurno.getNombre() + " tu Pokemon actual es: " + entrenadorEnTurno.getPokemonActual());
                System.out.println("El Pokemon de tu oponente " + entrenadorOponente.getNombre() + " es: " + entrenadorOponente.getPokemonActual());
                System.out.println("CAMBIAR POKEMON");
                System.out.println("1 -> NO");
                System.out.println("2 -> SI");
                System.out.println("QUIERES GUARDAR LA BATALLA");
                System.out.println("Y -> SI");
                System.out.println("N -> NO");
                try {
                    char auxLectura = (char) System.in.read(); // Leer opción seleccionada
                    System.in.read(new byte[System.in.available()]); // Limpiar buffer

                    if (auxLectura == '2') {
                        seleccionarPokemon(entrenadorEnTurno);
                    } else if (auxLectura == 'Y') {
                        salvarProgreso();
                        return;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("MOVIMIENTOS DISPONIBLES PARA USAR");
                for (Enum movimiento : entrenadorEnTurno.getPokemonActual().getMovimientos()) {
                    System.out.println(movimiento.ordinal() + 1 + " -> "
                            + movimiento.name());
                }

                try {
                    char auxLectura = (char) System.in.read(); // Leer opción seleccionada
                    System.in.read(new byte[System.in.available()]); // Limpiar buffer

                    // 3. El pokemon realiza el ataque.
                    entrenadorEnTurno.instruirMovimientoAlPokemonActual(entrenadorOponente.getPokemonActual(), Character.getNumericValue(auxLectura) - 1);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

              
                if (entrenadorOponente.estaDerrotado()) {
                    // Si terminó, se ha terminado la batalla.
                    System.out.println(entrenadorOponente.getNombre() + " PERDIO");
                    System.out.println(  entrenadorEnTurno.getNombre() + "!! HAS GANADO LA BATALLA Y UN PAN ");
                    // Preguntar al usuario si desea eliminar el archivo
                    System.out.println("¿Deseas eliminar el archivo de partida? (Y/N)");

                    try {
                        char respuestaEliminar = (char) System.in.read(); // Leer respuesta del usuario
                        System.in.read(new byte[System.in.available()]); // Limpiar buffer

                        if (respuestaEliminar == 'Y' || respuestaEliminar == 'y') {
                            FileManager.borrarPartida(); // Eliminar el archivo
                            System.out.println("Archivo eliminado.");
                        } else {
                            System.out.println("El archivo no ha sido eliminado.");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        char respuestaEliminar = (char) System.in.read(); // Leer respuesta del usuario
                        System.in.read(new byte[System.in.available()]); // Limpiar buffer

                        if (respuestaEliminar == 'Y' || respuestaEliminar == 'y') {
                            FileManager.borrarPartida(); // Eliminar el archivo
                            System.out.println("Archivo eliminado.");
                        } else {
                            System.out.println("El archivo no ha sido eliminado.");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    // Fin del juego
                    batallaFinalizada = true;
                } else {
                    // 5. Si nadie ha ganado aún, se cambia el turno y repite.
                    salvarProgreso();
                    if (turno == 1) {
                        turno = 2;
                    } else {
                        turno = 1;
                    }
                }
            } else if (entrenadorEnTurno.getPokemonActual().gethp() > 0 && entrenadorOponente.getPokemonActual().gethp() <= 0) {
                System.out.println(entrenadorEnTurno.getNombre() + " tu Pokemon actual es: " + entrenadorEnTurno.getPokemonActual());
                if (entrenadorOponente.estaDerrotado()) {
                   
                    System.out.println(entrenadorOponente.getNombre() + " esta derrotado!!!");
                    System.out.println(" " + entrenadorEnTurno.getNombre() + "ESTE MENSAJE INFORMA QUE GANASTE UN PAN Y LA BATALLA");
                    batallaFinalizada = true;
                } else {
                    System.out.println("Cambia tu pokemon por cuestiones de salud");
                    seleccionarPokemon(entrenadorOponente);
                }
            } else if (entrenadorEnTurno.getPokemonActual().gethp() <= 0 && entrenadorOponente.getPokemonActual().gethp() > 0) {
                System.out.println(" pokemon se debilito cambialo");
                System.out.println("El Pokemon de tu oponente " + entrenadorOponente.getNombre() + " es: " + entrenadorOponente.getPokemonActual());
                System.out.println("Deseas cambiar de Pokemon?");
                seleccionarPokemon(entrenadorEnTurno);
            }
        }
    }

    private void seleccionarPokemon(Entrenador ent) {
    
        boolean kk = false;
        while (!kk) {
            System.out.println("pokemones a usar" + ent.nombre );
            int auxCount = 1;

            for (Pokemon p : ent.getPokemonsCapturados()) {
                System.out.println(auxCount + " -> " + p);
                auxCount++;
            }

            try {
                int opcionSeleccionada = new Scanner(System.in).nextInt(); // Leer opción seleccionada

                
                if (opcionSeleccionada >= 1 && opcionSeleccionada <= ent.getPokemonsCapturados().size()) {
                    // Obtener el Pokémon seleccionado de la lista.
                    Pokemon pokemonSeleccionado = ent.getPokemonsCapturados().get(opcionSeleccionada - 1);
                    if (pokemonSeleccionado.getHp() > 0) {
                        ent.setPokemonActual(pokemonSeleccionado);
                        System.out.println(ent.nombre + " ha seleccionado a: " + ent.getPokemonActual());
                     
                        kk = true;
                    } else {
                        if (ent.getPokemonsCapturados().get(0).gethp() == 0 && ent.getPokemonsCapturados().get(1).gethp() == 0) {
                            System.out.println("ya perdiste tilin");

                            return;
                        }
                        System.out.println("");
                        System.out.println("Cambia de pokemon,esta debil");
                    }

                } else {
                    System.out.println("Por favor, introduce un número válido.");
                }

            } catch (Exception ex) {
                System.out.println("Error: Introduce un número válido.");
            }
        }
    }
   
           //pasame profe 
    
}