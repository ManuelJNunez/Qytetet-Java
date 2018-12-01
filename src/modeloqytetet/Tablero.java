package modeloqytetet;
import java.util.ArrayList;
/**
 *
 * @author Fernando Roldán
 */
public class Tablero {
    private ArrayList<Casilla> casillas = new ArrayList<>();
    private Casilla carcel;
    
    public Tablero (){
        inicializar();
    }
    
    ArrayList getCasillas(){
        return casillas;
    }
    
    public Casilla getCarcel () {return carcel;}
    
    private void inicializar(){
        TituloPropiedad titulo;
        this.casillas = new ArrayList();
        this.casillas.add(new OtraCasilla(0, 1000, TipoCasilla.SALIDA));
        titulo = new TituloPropiedad ("Avenida de Andalucia", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (1, titulo));
        titulo = new TituloPropiedad ("Avenida de la Constitución", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (2, titulo));
        this.casillas.add(new OtraCasilla (3, 0, TipoCasilla.SORPRESA));
        titulo = new TituloPropiedad ("Parque Almunia", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (4, titulo));
        this.casillas.add(new OtraCasilla (5, 0, TipoCasilla.CARCEL));
        titulo = new TituloPropiedad ("Gran Vía de Colón", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (6, titulo));
        this.casillas.add(new OtraCasilla (7, 0, TipoCasilla.SORPRESA));
        titulo = new TituloPropiedad ("Avenida de Dilar", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (8, titulo));
        titulo = new TituloPropiedad ("Camino de Ronda", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (9, titulo));
        this.casillas.add(new OtraCasilla (10, 0, TipoCasilla.PARKING));
        titulo = new TituloPropiedad ("Recogidas", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (11, titulo));
        titulo = new TituloPropiedad ("Avenida de Juan Pablo II", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (12, titulo));
        this.casillas.add(new OtraCasilla (13, 0, TipoCasilla.SORPRESA));
        titulo = new TituloPropiedad ("Plaza de Bib-Rambla", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (14, titulo));
        this.casillas.add(new OtraCasilla (15, 0, TipoCasilla.JUEZ));
        titulo = new TituloPropiedad ("Calle Mesones", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (16, titulo));
        titulo = new TituloPropiedad ("Jardines del Triunfo", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (17, titulo));
        this.casillas.add(new OtraCasilla(18, 250, TipoCasilla.IMPUESTO));
        titulo = new TituloPropiedad ("Calle Acera del Darro", 800, 500, 10, 60, 200);
        this.casillas.add(new Calle (19, titulo));
        
        this.carcel = this.casillas.get(5);
    }
    
    boolean esCasillaCarcel(int numeroCasilla){
        if(numeroCasilla == this.carcel.getNumeroCasilla())
            return true;
        else 
            return false;
    }
    
    Casilla obtenerCasillaFinal(Casilla casilla, int desplazamiento){
       int obtener = casilla.getNumeroCasilla() + desplazamiento;
       
       if(obtener > 19)
           obtener = obtener % 20;
       
       return casillas.get(obtener);
    }
    
     Casilla ObtenerCasillaNumero(int casilla){
        if(casilla >= 0 && casilla <= 19)
            return casillas.get(casilla);
        else
            return null;
    }
    
    @Override
    public String toString() {
        return "Casillas = " + casillas + ", carcel = " + carcel;
    }
    
}
