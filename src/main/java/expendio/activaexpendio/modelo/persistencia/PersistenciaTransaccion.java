/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expendio.activaexpendio.modelo.persistencia;

import expendio.activaexpendio.modelo.Transaccion;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PersistenciaTransaccion {
    ArrayList<Transaccion> listaTransacciones;
    
    public PersistenciaTransaccion(){
        listaTransacciones = new ArrayList<>();
    }
    
    
}
