
package dominio.juego;

public abstract class TipoFigura {
    
    private String nombreFigura;

    public TipoFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    @Override
    public String toString() {
        return "Figura" + nombreFigura;
    }
    
 
    public void validar(String nombreFigura){
        
    }
}
