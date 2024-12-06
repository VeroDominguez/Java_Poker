package dominio.juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasPokerException;

public class Mazo {

    private List<Carta> listaCartas;

    public Mazo(List<Carta> listaCartas) {
        this.listaCartas = listaCartas;
    }

    // Método estático para crear un mazo completo
    public static Mazo crearMazoCompleto() {
        List<Carta> cartas = new ArrayList<>();

        // Lista de palos válidos
        String[] palos = {CartaPoker.CORAZON, CartaPoker.DIAMANTE, CartaPoker.TREBOL, CartaPoker.PIQUE};

        // Generar las cartas
        for (String palo : palos) {
            for (int valor = CartaPoker.AS; valor <= CartaPoker.K; valor++) {
                cartas.add(new Carta(valor, palo)); // Crear y agregar carta
            }
        }

        // Crear el mazo con las cartas generadas
        return new Mazo(cartas);
    }

    //Baraja el conjunto de cartas en el mazo
    //Utiliza Collections para mezclar las cartas
    public void barajar() {
        Collections.shuffle(listaCartas);
    }

    //Devuelve una carta del mazo y la elimina de la lista
    public Carta repartirCarta() {
        if (!listaCartas.isEmpty()) {
            //Ver si de verdad devuelve una carta 
            return listaCartas.remove(0); // Remueve y retorna la primera carta
        } else {
            throw new IllegalStateException("El mazo está vacío.");
        }
    }

    public List<Carta> getListaCartas() {
        return listaCartas;
    }

    public void setListaCartas(List<Carta> listaCartas) {
        this.listaCartas = listaCartas;
    }

}

