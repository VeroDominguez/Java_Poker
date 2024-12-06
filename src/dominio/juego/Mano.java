package dominio.juego;

import dominio.EventoFachada;
import dominio.Fachada;
import dominio.usuario.UsuarioJugador;
import java.util.ArrayList;
import java.util.List;
import utilidades.Observable;

public class Mano extends Observable {

    private static int contadorNumeroMano = 1;
    private int numeroMano;
    private EstadoMano estadoMano;
    private int cantidadJugadoresActivos;
    private int totalApostadoMano;
    private String jugadorGanador;
    private TipoFigura figuraGanadora;
    private Mazo mazo;
    private Mazo mazoJugada;

    private ArrayList<Jugada> listaJugadas;
    private ArrayList<UsuarioJugador> listaJugadores;

    public Mano() {
        this.numeroMano = contadorNumeroMano++;
        this.estadoMano = EstadoMano.ESPERANDOAPUESTA;
        this.cantidadJugadoresActivos = 0;
        this.totalApostadoMano = 0;
        this.jugadorGanador = null;
        this.figuraGanadora = null;
        this.mazo = mazo;

        this.listaJugadas = new ArrayList<Jugada>();
        this.listaJugadores = new ArrayList<UsuarioJugador>();
    }

    public Mano(ArrayList<UsuarioJugador> listaJugadores) {
        this.numeroMano = contadorNumeroMano++;
        this.estadoMano = EstadoMano.ESPERANDOAPUESTA;
        this.cantidadJugadoresActivos = 0;
        this.totalApostadoMano = 0;
        this.jugadorGanador = null;
        this.figuraGanadora = null;
        this.mazo = mazo;

        this.listaJugadas = new ArrayList<Jugada>();
        this.listaJugadores = listaJugadores;
    }
    public Mano(ArrayList<UsuarioJugador> listaJugadores, int totalApostadoMano) {
        this.numeroMano = contadorNumeroMano++;
        this.estadoMano = EstadoMano.ESPERANDOAPUESTA;
        this.cantidadJugadoresActivos = 0;
        this.totalApostadoMano = totalApostadoMano;
        this.jugadorGanador = null;
        this.figuraGanadora = null;
        this.mazo = mazo;

        this.listaJugadas = new ArrayList<Jugada>();
        this.listaJugadores = listaJugadores;
    }

    public int getNumeroMano() {
        return numeroMano;
    }

    public void setNumeroMano(int numeroMano) {
        this.numeroMano = numeroMano;
    }

    public EstadoMano getestadoMano() {
        return estadoMano;
    }

    public void setestadoMano(EstadoMano estadoMano) {
        this.estadoMano = estadoMano;
    }

    public int getCantidadJugadoresActivos() {
        return cantidadJugadoresActivos;
    }

    public void setCantidadJugadoresActivos(int cantidadJugadoresActivos) {
        this.cantidadJugadoresActivos = cantidadJugadoresActivos;
    }

    public int getTotalApostadoMano() {
        return totalApostadoMano;
    }

    public void setTotalApostadoMano(int totalApostadoMano) {
        this.totalApostadoMano = totalApostadoMano;
    }

    public String getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(String jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public TipoFigura getFiguraGanadora() {
        return figuraGanadora;
    }

    public void setFiguraGanadora(TipoFigura figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }

//    public boolean(VER QUE DEVOLVEMOS)  validarParticipacion() {
//// Si no tiene saldo > base lo sacamos 
//        for (UsuarioJugador usuarioJugador : listaJugadores) {
//            int saldoJugador = usuarioJugador.getSaldo();
//            
//            if ()
//            
//        }
//    }
    public void iniciarJugadaMano(int apuestabase) {
        Mazo mazo = Mazo.crearMazoCompleto();
        mazo.barajar(); // Barajar el mazo

        for (UsuarioJugador jugador : listaJugadores) {
            ArrayList<Carta> cartasJugada = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                cartasJugada.add(mazo.repartirCarta()); // Repartir 5 cartas
            }
            Jugada jugada = new Jugada(jugador, cartasJugada);
            listaJugadas.add(jugada); // Agregar la jugada a la lista de la mano

            jugador.actualizarSaldoJugador(apuestabase);
            totalApostadoMano += apuestabase;
            cantidadJugadoresActivos = listaJugadores.size();

        }
        //Guardamos mazo de la mano para cambiar cartas 
        mazoJugada = mazo;

    }

    public void jugar() {

    }

    public void registrarPase(UsuarioJugador jugador) {
        for (Jugada jugada : listaJugadas) {
            if (jugada.getJugador().equals(jugador)) {
                jugada.setSituacionJugada(SituacionJugada.NOPAGOAPUESTA); // Situación específica
                Fachada.getInstancia().avisar(EventoFachada.JUGADOR_NOPAGOAPUESTA);

                break;
            }
        }
    }

    //Verifica si todos pasan
    public boolean todosPasaron() {
        boolean todosPasaron = listaJugadas.stream().allMatch(j -> j.getSituacionJugada() == SituacionJugada.NOPAGOAPUESTA);
        
        if(todosPasaron){
            Fachada.getInstancia().avisar(EventoFachada.MANO_TERMINADA);
            return todosPasaron;
        }
        return todosPasaron;
    }

    public void terminarManoSinGanador() {
        this.estadoMano = EstadoMano.TERMINADA;
        // Acumular el pozo para la siguiente mano
        totalApostadoMano = this.totalApostadoMano;
        // Notificar a los observadores (interfaz gráfica)
        Fachada.getInstancia().avisar(EventoFachada.MANO_TERMINADA);
    }

    public void terminarMano() {

    }

    public static int getContadorNumeroMano() {
        return contadorNumeroMano;
    }

    public static void setContadorNumeroMano(int contadorNumeroMano) {
        Mano.contadorNumeroMano = contadorNumeroMano;
    }

    public EstadoMano getEstadoMano() {
        return estadoMano;
    }

    public void setEstadoMano(EstadoMano estadoMano) {
        this.estadoMano = estadoMano;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public Mazo getMazoJugada() {
        return mazoJugada;
    }

    public void setMazoJugada(Mazo mazoJugada) {
        this.mazoJugada = mazoJugada;
    }

    public ArrayList<Jugada> getListaJugadas() {
        return listaJugadas;
    }

    public void setListaJugadas(ArrayList<Jugada> listaJugadas) {
        this.listaJugadas = listaJugadas;
    }

    public ArrayList<UsuarioJugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<UsuarioJugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

}
