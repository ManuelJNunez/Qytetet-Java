package modeloqytetet;
/**
 *
 * @author Fernando Roldán
 */

public abstract class Casilla {
    private int numeroCasilla;
    private int coste = 0;
    
    public Casilla(int numCasilla, int coste){
        this.numeroCasilla = numCasilla;
        this.coste = coste;
    }
    
    int getNumeroCasilla(){
        return numeroCasilla;
    }
    
    int getCoste() {
        return coste;
    }
    
    public void setCoste(int coste){
        this.coste = coste;
    }
    
    protected abstract TipoCasilla getTipo();
    
    protected abstract TituloPropiedad getTitulo();
    
    protected abstract boolean soyEdificable();
    
    @Override
    public String toString() {
        return "Numero de Casilla: " + numeroCasilla + " - Coste: " + coste;
    }
}
