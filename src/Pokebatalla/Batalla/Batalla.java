/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokebatalla.Batalla;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
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

    private boolean primerAtaqueRealizado = false;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public void desarrollarBatalla() {
        
        
       System.out.println("Los juegos del hambre ITSUR 2023, han comenzado  ");
      
        System.out.println(entrenador1.getNombre() + " " + entrenador2.getNombre());

        System.out.println("");

        do {
            try {
                eligirPokemon(entrenador1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Solo puedes elegir entre  " + "[" + entrenador1.getPokemonsCapturados().size() + "]" + "  Elige alguno de tus Pokemons");
                entrenador1.setPokemonActual(null);
            }
        } while (entrenador1.getPokemonActual() == null);

        do {
            try {
                eligirPokemon(entrenador2);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Solamente cuentas con:  " + "["+ entrenador2.getPokemonsCapturados().size() + "]" + "  Elige alguno de tus Pokemons");
                entrenador2.setPokemonActual(null);
            }
        } while (entrenador2.getPokemonActual() == null);

        while (!batallaFinalizada) {
            Entrenador entrenadorEnTurno = (turno == 1) ? entrenador1 : entrenador2;
            Entrenador oponente = (turno == 1) ? entrenador2 : entrenador1;

            System.out.println(" Turno del siguiente entrenador: " + entrenadorEnTurno.getNombre());

            
            if (oponente.getPokemonActual() == null) {
                System.out.println("No hay un Pokemon seleccionado por ahora para el contrincante");
                return;
            }

            seleccionarAtaque(entrenadorEnTurno, oponente.getPokemonActual());
            if (entrenadorEnTurno.getPokemonActual() == null || entrenadorEnTurno.getPokemonActual().gethp() <= 0) {
                cambiarPokemon(entrenadorEnTurno);

                
                while (entrenadorEnTurno.getPokemonActual() == null || entrenadorEnTurno.getPokemonActual().gethp() <= 0) {
                    System.out.println("El entrenador no puede seguir sin antes cambiar de pokemon");
                    cambiarPokemon(entrenadorEnTurno);
                }
            }

            if (oponente.estaDerrotado()) {
                System.out.println("El entrenador " + oponente.getNombre() + " ha sido derrotado");
                System.out.println(" Fin de la batalla");
                batallaFinalizada = true;
            } else {
                
                turno = (turno == 1) ? 2 : 1;
            }
        }
    }

    private void eligirPokemon(Entrenador EnTn) {
        int idx = 1;
        System.out.println("   ");
        for (Pokemon pokemon : EnTn.getPokemonsCapturados()) {
            System.out.println(idx + ".- " + pokemon.getClass().getSimpleName());
            idx++;
             System.out.println("   ");
        }
        System.out.println("");
        System.out.println("Escoge un  pokemon " + EnTn.getNombre());

        char auxLectura = '0';

        try {
            auxLectura = (char) System.in.read();
            System.in.read((new byte[System.in.available()]));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Pokemon pokemonSeleccionado = EnTn.getPokemonsCapturados()
                .get(Character.getNumericValue(auxLectura) - 1);
        EnTn.setPokemonActual(pokemonSeleccionado);
    }

   
    private void seleccionarAtaque(Entrenador entrenadorEnturno, Pokemon oponente) {

        Pokemon pokemonActual = entrenadorEnturno.getPokemonActual();

        System.out.println("----------===========================----------");
        System.out.println("Seleccione un ataque para " + pokemonActual.getClass().getSimpleName() + ":");

        int idx = 1;

        for (Enum movimiento : pokemonActual.getMovimientos()) {
            System.out.println(idx + ".- " + movimiento);
            idx++;
        }
        System.out.println("----------===========================----------");

        int opcionAtaque = -1;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            opcionAtaque = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Ingresa algun numero valido mostrado en pantalla.");
            return;
        }

        if (opcionAtaque < 1 || opcionAtaque > pokemonActual.getMovimientos().length) {
            System.out.println("La opción de ataque no es valida.");
            return;
        }

       
        entrenadorEnturno.instruirMovimientoAlPokemonActual(oponente, opcionAtaque - 1);
    }


    private void cambiarPokemon(Entrenador entrenador) {
        System.out.println("Quieres cambiar de pokemon ? (S/N)");

        char respuesta = 'N';

        while (true) {
            try {
                respuesta = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
                break;  // Salir  si no hay excepciones
            } catch (IOException ex) {
                System.out.println("Error de entrada o salida al leer la respuesta. Intenta de nuevo.");
                ex.printStackTrace();
            }
        }

        if (respuesta == 'S' || respuesta == 's') {

            System.out.println("Pokemones avalibles:");
            int idx = 1;
            for (Pokemon pokemon : entrenador.getPokemonsCapturados()) {
                System.out.println(idx + ".- " + pokemon.getClass().getSimpleName());
                idx++;
            }

   
            System.out.println("Elige un Pokemon:");

            char auxLectura = '0';

            try {
                auxLectura = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

             int indicePokemonNuevo = Character.getNumericValue(auxLectura) - 1;

            
            if (indicePokemonNuevo >= 0 && indicePokemonNuevo < entrenador.getPokemonsCapturados().size()) {
                Pokemon nuevoPokemon = entrenador.getPokemonsCapturados().get(indicePokemonNuevo);
                entrenador.setPokemonActual(nuevoPokemon);
                System.out.println("Has elegido al pokemon " + nuevoPokemon.getClass().getSimpleName() + " en tu equipo.");
            } else {
                System.out.println("La opción no ha sido valida, trata de nuevo con un nuevo digito.");
            }
    }
    }
}