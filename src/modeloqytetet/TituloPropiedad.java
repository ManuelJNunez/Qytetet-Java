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
    
    public boolean gethipotecada(){ return hipotecada; }
    
    public int getprecioCompra(){ return precioCompra; }
    
    public int getalquilerBase() { return alquilerBase; }
    
    public float getfactorRevalorizacion() {return factorRevalorizacion; }
    
    public int gethipotecaBase() {return hipotecaBase; }
    
    public int getprecioEdificar() {return precioEdificar; }
    
    public int getnumHoteles() {return numHoteles; }
    
    public int getnumCasas() {return numCasas; }
    
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
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getAlquilerBase(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    float getFactorRevalorizacion(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getHipotecaBase(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean getHipotecada(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    String getNombre(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getNumCasas(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getNumHoteles(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getPrecioCompra(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getPrecioEdificar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int hipotecar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean setHipotecada(boolean hipotecada){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean tengoPropietario(){
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Hipotecada: " + hipotecada + " - PrecioCompra: " + precioCompra + 
               " - Alquiler Base: " + alquilerBase + " - FactorRevalorizacion: " + factorRevalorizacion + 
                " - hipotecaBase: " + hipotecaBase + " - Precio Edificar: " + precioEdificar + " - numHoteles: " +
                " - numCasas: " + numCasas + "\n"; 
     } 
    
    
}
