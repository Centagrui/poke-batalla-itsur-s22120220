/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.pokemons;

import java.util.List;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Maria Centagrui PEREZ Alvarez
 */
public abstract class Pokemon {

   //Atributos
    protected String nombre;
    protected int nivel;
    protected int hp;
    protected int ataque;
    protected int defensa;
    protected double precision;
    protected String tipo;
    protected int xp;

    public Pokemon() {
    }
    
     public int getNivel() {
        return nivel;
    }
     
     public int getHp(){
         return hp;
     }
     
    public int getAtaque() {
        return ataque;
    } 
    
    public int getDefensa(){
        return defensa;
    }
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Métodos 
    public void recibirDanio(int danio){
        this.hp = this.hp - danio;
        if(this.hp<=0){
            System.out.println(this.getClass().getSimpleName() + "YA NO PUEDE CONTINUAR");
        }
    }        
    
    public abstract void atacar(Pokemon oponente, int ordinalMovimiento);
    
    public abstract Enum[] getMovimientos();
    
    @Override
    public String toString(){
        if(hp<0){
            return this.getClass().getSimpleName() + "{tipo:" + tipo + " hp:" + "0" + "]";
        }else{
            return this.getClass().getSimpleName() + "[tipo:" + tipo + " hp:" + hp + "]";
        }
    }

    public int gethp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}