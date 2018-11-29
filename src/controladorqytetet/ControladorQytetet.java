package controladorqytetet;

import java.util.ArrayList;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.EstadoJuego;
import modeloqytetet.Qytetet;

/**
 *
 * @author manu
 */
public class ControladorQytetet {
    private static ControladorQytetet instance = new ControladorQytetet();
    private ArrayList<String> nombreJugadores = new ArrayList<>();
    private Qytetet modelo = Qytetet.getInstance();
    
    private ControladorQytetet(){}
    
    public static ControladorQytetet getInstance(){
        return instance;
    }
    
    public void setNombreJugadores(ArrayList<String> nombreJugadores){
        this.nombreJugadores = nombreJugadores;
    }
    
    public ArrayList<Integer> obtenerOperacionesJuegoValidas(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean necesitaElegirCasilla(int opcionMenu){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Integer> obtenerCasillasValidas(int opcionMenu){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public String realizarOperacion(int opcionElegida, int casillaElegida){
        throw new UnsupportedOperationException("Sin implementar");
    }
}
