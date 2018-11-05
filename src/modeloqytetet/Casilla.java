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
        this.coste = titulo.getPrecioCompra();
    
    }
   
   ///Cualquier otro tipo
    public Casilla(int numCasilla, TipoCasilla tipo, int price) 
    {
        this.numeroCasilla = numCasilla;
        this.tipo = tipo;
        this.titulo = null;
        this.coste = price;
    }
    
    public Casilla(int numCasilla, TipoCasilla tipo){
        this.numeroCasilla = numCasilla;
        this.tipo = tipo;
    }
    
    TituloPropiedad asignarPropietario(Jugador jugador){
        this.titulo.setPropietario(jugador);
        return titulo;
    }
    
    public int getNumeroCasilla(){
        return numeroCasilla;
    }
    
    public int getCoste() {
        return coste;
    }
    
    public TipoCasilla getTipo() {
        return tipo;
    }
    
    public TituloPropiedad getTitulo() {
        return titulo;
    }
    
    int pagarAlquiler(){
        int costeAlquiler = this.titulo.pagarAlquiler();
        return costeAlquiler;
    }
    
    boolean propietarioEncarcelado(){
        return titulo.propietarioEncarcelado();
    }
    
    public void setTitulo(TituloPropiedad tp) 
    {
        this.titulo = tp;
    }
    
    boolean soyEdificable(){
        return tipo == TipoCasilla.CALLE;
    }
    
    boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }
    
    @Override
    public String toString() {
        return "Numero de Casilla: " + numeroCasilla + " - Coste: " + coste + " - Tipo de Casilla: " + tipo + " - Titulo de Propiedad:\n " + titulo;
    }
}
