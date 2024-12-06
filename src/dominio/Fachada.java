 package dominio;

import dominio.juego.Mesa;
import java.util.ArrayList;
import java.util.List;

import dominio.usuario.SistemaAcceso;
import dominio.juego.SistemaJuego;
import dominio.juego.SistemaJuegoException;
import dominio.usuario.Sesion;
import dominio.usuario.UsuarioException;
import utilidades.Observable;
import utilidades.Observador;

public class Fachada extends Observable{
   
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaJuego sJuego = new SistemaJuego();
    
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }


    public void agregarUsuarioJugador(String cedula, String password, String nombreCompleto, int saldo) {
        sAcceso.agregarUsuarioJugador(cedula, password, nombreCompleto, saldo);
    }

    public void agregarUsuarioAdministrador(String cedula, String password, String nombreCompleto) {
        sAcceso.agregarUsuarioAdministrador(cedula, password, nombreCompleto);
    }

    public Sesion loginJugador(String cedula, String password) throws UsuarioException {
        return sAcceso.loginJugador(cedula, password);
    }

    public Sesion loginAdministrador(String cedula, String password) throws UsuarioException {
        return sAcceso.loginAdministrador(cedula, password);
    }

   
     public List<Sesion> getLogueados() {
        return sAcceso.getLogueados();
    }

    public int totalRecaudadoMesas(){
        return sJuego.totalRecaudadoMesas();
    }
    
    public ArrayList<Mesa> getMesas(){
        return sJuego.getMesas();
    }
    
    public void crearMesa(int apuestaBase, int cantidadJugadoresRequerido, int porcentajeComision) throws SistemaJuegoException{
        sJuego.crearMesa(apuestaBase, cantidadJugadoresRequerido, porcentajeComision);
    }
    
    public void agregarObservadorSistemaJuego(Observador ob)
    {
        this.sJuego.agregar(ob);
    }
    
    public Mesa unaMesa(int numeroMesa){
        return sJuego.unaMesa(numeroMesa);
       
    }
            
}
