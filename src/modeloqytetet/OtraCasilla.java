package modeloqytetet;

public class OtraCasilla extends Casilla{
    private TituloPropiedad titulo = null;
    private TipoCasilla tipo;
    OtraCasilla (int numCasilla, int coste, TipoCasilla tipo, TituloPropiedad titulo){
        super(numCasilla, 0, tipo, titulo);
    }
    
    OtraCasilla(int numCasilla, TipoCasilla tipo, int coste){
        super (numCasilla, coste, tipo, null);
    }
    
    OtraCasilla(int numCasilla, TipoCasilla tipo){
        super (numCasilla, 0, tipo, null);
    }

    @Override
    protected TipoCasilla getTipo() {
        return tipo;
    }

    @Override
    protected boolean tengoPropietario() {
        return false;
    }
    
    protected TituloPropiedad getTitulo(){
        return titulo;
    }
    
    protected boolean soyEdificable(){
        return false;
    }
    
}
