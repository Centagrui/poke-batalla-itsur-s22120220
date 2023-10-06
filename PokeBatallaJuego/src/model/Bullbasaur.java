/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FJML1983
 */
public class Bullbasaur extends Pokemon {

    public Bullbasaur() {
        tipo = "PLANTA/VENENO";
        hp = 45;
        ataque = 49;
        defensa = 49;
        nivel = 1;
        precision = 4;
    }

    //Constructor alterno 1
    public Bullbasaur(String nombre){
        this(); //invocando al constructor default
        this.nombre = nombre;
    }

    public void atacar(Mew pan, String doble_filo) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}