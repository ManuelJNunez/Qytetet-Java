package modeloqytetet;

import java.util.ArrayList;
import static modeloqytetet.TipoCasilla.SALIDA;

/**
 *
 * @author manu
 */
public class Jugador implements Comparable{
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
    @Override
    public int compareTo(Object otroJugador){
        int otroCapital = ((Jugador) otroJugador).obtenerCapital();
        return otroCapital - obtenerCapital();
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
        boolean cancelar = false;
        int costeCancelar = tp.calcularCosteCancelar();
        boolean tengoSaldo = tengoSaldo(costeCancelar);
        boolean esDeMiPropiedad = esDeMiPropiedad(tp);
      
        if(tengoSaldo && esDeMiPropiedad){
            tp.cancelarHipoteca();
            cancelar = true;
        }
                    
        return cancelar;
    }
    
    boolean comprarTituloPropiedad(){
        boolean comprado = false;
        int costeCompra = this.CasillaActual.getCoste();
        if(costeCompra < this.saldo){
            TituloPropiedad titulo = this.CasillaActual.asignarPropietario(this);
            comprado = true;
            this.propiedades.add(titulo);
            this.modificarSaldo(-costeCompra);
        }
        return comprado;
    }
    
    int CuantasCasasHotelesTengo(){
        int ncasahoteles = 0;
        
        for(TituloPropiedad tp: propiedades)
            ncasahoteles += tp.getNumCasas() + tp.getNumHoteles();
        
        return ncasahoteles;
    }
    
    boolean DeboPagarAlquiler(){
        TituloPropiedad titulo = this.CasillaActual.getTitulo();
        boolean esDeMiPropiedad = this.esDeMiPropiedad(titulo);
        boolean tienePropietario = false;
        boolean encarcelado = true;
        boolean estaHipotecada = true;
        boolean deboPagar;
        if(!esDeMiPropiedad){
            tienePropietario = titulo.tengoPropietario();
            if(tienePropietario){
                encarcelado = titulo.propietarioEncarcelado();
                estaHipotecada = titulo.getHipotecada();
            }
        }
        deboPagar = !esDeMiPropiedad & tienePropietario &!encarcelado & !estaHipotecada;
        return deboPagar;
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa carta = cartaLibertad;
        cartaLibertad = null;
        return carta;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        boolean edificada = false;
        int numCasas = titulo.getNumCasas();
        if(numCasas <4){
            int costeEdificarCasa = titulo.getPrecioEdificar();
            if(this.tengoSaldo(costeEdificarCasa)){
                titulo.edificarCasa();
                this.modificarSaldo(-costeEdificarCasa);
                edificada = true;
            }
        }
        return edificada;
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        boolean edificado = false;
        int numCasas = titulo.getNumCasas(), numHoteles = titulo.getNumHoteles();
        
        if(numHoteles < 4 && numCasas == 4){
            int costeEdificarHotel = titulo.getPrecioEdificar();
            boolean tengoSaldo = this.tengoSaldo(costeEdificarHotel);
            
            if(tengoSaldo){
                titulo.edificarHotel();
                this.modificarSaldo(-costeEdificarHotel);
                edificado = true;
            }
        }
        
        return edificado;
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        this.propiedades.remove(titulo);
        titulo.setPropietario(null);
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo){
        boolean loes = false;
        
        for(TituloPropiedad tp: propiedades){
            if(tp == titulo)
                loes = true;
        }
        
        return loes;
    }
    
    boolean estoyEnCalleLibre(){
        if(this.CasillaActual.soyEdificable() && !this.CasillaActual.tengoPropietario())
            return true;
        else
            return false;
    }
    
    boolean hipotecarPropiedad(TituloPropiedad titulo){
        int costeHipoteca = titulo.hipotecar();
        this.modificarSaldo(costeHipoteca);
        return true; //??
    }
    
    void irACarcel(Casilla casilla){
        this.setCasillaActual(casilla);
        this.setEncarcelado(true);
    }
    
    int modificarSaldo(int cantidad){
        this.saldo += cantidad;
        
        return saldo;
    }
    
    int obtenerCapital(){
        int capital = this.saldo;
        
        for(TituloPropiedad tp: propiedades){
            capital += tp.getPrecioCompra() + (tp.getNumCasas() + tp.getNumHoteles()) * tp.getPrecioEdificar();
            
            if(tp.getHipotecada())
                capital -= tp.getHipotecaBase();
        }
        
        return capital;
    }
    
    ArrayList obtenerPropiedades(boolean hipotecada){
        ArrayList<TituloPropiedad> devolver = new ArrayList<>();
        
        for(TituloPropiedad tp: propiedades){
            if(tp.getHipotecada() == hipotecada)
                 devolver.add(tp);
        }
        
        return devolver;
    }
    
    void pagarAlquiler(){
        int costeAlquiler = this.CasillaActual.pagarAlquiler();
        this.modificarSaldo(-costeAlquiler);
    }
    
    void pagarImpuesto(){
        saldo -= CasillaActual.getCoste();
    }
    
    void pagarLibertad(int cantidad){
        boolean tengoSaldo = tengoSaldo(cantidad);
        if(tengoSaldo){
            this.setEncarcelado(false);
            this.modificarSaldo(-cantidad);
        }
    }
    
    boolean tengoCartaLibertad(){
        if(cartaLibertad != null)
            return true;
        else
            return false;
    }
    
    private boolean tengoSaldo(int cantidad){
        if(saldo > cantidad)
            return true;
        else
            return false;
    }
    
    boolean venderPropiedad(Casilla casilla){
        TituloPropiedad titulo = casilla.getTitulo();
        this.eliminarDeMisPropiedades(titulo);
        int precioVenta = titulo.calcularPrecioVenta();
        this.modificarSaldo(precioVenta);
        casilla.setTitulo(null);
        return true;
    }

    @Override
    public String toString(){
        String texto = "\nNombre: " + nombre + "\nSaldo: " + saldo + "\nCapital: " + this.obtenerCapital() + "\nEncarcelado: " + encarcelado + "\nEstá en la casilla: " + CasillaActual + "\nCarta liberad: " + cartaLibertad + "\nPropiedades:\n";
        
        for(TituloPropiedad tp: propiedades){
            texto += tp + "\n";
        }
        
        return texto;
    }
}
