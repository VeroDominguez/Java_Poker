package obligatoriopoker;

import dominio.Fachada;
import dominio.juego.Carta;
import dominio.juego.Mano;
import dominio.juego.Mazo;
import dominio.juego.SistemaJuegoException;
import dominio.usuario.UsuarioJugador;

import java.util.ArrayList;
import java.util.List;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasPokerException;

public class DatosPrueba {

    /* EJEMPLO
     public static void cargar(){
        Fachada fachada = Fachada.getInstancia();
        
        fachada.agregarTipoContacto("Particular");
        fachada.agregarTipoContacto("Laboral");
        fachada.agregarTipoContacto("Familiar");
        
        fachada.agregarTipoTelefono(new Fijo());
        fachada.agregarTipoTelefono(new Celular());
        fachada.agregarTipoTelefono(new Internacional());
        
        fachada.agregarUsuario("a","a","Ana");
        fachada.agregarUsuario("b","b","Beatriz");
        fachada.agregarUsuario("c","c","Carlos");
        
        fachada.agregarUsuarioAdministrador("admin", "admin", "admin");
        
    }*/
    //Precarga
    public static void cargar() throws SistemaJuegoException{
        Fachada fachada = Fachada.getInstancia();
/*
        //Precarga Figura
        fachada.agregarTipoFigura(new Poker());
        fachada.agregarTipoFigura(new Escalera());
        fachada.agregarTipoFigura(new Pierna());
        fachada.agregarTipoFigura(new Par());
        fachada.agregarTipoFigura(new SinFigura());*/

        //Precarga Jugadores letra
        fachada.agregarUsuarioJugador("0", "0", "J0", 0);
        fachada.agregarUsuarioJugador("1", "1", "J1", 1000);
        fachada.agregarUsuarioJugador("2", "2", "J2", 2000);
        fachada.agregarUsuarioJugador("3", "3", "J3", 3000);
        fachada.agregarUsuarioJugador("4", "4", "J4", 4000);
        fachada.agregarUsuarioJugador("5", "5", "J5", 5000);
        fachada.agregarUsuarioJugador("6", "6", "J6", 6000);
        fachada.agregarUsuarioJugador("7", "7", "J7", 7000);
        fachada.agregarUsuarioJugador("8", "8", "J8", 8000);
        fachada.agregarUsuarioJugador("9", "9", "J9", 9000);

        //Precarga Jugadores adicionales
        fachada.agregarUsuarioJugador("10", "10", "Jugador10", 3420);
        fachada.agregarUsuarioJugador("11", "11", "Jugador11", 5870);
        fachada.agregarUsuarioJugador("12", "12", "Jugador12", 4310);
        fachada.agregarUsuarioJugador("13", "13", "Jugador13", 2995);
        fachada.agregarUsuarioJugador("14", "14", "Jugador14", 1500);

        // public UsuarioJugador(String cedula, String password, String nombreCompleto, int saldo) 
        
        //Precarga Administradores letra
        fachada.agregarUsuarioAdministrador("100", "100", "A 100");
        fachada.agregarUsuarioAdministrador("200", "101", "A 200");
        
        //Precarga Administradores adicionales
        fachada.agregarUsuarioAdministrador("500", "500", "A 500");
        fachada.agregarUsuarioAdministrador("600", "600", "A 600");
        
        //Precarga solo para probar el Administrar mesas
        fachada.crearMesa(5, 5, 2);
        fachada.crearMesa(10, 2, 10);
        fachada.crearMesa(15, 5, 1);
    
    
    }
    
   

  

}
