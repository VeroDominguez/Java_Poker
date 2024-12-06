
package iuswing;

import dominio.Fachada;
import dominio.usuario.Sesion;
import dominio.usuario.Sesionejemplo;
import dominio.usuario.Usuario;
import dominio.usuario.UsuarioAdministrador;
import dominio.usuario.UsuarioException;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginAdministrador extends Login {

    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal);
    }

    /*
    @Override
    public Sesionejemplo login(String username, String password) {
        return Fachada.getInstancia().loginAdministrador(username, password);
    }

    @Override
    public void mostrarProximaInterfaz(Usuario usuario) {
        MonitorUsuariosConectados monitorUsuariosConectados = 
                new MonitorUsuariosConectados(null, false, (UsuarioAdministrador)usuario);
        monitorUsuariosConectados.setVisible(true);
    }*/

    @Override
    public Sesion Login(String usuario, String password) {
        try {
            return Fachada.getInstancia().loginAdministrador(usuario, password);
        } catch (UsuarioException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void mostrarProximaInterfaz(Usuario usuario) {
        //Falta la lógica de sesion para hacer un get usuario en el Login 
        //Ejecuta el cdu administrar mesa

        AdministrarMesas administrarMesas = new AdministrarMesas (null, false,(UsuarioAdministrador) usuario);
        administrarMesas.setVisible(true);
        /*
         MonitorUsuariosConectados monitorUsuariosConectados = 
                new MonitorUsuariosConectados(null, false, (UsuarioAdministrador)usuario);
        monitorUsuariosConectados.setVisible(true);
         */
        //ESTO ES SOLO PARA PROBAR SI SE VE LA LISTA DE CONECTADOS
//        MostrarUsuariosConectados mostrarUsuariosConectados
//                = new MostrarUsuariosConectados(null, false, (UsuarioAdministrador) usuario);
//        mostrarUsuariosConectados.setVisible(true);
//        //  
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
