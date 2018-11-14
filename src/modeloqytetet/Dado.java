/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author Fernando Roldán
 */
public class Dado {
    private int valor = 0;
    
    private static Dado instance = new Dado();
    
    private Dado(){}
    
    public static Dado getInstance(){
        return instance;
    }
    
    int tirar(){
        valor = (int) Math.floor(Math.random()*6+1);
        return valor;
    }
    
    public int getValor(){
        return valor;
    }
}
