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
     * @param bodega
     * @return bodega
     */
    public Bodega adicionar(Bodega bodega){
        bodega.setId(listaBodegas.size()+1);
        listaBodegas.add(bodega);
        return bodega;
    } 
    
    /**
     * metodo que modifica una bodega
     * @param bodega
     * @return bodega
     */
    public Bodega modificar(Bodega bodega){
        Long id = bodega.getId();
        for (int i = 0; i <= listaBodegas.size(); i++) {
            if (id == listaBodegas.get(i).getId()) {
               listaBodegas.set(i, bodega);
            return bodega;

            }
        }
        return  null;
    }
    
    /**
     * 
     * @return 
     */
    public Bodega borrar(Bodega bodega){
        Long id = bodega.getId();
        for (int i = 0; i < listaBodegas.size(); i++) {
            if (id.equals(listaBodegas.get(i).getId())) {
                listaBodegas.get(i).setEliminado(true);
                return bodega;
            }
        }
        return null;
    }
        
    /**
     * metodo que valida si existe o no por codigo
     * @param bodega
     * @return true: existe , false: no existe
     */
    public boolean validarExiste(Bodega bodega){
        for (int i = 0; i < listaBodegas.size(); i++) {
            if (bodega.getCodigo().equals(listaBodegas.get(i).getCodigo())) {
                return true;
            }
        }
        return false;
    }
    
    
}
