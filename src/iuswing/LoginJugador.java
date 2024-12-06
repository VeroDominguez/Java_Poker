
package iuswing;

import dominio.Fachada;
import dominio.usuario.Sesion;
import dominio.usuario.Usuario;
import dominio.usuario.UsuarioAdministrador;
import dominio.usuario.UsuarioException;
import dominio.usuario.UsuarioJugador;
import java.awt.Frame;
import javax.swing.JOptionPane;

public class LoginJugador extends Login {

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
    }

    @Override
    public Sesion Login(String usuario, String password) {
        try {
            return Fachada.getInstancia().loginJugador(usuario, password);
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
        
        IngresarAUnaMesa ingresarAUnaMesa = new IngresarAUnaMesa(null, false, (UsuarioJugador) usuario);
        ingresarAUnaMesa.setVisible(true);
    }

}
