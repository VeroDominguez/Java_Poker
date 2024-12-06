package dominio.juego;

import dominio.usuario.UsuarioJugador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utilidades.Observable;

public class Jugada extends Observable {

    private UsuarioJugador jugador;
    private SituacionJugada situacionJugada;
    private ArrayList<TipoFigura> listaFiguras;
    private TipoFigura figuraFinal;
    private ArrayList<Carta> listaCartasJugada;

    public Jugada(UsuarioJugador jugador, ArrayList<Carta> listaCartasJugada) {
        this.jugador = jugador;
        this.situacionJugada = SituacionJugada.ACCIONPENDIENTE;
        this.listaFiguras = new ArrayList<TipoFigura>();
        this.figuraFinal = null;
        this.listaCartasJugada = listaCartasJugada;
    }

    public Jugada(UsuarioJugador jugador) {
        this.jugador = jugador;

    }

    public UsuarioJugador getJugador() {
        return jugador;
    }

    public void setJugador(UsuarioJugador jugador) {
        this.jugador = jugador;
    }

    public SituacionJugada getSituacionJugada() {
        return situacionJugada;
    }

    public void setSituacionJugada(SituacionJugada situacionJugada) {
        this.situacionJugada = situacionJugada;
    }

    public ArrayList<TipoFigura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(ArrayList<TipoFigura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    public TipoFigura getFiguraFinal() {
        return figuraFinal;
    }

    public void setFiguraFinal(TipoFigura figuraFinal) {
        this.figuraFinal = figuraFinal;
    }

    public ArrayList<Carta> getListaCartasJugada() {
        return listaCartasJugada;
    }

    public void setListaCartasJugada(ArrayList<Carta> listaCartasJugada) {
        this.listaCartasJugada = listaCartasJugada;
    }

//    public void obtenerFigura() {
//
//        int valorFiguraMasAlta = 0;
//        int cantidadMejoresCartasIguales = 0;
//
//        //Para contar cuantas iguales tiene del mismo numero quedandome siempre con la figura mayor
//        //y en caso de dos mismas figuras de distinto valor quedarme con la de valor mas grande
//        for (int i = 2; i <= 14; i++) {
//            int cantCartas = 0;
//
//            for (Carta c : listaCartasJugada) {
//                if (i != 14) {
//                    if (c.getValorCarta() == i) {
//                        cantCartas++;
//                    }
//                } else {
//                    if (c.getValorCarta() == 1) {
//                        cantCartas++;
//                    }
//                }
//            }
//
//            if (cantCartas >= cantidadMejoresCartasIguales) {
//                cantidadMejoresCartasIguales = cantCartas;
//                if (i == 14) {
//                    valorFiguraMasAlta = 1;
//                    this.valorFigura = valorFiguraMasAlta;
//                } else {
//                    valorFiguraMasAlta = i;
//                    this.valorFigura = valorFiguraMasAlta;
//                }
//            }
//        }
//
//        //Me fijo tambien si hay escalera ordenando las cartas y fijandome si estan en secuencia
//        //donde cada carta debe ser un numero mayor a la anterior (para una escalera de 5)
//        Collections.sort(listaCartasJugada);
//        boolean tieneEscalera = true;
//
//        for (int j = 1; j < listaCartasJugada.size(); j++) {
//            if (listaCartasJugada.get(j).getValorCarta() != listaCartasJugada.get(j - 1).getValorCarta() + 1) {
//                tieneEscalera = false;
//            }
//        }
//
//        if (cantidadMejoresCartasIguales == 4) {
//            figuraFinal = new Poker();
//        } else if (tieneEscalera) {
//            figuraFinal = new Escalera();
//        } else if (cantidadMejoresCartasIguales == 3) {
//            figuraFinal = new Pierna();
//        } else if (cantidadMejoresCartasIguales == 2) {
//            figuraFinal = new Par();
//        } else {
//            figuraFinal = new SinFigura();
//                }
//
//        
//    
//
//        }
    
    
    
    @Override
    public boolean equals(Object o
    ) {
        Jugada j = (Jugada) o;
        return jugador.equals(j.jugador);
    }

}
