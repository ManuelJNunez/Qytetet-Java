package modeloqytetet;

import java.util.ArrayList;
import static modeloqytetet.TipoCasilla.SALIDA;

/**
 *
 * @author manu
 */
public class Jugador {
    private boolean encarcelado;
    private String nombre;
    private int saldo;
    private Sorpresa cartaLibertad;
    private ArrayList<TituloPropiedad> propiedades;
    private Casilla CasillaActual;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        encarcelado = false;
        saldo = 7500;
        cartaLibertad = null;
        propiedades = new ArrayList<>();
        CasillaActual = new Casilla(0, SALIDA, 1000);
    }
    
    Sorpresa getCartaLibertad(){
        return cartaLibertad;
    }
    
    Casilla getCasillaActual(){
        return CasillaActual;
    }
    
    boolean getEncarcelado(){
        return encarcelado;
    }
    
    String getNombre(){
        return nombre;
    }
    
    ArrayList getPropiedades(){
        return propiedades;
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    void setCartaLibertad(Sorpresa carta){
        cartaLibertad = carta;
    }
    
    void setCasillaActual(Casilla casilla){
            CasillaActual = casilla;
    }
    
    void setEncarcelado(boolean encarcelado){
        this.encarcelado = encarcelado;
    }
    
    boolean cancelarHipoteca(TituloPropiedad tp){
        double cantidadRecibida = tp.gethipotecaBase() + tp.getnumCasas()*0.5*tp.gethipotecaBase()+tp.getnumHoteles()*tp.gethipotecaBase();
        return saldo >= cantidadRecibida + cantidadRecibida * 0.1;
    }
    
    boolean comprarTituloPropiedad(){
        return CasillaActual.getTitulo().getPropietario() != null && saldo >= CasillaActual.getTitulo().getprecioCompra();
    }
    
    int CuantasCasasHotelesTengo(){
        int ncasahoteles = 0;
        
        for(TituloPropiedad tp: propiedades)
            ncasahoteles += tp.getnumCasas() + tp.getnumHoteles();
        
        return ncasahoteles;
    }
    
    boolean DeboPagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean estoyEnCalleLibre(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean hipotecarPropiedad(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void irACarcel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int modificarSaldo(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int obtenerCapital(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    ArrayList obtenerPropiedades(boolean hipotecada){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarImpuesto(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarLibertad(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean tengoCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean tengoSalgo(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString(){
        String texto = "\nNombre: " + nombre + "\nSaldo: " + saldo + "\nEncarcelado: " + encarcelado + "\nEstá en la casilla: " + CasillaActual + "\nCarta liberad: " + cartaLibertad + "\nPropiedades:\n";
        
        for(TituloPropiedad tp: propiedades){
            texto += tp + "\n";
        }
        
        return texto;
    }
}
