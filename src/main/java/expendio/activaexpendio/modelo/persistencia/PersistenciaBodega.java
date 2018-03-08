/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expendio.activaexpendio.modelo.persistencia;

import expendio.activaexpendio.modelo.Bodega;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PersistenciaBodega {

    private ArrayList<Bodega> listaBodegas;

    public PersistenciaBodega() {
        listaBodegas = new ArrayList<>();
    }

    /**
     * @return the listaBodegas
     */
    public ArrayList<Bodega> getListaBodegas() {
        return listaBodegas;
    }

    /**
     * @param listaBodegas the listaBodegas to set
     */
    public void setListaBodegas(ArrayList<Bodega> listaBodegas) {
        this.listaBodegas = listaBodegas;
    }

    /**
     * metodo que permite adicionar una bodega a la persistencia;
     */
    private void adicionarBodega(){
           
    }    
    
}
