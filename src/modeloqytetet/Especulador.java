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
    
    @Override
    protected void pagarImpuesto(){
        super.modificarSaldo(-super.getCasillaActual().getCoste()/2);
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
        return super.deboIrACarcel() && !this.pagarFianza();
    }
    
    boolean pagarFianza(){
        boolean pagada = this.tengoSaldo(fianza);
        if(pagada)
            this.modificarSaldo(-fianza);
        
        return pagada;
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
        return super.toString() + "\nSoy especulador.";
    }
}
