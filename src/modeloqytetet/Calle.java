package modeloqytetet;
/**
 *
 * @author Fernando Roldán
 */
public class Calle extends Casilla {
    private TituloPropiedad titulo;
    
    Calle (int numCasilla, TituloPropiedad tp){
        super(numCasilla, tp.getPrecioCompra(), TipoCasilla.CALLE, tp);
        titulo = tp;
    }
    
    public void asignarPropietario(Jugador jugador){
        titulo.setPropietario(jugador);
    }
    
    protected TipoCasilla getTipo(){
        return TipoCasilla.CALLE;
    }
    
    protected TituloPropiedad getTitulo(){
        return super.getTitulo();
    }
    
    public boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }
    
    public int pagarAlquiler(){
        int costeAlquiler = titulo.pagarAlquiler();
        return costeAlquiler;
    }
    
    public void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    protected boolean soyEdificable(){
        return super.soyEdificable();
    }
    
}
