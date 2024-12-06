/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.usuario;

import dominio.juego.Mesa;
import java.util.ArrayList;

public class UsuarioAdministrador extends Usuario {
    
    public ArrayList<Mesa> mesas= new ArrayList();
            
    public UsuarioAdministrador(String cedula, String password, String nombreCompleto) {
        super(cedula, password, nombreCompleto);
    }
    
    
}
