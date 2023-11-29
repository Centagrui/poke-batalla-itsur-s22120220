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

    private final boolean primerAtaqueRealizado = false;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public void desarrollarBatalla() {
        
        
       System.out.println("Los juegos del hambre ITSUR 2023, han comenzado  ");
      
        System.out.println(entrenador1.getNombre() + " Contra  " + entrenador2.getNombre());
        System.out.println(" Los pokemones disponibles son:");
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

     private void eligirPokemon(Entrenador entrenadorEnturno) {
         int idx = 1;
         System.out.println("   ");
         for (Pokemon pokemon : entrenadorEnturno.getPokemonsCapturados()) {
             System.out.println(idx + ".- " + pokemon.getClass().getSimpleName());
             idx++;
             System.out.println("   ");
         }
         System.out.println("");
         System.out.println("Escoge un  pokemon " + entrenadorEnturno.getNombre());

         char auxLectura = '0';
         try {
             auxLectura = (char) System.in.read();
             System.in.read((new byte[System.in.available()]));
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         Pokemon pokemonSeleccionado = entrenadorEnturno.getPokemonsCapturados()
                 .get(Character.getNumericValue(auxLectura) - 1);
         entrenadorEnturno.setPokemonActual(pokemonSeleccionado);
     }

   
    private void seleccionarAtaque(Entrenador entrenadorEnturno, Pokemon oponente) {

         Pokemon pokemonActual = entrenadorEnturno.getPokemonActual();

         System.out.println("                             ");
         System.out.println("Seleccione un ataque para " + pokemonActual.getClass().getSimpleName() + ":");
         int opcionAtaque = -1;
         while (true) {
             try {
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 String input = br.readLine();

                 opcionAtaque = Integer.parseInt(input);

                 if (opcionAtaque < 1 || opcionAtaque > pokemonActual.getMovimientos().length) {
                     System.out.println("Elige un ataque valido. Inténtalo de nuevo.");
                 } else {
                     break;
                 }
             } catch (IOException ex) {
                 System.out.println("Entrada invalida. Inténtalo de nuevo.");
                 ex.printStackTrace();
             } catch (NumberFormatException ex) {
                 System.out.println("Ingrese un número válido.");
             }
         }

         entrenadorEnturno.instruirMovimientoAlPokemonActual(oponente, opcionAtaque - 1);
     }
    
 

    private void cambiarPokemon(Entrenador entrenador) {
        System.out.println("Quieres cambiar de pokemon ? (S/N) favor de ingresar las letra minuscula :)");
        char respuesta = 'N';
        while (true) {
            
            try {
                respuesta = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
                break;  
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