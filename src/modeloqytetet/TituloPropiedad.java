package modeloqytetet;
/**
 *
 * @author Fernando roldán
 */
public class TituloPropiedad {
    private String nombre;
    private boolean hipotecada;
    private int precioCompra;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    private int numHoteles;
    private int numCasas;
    private Jugador propietario;
    
    public TituloPropiedad(String name, int precio, int alquiler, float factorRevalorizacion,  int hipotecaBase, int precioEdificar){
    this.nombre = name;
    this.precioCompra = precio;
    this.alquilerBase = alquiler;
    this.factorRevalorizacion = factorRevalorizacion;
    this.hipotecaBase = hipotecaBase;
    this.precioEdificar = precioEdificar;
    hipotecada = false;
    numHoteles = 0;
    numCasas = 0;
    propietario = null;
    }
    
    public String getnombre(){ return nombre; }
    
    public int getPrecioCompra(){ return precioCompra; }
    
    public int getAlquilerBase() { return alquilerBase; }
    
    public float getFactorRevalorizacion() {return factorRevalorizacion; }
    
    public int getPrecioEdificar() {return precioEdificar; }
    
    public int getNumHoteles() {return numHoteles; }
    
    public int getNumCasas() {return numCasas; }
    
    Jugador getPropietario(){
        return propietario;
    }
    
    void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }
    
    int calcularCosteCancelar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularCosteHipotecar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularImporteAlquiler(){
        int costeAlquiler = this.alquilerBase+ (int)(this.numCasas*0.5 + this.numHoteles*2);
        return costeAlquiler;
    }
    
    int calcularPrecioVenta(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void cobrarAlquiler(int coste){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarCasa(){
        numCasas += 1;
    }
    
    void edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getHipotecaBase(){
        return hipotecaBase;
    }
    
    boolean getHipotecada(){
        return hipotecada;
    }
    
    int hipotecar(){
        this.hipotecada = true;
        int costeHipoteca = this.calcularCosteHipotecar();
        return costeHipoteca;
    }
    
    int pagarAlquiler(){
        int costeAlquiler = this.calcularImporteAlquiler();
        this.propietario.modificarSaldo(costeAlquiler);
        return costeAlquiler;
    }
    
    boolean propietarioEncarcelado(){
        return propietario.getEncarcelado();
    }
    
    boolean setHipotecada(boolean hipotecada){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean tengoPropietario(){
        return propietario != null;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "- Propietario: " + propietario + "- Hipotecada: " + hipotecada + " - PrecioCompra: " + precioCompra + 
               " - Alquiler Base: " + alquilerBase + " - FactorRevalorizacion: " + factorRevalorizacion + 
                " - hipotecaBase: " + hipotecaBase + " - Precio Edificar: " + precioEdificar + " - numHoteles: " +
                " - numCasas: " + numCasas + "\n"; 
     }
    
    
}
