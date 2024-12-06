package dominio.juego;

import panelCartasPoker.CartaPoker;

public class Carta implements CartaPoker {

    private int valorCarta;
    private String paloCarta;
    private boolean visible = true;

    public Carta(int valorCarta, String paloCarta) {
        this.valorCarta = valorCarta;
        this.paloCarta = paloCarta;
    }

    public Carta() {
    }

    @Override
    public int getValorCarta() {
        return valorCarta;
    }

    public void setValor(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    public String getPaloCarta() {
        return paloCarta;
    }

    public void setPaloCarta(String paloCarta) {
        this.paloCarta = paloCarta;
    }

    @Override
    public boolean estaVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean b) {
        visible = b;
        System.out.println(toString());
    }

    public int compareTo(Carta o) {
        return Integer.compare(this.valorCarta, o.valorCarta);
    }

    @Override
    public String toString() {
        return "Carta Ejemplo{" + "numero=" + valorCarta + ", palo=" + paloCarta + ", visible=" + visible + '}';
    }

}
