package dominio.juego;

import dominio.EventoFachada;
import dominio.Fachada;
import dominio.usuario.UsuarioJugador;
import java.util.ArrayList;
import java.util.List;
import utilidades.Observable;

public class Mesa extends Observable {

    private static int contadorNumeroMesa = 1; //con esto genero que sea autogenerado
    private int numeroMesa;
    private int apuestaBase;
    private int cantidadJugadoresRequerido;
    private int cantidadJugadoresActual;
    private int porcentajeComision;
    private EstadoMesa estadoMesa; //To Do ver si es una clase o un enum 
    private int totalApostadoMesa; //en todas las manos// es la sumatoria de lo que apuestan los jugadores para cada mano + el pozo base para cada mano
    private int recaudacionTotalMesa;  //en todas las manos
    //private int pozoTotal; // a que refiere este atributo?? es necesario?

    private ArrayList<UsuarioJugador> listaJugadores;// puede no coincidir con la lista de jugadores de la mano poruqe pueden optar por pasar
    private ArrayList<Mano> listaManos;

    public Mesa(int apuestaBase, int cantidadJugadoresRequerido, int porcentajeComision) {
        this.numeroMesa = contadorNumeroMesa++;
        this.apuestaBase = apuestaBase;
        this.cantidadJugadoresRequerido = cantidadJugadoresRequerido;
        this.cantidadJugadoresActual = 0;
        this.porcentajeComision = porcentajeComision;
        this.estadoMesa = EstadoMesa.ABIERTA;
        this.totalApostadoMesa = 0;
        this.recaudacionTotalMesa = 0;
        //this.pozoTotal = 0;

        this.listaJugadores = new ArrayList<UsuarioJugador>();
        this.listaManos = new ArrayList<Mano>();
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(int apuestaBase) {
        this.apuestaBase = apuestaBase;
    }

    public int getCantidadJugadoresRequerido() {
        return cantidadJugadoresRequerido;
    }

    public void setCantidadJugadoresRequerido(int cantidadJugadoresRequerido) {
        this.cantidadJugadoresRequerido = cantidadJugadoresRequerido;
    }

    public int getCantidadJugadoresActual() {
        return cantidadJugadoresActual;
    }

    public void setCantidadJugadoresActual(int cantidadJugadoresActual) {
        this.cantidadJugadoresActual = cantidadJugadoresActual;
    }

    public int getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(int porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getTotalApostadoMesa() {
        return totalApostadoMesa;
    }

//    public void setTotalApostadoMesa(int totalApostadoMesa) {
//        this.totalApostadoMesa = totalApostadoMesa;
//    }
    public int getRecaudacionTotalMesa() {
        return recaudacionTotalMesa;
    }

    public ArrayList<UsuarioJugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<UsuarioJugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public ArrayList<Mano> getListaManos() {
        return listaManos;
    }

    public void setListaManos(ArrayList<Mano> listaManos) {
        this.listaManos = listaManos;
    }

    public int totalApostadoMesaTotalManos() {
        int totalApostado = 0;
        for (Mano mano : listaManos) {
            totalApostado += mano.getTotalApostadoMano();
        }
        this.totalApostadoMesa = totalApostado;
        return totalApostadoMesa;
    }

    public int recaudacionTotal() {
        int recaudacionTotal = totalApostadoMesa * porcentajeComision / 100;
        this.recaudacionTotalMesa = recaudacionTotal;
        return recaudacionTotalMesa;
    }

    public void verificarEstadoMesa() {
        if (this.estadoMesa == EstadoMesa.ABIERTA && cantidadJugadoresRequerido == cantidadJugadoresActual) {
            this.estadoMesa = EstadoMesa.INICIADA;
        }
        if (this.estadoMesa == EstadoMesa.INICIADA && cantidadJugadoresActual < 2) {
            this.estadoMesa = EstadoMesa.FINALIZADA;
        }
    }

    public int actualizarJugadoresActuales() {
        int cantidadJugadores = listaJugadores.size();
        this.cantidadJugadoresActual = cantidadJugadores;
        this.avisar(EventoJuego.MESA_ACTUALIZARJUGADORES);
        Fachada.getInstancia().avisar(EventoFachada.MESA_ACTUALIZARJUGADORES);

        return cantidadJugadoresActual;
    }

    public void actualizarJugadoresActualesIngreso() {
        int cantidadJugadores = listaJugadores.size();
        this.cantidadJugadoresActual = cantidadJugadores;
        this.avisar(EventoJuego.MESA_ACTUALIZARJUGADORES);
        Fachada.getInstancia().avisar(EventoFachada.MESA_ACTUALIZARJUGADORES);

    }

    public void validar() throws SistemaJuegoException {
        if (this.apuestaBase < 1) {
            throw new SistemaJuegoException("Apuesta base inválida.");
        }
        //todo cambiar cantidad jugadores
        if (this.cantidadJugadoresRequerido > 5 || this.cantidadJugadoresRequerido < 2) {
            throw new SistemaJuegoException("Cantidad de jugadores no valida");
        }
        if (this.porcentajeComision < 1 || this.porcentajeComision > 50) {
            throw new SistemaJuegoException("Comision inválida");
        }
    }
//cuando haga el metodo crearMano o como quiera llamarse, 
//ahi tengo que verificar si el saldo del jugador es igual o menor a la apuesta base, lo saco 
//o si él eligio el boton de salir tambien sale de la mesa y se actualiza el Nº de jugadores actuales

    public void validarSaldoInicial(int saldoJugador) throws SistemaJuegoException {
        int apuestaBase = this.getApuestaBase();
        int saldoRequerido = apuestaBase * 10;

        if (saldoJugador < saldoRequerido) {
            throw new SistemaJuegoException("Saldo insuficiente");
        }
    }
    

    public ArrayList<Mano> getManos() {
        return listaManos;
    }

    //Mano
    //Descontar el saldo de los jugadores y formar el pozo inicial 
    public void iniciarMesa() {
        this.setEstadoMesa(EstadoMesa.INICIADA);
        this.iniciarMano(this.getListaJugadores());
        this.avisar(EventoJuego.MESA_INICIADA);
        Fachada.getInstancia().avisar(EventoFachada.MESA_INICIADA);

    }

    public void iniciarMano(ArrayList<UsuarioJugador> listaJugadores) {
        Mano mano = new Mano(listaJugadores);
        listaManos.add(mano);
        mano.iniciarJugadaMano(this.apuestaBase);
        this.avisar(EventoJuego.MANO_ESPERANDOAPUESTA);
        Fachada.getInstancia().avisar(EventoFachada.MANO_ESPERANDOAPUESTA);     
    }
    
    public void iniciarMano(ArrayList<UsuarioJugador> listaJugadores, int pozoAcumulado) {
        Mano mano = new Mano(listaJugadores, pozoAcumulado);
        listaManos.add(mano);
        mano.iniciarJugadaMano(this.apuestaBase);
        this.avisar(EventoJuego.MANO_ESPERANDOAPUESTA);
        Fachada.getInstancia().avisar(EventoFachada.MANO_ESPERANDOAPUESTA);     
    }


}
