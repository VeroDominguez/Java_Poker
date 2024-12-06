
package dominio.usuario;

import dominio.juego.Jugada;

public class UsuarioJugador extends Usuario {
    
    private int saldo;

    public UsuarioJugador(String cedula, String password, String nombreCompleto, int saldo) {
        super(cedula, password, nombreCompleto);
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void actualizarSaldoJugador(int monto){
        this.saldo -= monto;
    }
   
        @Override
    public boolean equals(Object o) {
        UsuarioJugador j = (UsuarioJugador) o;
        return cedula.equals(j.cedula);
    }
}
