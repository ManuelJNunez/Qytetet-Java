/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author manu
 */
public class PruebaQytetet {
    static Qytetet juego = new Qytetet();
    
    public static void main(String []args){
        juego.inicializarCartasSorpresa();
        
        for(int i = 0; i < juego.getSize(); ++i){
            System.out.println(juego.getMazo(i).toString());
        }
    }
}
