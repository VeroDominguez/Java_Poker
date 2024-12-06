
package dominio.usuario;

import java.util.Date;


public class Sesion {
    private Usuario usuario;
    private Date fechaIngreso = new Date();

    public Sesion(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    @Override
    public boolean equals(Object o){
        Sesion s = (Sesion)o;
        return usuario.equals(s.usuario);         
    }
  
    
}
