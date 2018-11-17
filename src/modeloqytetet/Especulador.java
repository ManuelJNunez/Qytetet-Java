package modeloqytetet;

/**
 *
 * @author manu
 */
public class Especulador extends Jugador{
    private int fianza;
    
    Especulador(Jugador jugador, int fianza) {
        super(jugador);
        this.fianza = fianza;
    }
    
    protected void pagarImpuesto(int cantidad){
        super.modificarSaldo(-cantidad/2);
    }
    
    @Override
    protected int getFactorEspeculador(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    @Override
    protected Especulador convertirme(int fianza){
        return this;
    }
    
    @Override
    protected boolean deboIrACarcel(){
        return super.tengoCartaLibertad() && !pagarFianza();
    }
    
    boolean pagarFianza(){
        return super.tengoSaldo(fianza);
    }
    
    @Override
    protected boolean puedoEdificarCasa(TituloPropiedad titulo){
        int numCasas = titulo.getNumCasas(), numHoteles = titulo.getNumHoteles();
        return numCasas < 8;
    }

    @Override
    protected boolean puedoEdificarHotel(TituloPropiedad titulo){
        int numCasas = titulo.getNumCasas(), numHoteles = titulo.getNumHoteles();
        return numCasas >= 4 && numHoteles < 8;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
