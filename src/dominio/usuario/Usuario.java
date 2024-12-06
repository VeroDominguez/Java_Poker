
package dominio.usuario;

public abstract class Usuario {
    
    protected String cedula;
    protected String nombreCompleto;
    protected String password;

    public Usuario(String cedula, String password, String nombreCompleto) {
        this.cedula = cedula;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }
  
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean validarLogin(String cedula, String password) {
        return this.getCedula().equals(cedula) && this.getPassword().equals(password);
    }
}
