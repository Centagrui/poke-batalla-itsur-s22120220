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
public class CabezazoZen extends MovimientoEstado{

    public  CabezazoZen() {
        this.tipo = Movimiento.TiposDeMovimiento.PSIQUICO;
        this.potencia = 80;
        this.precision = 90;
        this.puntosPoder = 15;        
    }
    
}
