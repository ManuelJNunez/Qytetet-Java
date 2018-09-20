/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author manu
 */
public class Sorpresa {
    private String sorpresa;
    private TipoSorpresa tipo;
    private int valor;
    
    public Sorpresa(String texto, int valor, TipoSorpresa tipo){
        sorpresa = texto;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public String getSorpresa(){
        return sorpresa;
    }
    
    public TipoSorpresa getTipo(){
        return tipo;
    }
    
    public int getValor(){
        return valor;
    }
    

    @Override
    public String toString() {
        return "Sorpresa{" + "texto=" + sorpresa + ", valor=" + Integer.toString(valor) + ", tipo=" + tipo + "}";
     } 
}
