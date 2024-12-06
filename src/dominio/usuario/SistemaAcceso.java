package dominio.usuario;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcceso {

    private ArrayList<UsuarioJugador> usuariosJugador = new ArrayList();
    private ArrayList<UsuarioAdministrador> usuariosAdministrador = new ArrayList();
    private ArrayList<Sesion> usuariosLogueados = new ArrayList();

    public void agregarUsuarioJugador(String nombre, String password, String nombreCompleto, int saldo) {
        usuariosJugador.add(new UsuarioJugador(nombre, password, nombreCompleto, saldo));
    }

    public void agregarUsuarioAdministrador(String nombre, String password, String nombreCompleto) {
        usuariosAdministrador.add(new UsuarioAdministrador(nombre, password, nombreCompleto));
    }

    public Sesion loginJugador(String username, String password) throws UsuarioException {
        Sesion sesion = login(username, password, usuariosJugador);
        if (sesion != null) {
            if (usuariosLogueados.contains(sesion)) {
                throw new UsuarioException("Acceso denegado. El usuario ya está logueado.");
            }
            usuariosLogueados.add(sesion);
        }
        return sesion;
    }

    public Sesion loginAdministrador(String username, String password) throws UsuarioException {
        Sesion sesion = login(username, password, usuariosAdministrador);

        if (sesion != null) {
            if (usuariosLogueados.contains(sesion)) {
                throw new UsuarioException("Acceso denegado. El usuario ya está logueado.");
            }
            usuariosLogueados.add(sesion);
        }
        return sesion;
    }

    private Sesion login(String username, String password, List usuarios) {
        Usuario usuario;
        for (Object usuarioObj : usuarios) {
            usuario = (Usuario) usuarioObj;
            if (usuario.validarLogin(username, password)) {
                Sesion sesion = new Sesion(usuario);
                return sesion;
            }
        }
        return null;
    }

    public List<Sesion> getLogueados() {
        return usuariosLogueados;
    }
}
