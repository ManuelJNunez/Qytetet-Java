package vistatextualqytetet;

import java.util.ArrayList;
import java.util.Scanner;
import modeloqytetet.Qytetet;
import controladorqytetet.*;

/**
 *
 * @author manu
 */
public class VistaTextualQytetet {
    static Qytetet modelo;
    static ControladorQytetet controlador;

    public VistaTextualQytetet() {
        modelo = Qytetet.getInstance();
        controlador = ControladorQytetet.getInstance();
    }
    
    public ArrayList<String> obtenerNombreJugadores(){
        ArrayList<String> nombres = new ArrayList();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el numero de jugadores: ");
        int n = sc.nextInt();
        if(n <= modelo.MAX_JUGADORES && n >= 2){
            String s;
            s = sc.nextLine();
            for (int i = 0 ; i < n ; i++ ){
                System.out.print("Nombre jugador " + i + ": ");
                s = sc.nextLine();
                nombres.add(s);
            }
        }
        return nombres;
    }
    
    public int elegirCasilla(int opcionMenu){
        ArrayList<Integer> casillas = controlador.obtenerCasillasValidas(opcionMenu);
        ArrayList<String> casillass = new ArrayList<>();
        
        if(casillas.isEmpty())
            return -1;
        else{
            for(int i = 0; i < casillas.size(); ++i){
                System.out.print(casillas.get(i) + " ");
                casillass.add(Integer.toString(casillas.get(i)));
            }
            
            return Integer.parseInt(this.leerValorCorrecto(casillass));
        }
    }
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos){
        String orden = "";
        boolean correcto = false;
        Scanner sc = new Scanner(System.in);        
        
        while(!correcto){
            System.out.println("Introduce tu orden: ");
            orden = sc.nextLine();
            
            for(int i = 0; i < valoresCorrectos.size() && !correcto; ++i){
                if(orden.equals(valoresCorrectos.get(i)))
                    correcto = true;
            }
            
            if(!correcto)
                System.out.println("Orden no válida, vuelve a intentarlo.");
        }
        
        return orden;
    }
    
    public int elegirOperacion(){
        ArrayList<Integer> op = controlador.obtenerOperacionesJuegoValidas();
        ArrayList<String> ops = new ArrayList<>();
        
        for(int num: op)
            ops.add(Integer.toString(num));
        
        return Integer.parseInt(this.leerValorCorrecto(ops));
    }
    
    public static void main(String []args){
        VistaTextualQytetet ui = new VistaTextualQytetet();
        controlador.setNombreJugadores(ui.obtenerNombreJugadores());
        int operacionElegida, casillaElegida = 0;
        boolean necesitaElegirCasilla;
        
        do{
            operacionElegida = ui.elegirOperacion();
            necesitaElegirCasilla = controlador.necesitaElegirCasilla(operacionElegida);
            
            if (necesitaElegirCasilla)
                casillaElegida = ui.elegirCasilla(operacionElegida);
            
            if (!necesitaElegirCasilla || casillaElegida >= 0)
                System.out.println(controlador.realizarOperacion(operacionElegida,casillaElegida));
        }while (1 == 1);
    }
}
