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

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Hipotecada: " + hipotecada + " - PrecioCompra: " + precioCompra + 
               " - Alquiler Base: " + alquilerBase + " - FactorRevalorizacion: " + factorRevalorizacion + 
                " - hipotecaBase: " + hipotecaBase + " - Precio Edificar: " + precioEdificar + " - numHoteles: " +
                " - numCasas: " + numCasas + "\n"; 
     } 
    
    
}
