/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manu
 */
public class PruebaQytetet {
    static Qytetet juego = Qytetet.getInstance();
    
    public PruebaQytetet(){}
    
    private ArrayList ValorMayorQueCero(){
        ArrayList<Sorpresa> mazo = juego.getMazo();
        ArrayList<Sorpresa> mayorquecero = new ArrayList<>();
        
        for(int i = 0; i < mazo.size(); ++i){
            if(mazo.get(i).getValor() > 0)
                mayorquecero.add(mazo.get(i));
        }
        
        return mayorquecero;
    }
    private ArrayList CartasIrA(){
        ArrayList<Sorpresa> mazo = juego.getMazo();
        ArrayList<Sorpresa> iracasilla = new ArrayList<>();
        
        for(int i = 0; i < mazo.size(); ++i){
            if(mazo.get(i).getTipo() == TipoSorpresa.IRACASILLA)
                iracasilla.add(mazo.get(i));
        }
        
        return iracasilla;
    }
    
    private ArrayList FiltrarTipo(TipoSorpresa tipo){
        ArrayList<Sorpresa> mazo = juego.getMazo();
        ArrayList<Sorpresa> iracasilla = new ArrayList<>();
        
        for(int i = 0; i < mazo.size(); ++i){
            if(mazo.get(i).getTipo() == tipo)
                iracasilla.add(mazo.get(i));
        }
        
        return iracasilla;
    }
    
    private static final Scanner sc = new Scanner (System.in);
    
    public ArrayList getNombreJugadores(){
        ArrayList<String> nombres = new ArrayList();        
        
        System.out.print("Introduce el numero de jugadores: ");
        int n = sc.nextInt();
        if(n <= juego.MAX_JUGADORES && n >= 2){
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
    
    public static void main(String []args){
        PruebaQytetet prueba = new PruebaQytetet();
        ArrayList<String> nombres = prueba.getNombreJugadores();
        
        juego.inicializarJuego(nombres);
        
        System.out.println(juego.getJugadores());
        
        ArrayList<Sorpresa> filtrado = juego.getMazo();
        
        for(Sorpresa s: filtrado)
            System.out.println(s);
        
        filtrado = prueba.ValorMayorQueCero();
        
        System.out.println("\nCartas con valor mayor que 0:");
        
        for(Sorpresa s: filtrado)
            System.out.println(s);
        
        filtrado = prueba.CartasIrA();
        
        System.out.println("\nCartas del tipo IrA:");
        
        for(Sorpresa s: filtrado)
            System.out.println(s);
        
        System.out.println("");
        
        for(TipoSorpresa tipo: TipoSorpresa.values()){
            System.out.println("Sorpresas del tipo: " + tipo);
            filtrado = prueba.FiltrarTipo(tipo);
            for(Sorpresa s: filtrado)
                System.out.println(s);
        }
        System.out.println(juego.getTablero());
    }
}
