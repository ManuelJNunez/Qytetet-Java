/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuarioQytetet;
import java.util.ArrayList;
import java.util.Scanner;
import modeloqytetet.Qytetet;

/**
 *
 * @author manu
 */
public class InterfazUsuarioQytetet {
    private Qytetet modelo;
    
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
    
    public int obtenerOpcionMenu(ArrayList<String> operacionesJuegoValidas){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int elegirCasilla(int opcionMenu){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<String> obtenerOperacionesJuegoValidas(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean necesitaElegirCasilla(int opcionMenu){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void realizarOperacion(int opcionElegida, int casillaElegida){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrrectos){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int elegirOperacion(){
        throw new UnsupportedOperationException("Sin implementar");
    }
}
