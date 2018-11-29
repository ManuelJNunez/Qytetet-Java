package modeloqytetet;
/**
 *
 * @author Fernando Roldán
 */

public abstract class Casilla {
    
    private int numeroCasilla;
    private int coste = 0;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    public Casilla(int numCasilla, int coste, TipoCasilla tipo, TituloPropiedad titulo)
    {
        this.numeroCasilla = numCasilla;
        this.tipo = tipo;
        this.coste = coste;
        this.titulo = titulo;
    
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
    
    protected abstract TipoCasilla getTipo(); //{return this.tipo;}
    
    protected void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    protected TituloPropiedad getTitulo(){
        return this.titulo;
    }
    
    
    protected boolean soyEdificable(){
        if(this.tipo == TipoCasilla.CALLE )
            return true;
        else
            return false;
    }

    protected abstract boolean tengoPropietario();
    @Override
    public String toString() {
        return "Numero de Casilla: " + numeroCasilla + " - Coste: " + coste + " - Tipo de Casilla: " + tipo + " - Titulo de Propiedad:\n " + titulo;
    }
}
