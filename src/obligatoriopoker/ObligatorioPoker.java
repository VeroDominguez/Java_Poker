package obligatoriopoker;

import dominio.juego.Carta;
import dominio.juego.Jugada;
import dominio.juego.Mano;
import dominio.juego.Mazo;
import dominio.juego.SistemaJuegoException;
import dominio.usuario.UsuarioJugador;
import iuswing.AdministrarMesas;

import iuswing.VentanaPrincipal;
import java.util.ArrayList;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasPokerException;

public class ObligatorioPoker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SistemaJuegoException {
        // TODO code application logic here
        DatosPrueba.cargar();

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);

//        //fue solo para probar que funcione, falta precargar mesas, jugadores, manos (todo para hacer correr una mesa)
//        AdministrarMesas vistaMesas = new AdministrarMesas();
//        vistaMesas.setVisible(true);
// Crear un mazo completo
        Mazo mazo = Mazo.crearMazoCompleto();

        // Mostrar las cartas del mazo
        for (Carta carta : mazo.getListaCartas()) {
            System.out.println(carta);
        }

        // Barajar las cartas
        mazo.barajar();
        System.out.println("Mazo barajado:");
        for (Carta carta : mazo.getListaCartas()) {
            System.out.println(carta);
        }

        // TODO code application logic here
        ArrayList<CartaPoker> cartas = new ArrayList();

        for (int i = 0; i < 5; i++) {
            cartas.add(mazo.repartirCarta()); // Obtener y agregar la carta
        }

        cartas.add(new Carta(1, CartaPoker.CORAZON));
        cartas.add(new Carta(1, CartaPoker.DIAMANTE));
        cartas.add(new Carta(1, CartaPoker.TREBOL));
        cartas.add(new Carta(1, CartaPoker.PIQUE));
        cartas.add(new Carta(11, CartaPoker.PIQUE));

        
    }
        

    

}
