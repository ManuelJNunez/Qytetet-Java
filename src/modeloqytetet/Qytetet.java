/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author manu
 */
public class Qytetet {
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    
    Sorpresa getMazo(int i){
        return mazo.get(i);
    }

    int getSize(){
        return mazo.size();
    }
    
    void inicializarCartasSorpresa(){
        mazo.add(new Sorpresa("El banco se ha equivocado en algunas cuentas y te devuelven dinero. Es que no estudian...", 250, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Te han pillado tus cuentas en el extrangero.", -250, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Tomas el tren que aún no ha llegado a Granada y llegas a la casilla 17.", 17, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Te hemos pillado transportando nesquik y Cola-Cao a la misma vez.", 9, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("El 7 dicen que da suerte. Vamos a comprobarlo mandándote a esa casilla.", 7, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Pagar por el mantenimiento de tus propiedades.", -25, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Tus edificios son muy bonitos. Recibes un premio de arquitectura.", 25, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Los demás se enteran de que tienes cuentas en el extrangero. Mejor sobornarlos para que no hablen, ¿no?", -200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Parece ser que es tu cumpleaños o tal vez los estés engañando, maldito mentiroso, recibes dinero de los demás como regalo.", 200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Tienes contactos en el gobierno que logran sacarte de la cárcel.", -200, TipoSorpresa.SALIRCARCEL));
    }
}
