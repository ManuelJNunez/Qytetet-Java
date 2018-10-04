package modeloqytetet;
/**
 *
 * @author Fernando Roldán
 */

public class Casilla {
    
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    //Tipo Calle
    public Casilla(int numCasilla, TituloPropiedad tp)
    {
        this.numeroCasilla = numCasilla;
        this.tipo = TipoCasilla.CALLE;
        setTitulo(tp);
        this.coste = titulo.getprecioCompra();
    
    }
   
   ///Cualquier otro tipo
    public Casilla(int numCasilla, TipoCasilla tipo, int price) 
    {
        this.numeroCasilla = numCasilla;
        this.tipo = tipo;
        this.titulo = null;
        this.coste = price;
    }
    
    public int getNumeroCasilla(){ return numeroCasilla; }
    
    public int getCoste() {return coste;}
    
    public TipoCasilla getTipo() {return tipo;}
    
    public TituloPropiedad getTitulo() {return titulo;}
    
    private void setTitulo(TituloPropiedad tp) 
    {
        this.titulo = tp;
    }
    @Override
    public String toString() {
        return "Numero de Casilla: " + numeroCasilla + " - Coste: " + coste + " - Tipo de Casilla: " + tipo + " - Titulo de Propiedad:\n " + titulo;
    }
    
    
}
