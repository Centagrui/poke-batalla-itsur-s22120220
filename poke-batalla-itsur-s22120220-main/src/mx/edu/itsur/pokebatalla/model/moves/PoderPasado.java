/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author perez
 */
public class PoderPasado extends MovimientoEstado{

    public PoderPasado () {
        this.tipo = TiposDeMovimiento.ROCA;
        this.potencia = 60;
        this.precision = 100;
        this.puntosPoder = 5;        
    }
}

    

