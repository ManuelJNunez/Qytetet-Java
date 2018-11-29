/*
package modeloqytetet;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
        
        int desplazamiento = juego.tirarDado();
        System.out.println("El jugador " + juego.getJugadorActual().getNombre() + " se desplaza: " + desplazamiento + " casillas.");
        juego.mover(4);
        juego.comprarTituloPropiedad();
        juego.edificarCasa(4);
        System.out.println(juego.obtenerCasillaJugadorActual());
        System.out.println(juego.getJugadorActual());
        juego.siguienteJugador();
        desplazamiento = juego.tirarDado();
        System.out.println("El jugador " + juego.getJugadorActual().getNombre() + " se desplaza: " + desplazamiento + " casillas.");
        juego.mover(4);
        System.out.println(juego.getJugadorActual());
        juego.siguienteJugador();
        juego.mover(3);
        System.out.println(juego.getJugadorActual());
        System.out.println(juego.getCartaActual());
        juego.aplicarSorpresa();
        juego.venderPropiedad(4);
        System.out.println(juego.getJugadorActual());
        juego.obtenerRanking();
        
        ArrayList<Jugador> jugadores = juego.getJugadores();
        
        for(Jugador player: jugadores)
            System.out.println(player);
    }
}
*/