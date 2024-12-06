/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.juego;

import dominio.EventoFachada;
import dominio.Fachada;
import java.util.ArrayList;
import utilidades.Observable;

public class SistemaJuego extends Observable {

    private ArrayList<Mesa> mesas = new ArrayList();

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public int totalRecaudadoMesas() {
        int totalRecaudado = 0;
        for (Mesa mesa : mesas) {
            totalRecaudado += mesa.getRecaudacionTotalMesa();
        }
        return totalRecaudado;
    }

    public void crearMesa(int apuestaBase, int cantidadJugadoresRequerido, int porcentajeComision) throws SistemaJuegoException {
        Mesa m = new Mesa(apuestaBase, cantidadJugadoresRequerido, porcentajeComision);
        m.validar();
        mesas.add(m);
        avisar(EventoJuego.MESA_NUEVA);
        Fachada.getInstancia().avisar(EventoFachada.MESA_NUEVA);
        // aca es donde el observer debe avisar que hay una nueva mesa
    }

    public Mesa unaMesa(int numeroMesa) {
        int id = numeroMesa;
        Mesa mesaEncontrada = null;
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == id) {
                mesaEncontrada = mesa;
            }
        }
        return mesaEncontrada;
    }
    
    

    public void validarSaldoInicial(int saldoJugador, Mesa mesaSeleccionada)throws SistemaJuegoException 
    {
        mesaSeleccionada.validarSaldoInicial(saldoJugador);
    }

}
