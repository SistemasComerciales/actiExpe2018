/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expendio.activaexpendio.modelo.persistencia;

import expendio.activaexpendio.modelo.Producto;
import expendio.activaexpendio.modelo.Transaccion;
import expendio.activaexpendio.modelo.TransaccionItem;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PersistenciaTransaccion {
    private ArrayList<Transaccion> listaTransacciones;
    
    public PersistenciaTransaccion(){
        listaTransacciones = new ArrayList<>();
    }

    /**
     * @return the listaTransacciones
     */
    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    /**
     * @param listaTransacciones the listaTransacciones to set
     */
    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
    
     /**
     * metodo que permite adicionar una transaccion a la persistencia;
     * @param transaccion
     * @return transaccion
     */
    public Transaccion adicionar(Transaccion transaccion){
        transaccion.setId(listaTransacciones.size()+1);
        listaTransacciones.add(transaccion);
        return transaccion;
    } 
    
        /**
     * metodo que modifica una transaccion
     * @param transaccion
     * @return transaccion
     */
    public Transaccion modificar(Transaccion transaccion){
        Long id = transaccion.getId();
        for (int i = 0; i <= listaTransacciones.size(); i++) {
            if (id == listaTransacciones.get(i).getId()) {
               listaTransacciones.set(i, transaccion);
            return transaccion;

            }
        }
        return  null;
    }

     /**
     * metodo que valida si existe o no por numero
     * @param transaccion
     * @return true: existe , false: no existe
     */
    public boolean validarExiste(Transaccion transaccion){
        for (int i = 0; i < listaTransacciones.size(); i++) {
            if (transaccion.getNumero().equals(listaTransacciones.get(i).getNumero())) {
                    return true;
            }
        }
        return false;
    }
    
        /**
     * metodo que consulta una transaccion por id
     * @param id
     * @return null si no hay conincidencia o la transaccion encontrada
     */
    public Transaccion colsultarPorId(String id){
        for (int i = 0; i < listaTransacciones.size() ; i++) {
            if (id.equals( listaTransacciones.get(i).getId() ) ) {
                return listaTransacciones.get(i);
            }
        }
        return null;
    }
    
         /**
     * metodo que consulta una transaccion por codigo
     * @param codigo
     * @return null si no hay conincidencia o la transaccion encontrada
     */
    public Transaccion colsultarPorCodigo(String codigo){
        for (int i = 0; i < listaTransacciones.size() ; i++) {
            if (codigo.equals( listaTransacciones.get(i).getNumero() ) ) {
                return listaTransacciones.get(i);
            }
        }
        return null;
    }
    
    
    
    
    //////////////// METODOS PARA ITEM ////////////////////////
    
         /**
     * metodo que permite adicionar una item a transaccion y  la persistencia;
     * @param transaccionItem
     * @param transaccion
     * @return transaccion
     */
    public Transaccion adicionar(TransaccionItem transaccionItem, Transaccion transaccion){
        ArrayList<TransaccionItem> items;
        items = transaccion.getListItem();
        items.add(transaccionItem);
        transaccion.setListItem(items);
        return transaccion;
    }
    
        /**
     * metodo que modifica una bodega
     * @param transaccionItem
     * @param transaccion
     * @return transaccion
     */
    public Transaccion modificar(TransaccionItem transaccionItem, Transaccion transaccion){
        ArrayList<TransaccionItem> items;
        items = transaccion.getListItem();
        
        Producto producto = transaccionItem.getProducto();
        String codigoProducto = producto.getCodigo();
        
        for (int i = 0; i <= items.size(); i++) {
            if (codigoProducto.equals( items.get(i).getProducto().getCodigo() ) ) {
                items.set(i, transaccionItem);
                transaccion.setListItem(items);
            return transaccion;
            }
        }
        return  null;
    }
    
         /**
     * metodo que valida si existe o no codigo producto
     * @param transaccion
     * @param transaccionItem
     * @return true: existe , false: no existe
     */
    public boolean validarExisteItem(Transaccion transaccion, TransaccionItem transaccionItem){
        ArrayList<TransaccionItem> items;
        items = transaccion.getListItem();
        
        Producto producto = transaccionItem.getProducto();
        String codigoProducto = producto.getCodigo();
        
        for (int i = 0; i < items.size(); i++) {
            if (codigoProducto.equals( items.get(i).getProducto().getCodigo() ) ) {
                    return true;
            }
        }
        return false;
    }
    
    
}
