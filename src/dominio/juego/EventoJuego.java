/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.juego;


public enum EventoJuego {
    MESA_NUEVA, MESA_INICIADA, MESA_FINALIZADA,
    MESA_ACTUALIZARJUGADORES,
    
    MANO_ESPERANDOAPUESTA,
    MANO_APUESTAINICIADA,
    MANO_PIDIENDOCARTAS,
    MANO_TERMINADA,
    
    JUGADOR_ACCIONPENDIENTE,
    JUGADOR_APUESTAINICIADA,
    JUGADOR_APUESTAPAGADA,
    JUGADOR_NOPAGOAPUESTA
    
}
