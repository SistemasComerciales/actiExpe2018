/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expendio.activaexpendio.modelo;

import expendio.activaexpendio.vista.*;
import java.awt.EventQueue;
import javax.swing.SwingWorker;
import utils.ValidacionApertura;

/**
 *
 * @author Administrador
 */
public class MainExpendio {

    public static final ValidacionApertura control = ValidacionApertura.getInstance("imagenes\\Activa");

    public static void main(String[] args) {
        main();
    }

    private static void main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    /// estas dos lineas suavisan el dibujado del los textos del las ventanas no quitar
                    System.setProperty("awt.useSystemAAFontSettings", "on");
                    System.setProperty("swing.aatext", "true");
                    @SuppressWarnings("rawtypes")
                    final SwingWorker work = new SwingWorker() {
//                        GUIInicio a = new GUIInicio();

                        @Override
                        protected Object doInBackground() throws Exception {
                            /*if (!"N".equals(Configuracion.validacionApertura)) */{
                                if (!MainExpendio.control.comprobar()) {
                                    System.exit(0);
                                }
                            }

                            Establecimiento establecimiento = new Establecimiento();
                            establecimiento.setCodigo("530");
                            establecimiento.setNombre("QUIBDÓ");
                            establecimiento.setNit("");
                            establecimiento.setTipo("P");
                            
                            Usuario usuario = new Usuario();
                            usuario.setPeriodoContable("2018");
                            usuario.setLogin("SUPERVISOR");
                            usuario.setNombres("Supervisor");
                            new GUIMenu(usuario, establecimiento).setVisible(true);
                            return null;
                        }
                    };
                    work.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                    control.cerrarApp();
                }
            }
        });
    }

}
