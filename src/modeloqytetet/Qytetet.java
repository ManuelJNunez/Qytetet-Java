package modeloqytetet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author manu
 */
public class Qytetet {
    private static final Qytetet instance = new Qytetet();
    public static int MAX_JUGADORES = 4;
    static int NUM_SORPRESA = 10;
    public static int NUM_CASILLAS = 20;
    static int PRECIO_LIBERTAD = 200;
    static int SALDO_SALIDA = 1000;
    private Sorpresa cartaActual = null;
    private Dado dado = Dado.getInstance();
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private EstadoJuego estado;
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    private Tablero tablero;
    private Jugador jugadorActual = null;
    
    private Qytetet(){}
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    public Tablero getTablero(){
    return this.tablero;
    }
    
    private void inicializarTablero(){
    this.tablero = new Tablero();
    } 
    
    ArrayList getMazo(){
        return mazo;
    }
    
    private void inicializarCartasSorpresa(){
        mazo.add(new Sorpresa("Te conviertes en especulaor, por la cara.", 3000, TipoSorpresa.CONVERTIRME));
        mazo.add(new Sorpresa("Te conviertes en especulaor, por la cara.", 5000, TipoSorpresa.CONVERTIRME));
        mazo.add(new Sorpresa("El banco se ha equivocado en algunas cuentas y te devuelven dinero. Es que no estudian...", 250, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Te han pillado tus cuentas en el extrangero.", -250, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Tomas el tren que aún no ha llegado a Granada y llegas a la casilla 17.", 17, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Te hemos pillado transportando nesquik y Cola-Cao a la misma vez.", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("El 7 dicen que da suerte. Vamos a comprobarlo mandándote a esa casilla.", 7, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Pagar por el mantenimiento de tus propiedades.", -25, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Tus edificios son muy bonitos. Recibes un premio de arquitectura.", 25, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Los demás se enteran de que tienes cuentas en el extrangero. Mejor sobornarlos para que no hablen, ¿no?", 200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Parece ser que es tu cumpleaños o tal vez los estés engañando, maldito mentiroso, recibes dinero de los demás como regalo.", -200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Tienes contactos en el gobierno que logran sacarte de la cárcel.", 0, TipoSorpresa.SALIRCARCEL));
        Random rndm = new Random();  
        Collections.shuffle(mazo, rndm);
    }

    void actuarSiEnCasillaEdificable(){
        boolean deboPagar = jugadorActual.DeboPagarAlquiler();
        if(deboPagar){
            jugadorActual.pagarAlquiler();
        }
        Casilla casilla = obtenerCasillaJugadorActual();
        boolean tengoPropietario = casilla.tengoPropietario();
        if (tengoPropietario){
            estado = EstadoJuego.JA_PUEDEGESTIONAR;
        }
        else{
            estado = EstadoJuego.JA_PUEDECOMPRAROGESTIONAR;
        }
        
    }
    
    void actuarSiEnCasillaNoEdificable(){
        estado = EstadoJuego.JA_PUEDEGESTIONAR;
        Casilla casillaActual = jugadorActual.getCasillaActual();
        if(casillaActual.getTipo()==TipoCasilla.IMPUESTO){
            jugadorActual.pagarImpuesto();
        }
        else if (casillaActual.getTipo() == TipoCasilla.JUEZ){
            encarcelarJugador();
        }
        else if (casillaActual.getTipo() == TipoCasilla.SORPRESA){
            cartaActual = mazo.get(0);
            mazo.remove(0);
            estado = EstadoJuego.JA_CONSORPRESA;
        }
    }
    
    public void aplicarSorpresa(){
        estado = EstadoJuego.JA_PUEDEGESTIONAR;
        TipoSorpresa tipo = cartaActual.getTipo();
        if(tipo == TipoSorpresa.SALIRCARCEL)
            jugadorActual.setCartaLibertad(cartaActual);
        else{
            mazo.add(cartaActual);
            
            if (tipo == TipoSorpresa.IRACASILLA){
                int valor = cartaActual.getValor();
                boolean casillaCarcel = tablero.esCasillaCarcel(valor);
                if(casillaCarcel)
                    encarcelarJugador();
                else
                    mover(valor);
            }else if(tipo == TipoSorpresa.PAGARCOBRAR){
                jugadorActual.modificarSaldo(cartaActual.getValor());
                if(jugadorActual.getSaldo()<0)
                    estado = EstadoJuego.ALGUNJUGADORENBANCARROTA;
            } else if(tipo == TipoSorpresa.PORCASAHOTEL){
                int cantidad = cartaActual.getValor();
                int numeroTotal = jugadorActual.CuantasCasasHotelesTengo();
                jugadorActual.modificarSaldo(cantidad*numeroTotal);
                if(jugadorActual.getSaldo()<0)
                    estado = EstadoJuego.ALGUNJUGADORENBANCARROTA;
            } else if(tipo == TipoSorpresa.PORJUGADOR){
                for(int i = 0; i<jugadores.size()-1; i++){
                    Jugador jugador = jugadores.get((jugadores.indexOf(jugadorActual)+1+i)%jugadores.size());
                    if(jugador != jugadorActual){
                        jugador.modificarSaldo(cartaActual.getValor());

                        if(jugador.getSaldo() < 0)
                           estado = EstadoJuego.ALGUNJUGADORENBANCARROTA;

                        jugadorActual.modificarSaldo(-cartaActual.getValor());

                        if(jugadorActual.getSaldo()<0)
                            estado = EstadoJuego.ALGUNJUGADORENBANCARROTA;
                    }
                }
            }else if(tipo == TipoSorpresa.CONVERTIRME){
                Especulador espec = new Especulador(jugadorActual, cartaActual.getValor());
                jugadores.set(jugadores.indexOf(jugadorActual), espec);
                jugadorActual = espec;
            }
        }
    }
    
    public boolean cancelarHipoteca(int numeroCasilla){
        Casilla casilla = obtenerCasillaJugadorActual();
        boolean esEdificable = casilla.soyEdificable();
        TituloPropiedad titulo = casilla.getTitulo();
        boolean hipotecada = titulo.getHipotecada();
        boolean cancelar = false;

        if (esEdificable && hipotecada)
            cancelar = jugadorActual.cancelarHipoteca(titulo);
      
        estado = EstadoJuego.JA_PUEDEGESTIONAR;
      
        return cancelar;
    }
    
    public boolean comprarTituloPropiedad(){
        boolean comprado = jugadorActual.comprarTituloPropiedad();
        if(comprado){
            estado = EstadoJuego.JA_PUEDEGESTIONAR;
        }
        return comprado;
    }
    
    public boolean edificarCasa(int numeroCasilla){
        boolean edificada;
        Casilla casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        edificada = jugadorActual.edificarCasa(titulo);
        if (edificada){
            estado = EstadoJuego.JA_PUEDEGESTIONAR;
        }
        return edificada;
    }
    
    public boolean edificarHotel(int numeroCasilla){
       Casilla casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
       TituloPropiedad titulo = casilla.getTitulo();
       boolean edificada = jugadorActual.edificarHotel(titulo);
       
       if(edificada)
           estado = EstadoJuego.JA_PUEDEGESTIONAR;
       
       return edificada;
    }
    
    private void encarcelarJugador(){
        Casilla casillaCarcel = tablero.getCarcel();
        if(jugadorActual.deboIrACarcel()){
            jugadorActual.irACarcel(casillaCarcel);
            estado = EstadoJuego.JA_ENCARCELADO;
        }
        else{
            Sorpresa carta = jugadorActual.devolverCartaLibertad();
            mazo.add(carta);
            estado = EstadoJuego.JA_PUEDEGESTIONAR;
        }
    }
    
    public Sorpresa getCartaActual(){
        return cartaActual;
    }
    
    Dado getDado(){
        return this.dado;
    }
    
    public EstadoJuego getEstadoJuego(){
        return estado;
    }
    
    public Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public ArrayList getJugadores() {
        return this.jugadores;
    }
    
    public int getValorDado(){
        return dado.getValor();
    }
    
    public void hipotecarPropiedad(int numeroCasilla){
        Casilla casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        jugadorActual.hipotecarPropiedad(titulo);
    }
    
    public void inicializarJuego(ArrayList <String> nombres){
        inicializarJugadores(nombres);
        inicializarTablero();
        inicializarCartasSorpresa();
        salidaJugadores();
    }
    
    private void inicializarJugadores(ArrayList <String> nombres){
        Jugador jugador_aux = null;
        for (int i = 0 ; i < nombres.size(); i++){
            jugador_aux = new Jugador(nombres.get(i));
            jugadores.add(jugador_aux);
        }
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        if(metodo == MetodoSalirCarcel.TIRANDODADO){
            int resultado = tirarDado();
            if(resultado >= 5)
                jugadorActual.setEncarcelado(false);
        }else if(metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
            jugadorActual.pagarLibertad(PRECIO_LIBERTAD);
        }
        boolean libre = jugadorActual.getEncarcelado();
        if(libre)
            estado = EstadoJuego.JA_PREPARADO;
        else
            estado = EstadoJuego.JA_ENCARCELADO;
        return libre;
    }
    
    public void jugar(){
        Casilla casillafinal = tablero.obtenerCasillaFinal(this.obtenerCasillaJugadorActual(), this.tirarDado());
        mover(casillafinal.getNumeroCasilla());
    }
    
    void mover(int numCasillaDestino){
        Casilla casillaInicial = jugadorActual.getCasillaActual();
        Casilla casillaFinal = tablero.ObtenerCasillaNumero(numCasillaDestino);
        jugadorActual.setCasillaActual(casillaFinal);
        if(numCasillaDestino < casillaInicial.getNumeroCasilla())
            jugadorActual.modificarSaldo(SALDO_SALIDA);
        if(casillaFinal.soyEdificable()){
            this.actuarSiEnCasillaEdificable();
        }else
            this.actuarSiEnCasillaNoEdificable();
    }
    
    public Casilla obtenerCasillaJugadorActual(){
        return jugadorActual.getCasillaActual();
    }
    
    public ArrayList obtenerCasillasTablero(){
        return tablero.getCasillas();
    }
    
    public ArrayList obtenerPropiedadesJugador(){
        ArrayList<Integer> propiedades = new ArrayList<>();
        ArrayList<TituloPropiedad> prop = jugadorActual.getPropiedades();
        ArrayList<Casilla> casillas = tablero.getCasillas();
        
        
        for(int i = 0; i < prop.size(); ++i){
            for(int j = 0; j < casillas.size(); ++j){
                if(prop.get(i) == casillas.get(j).getTitulo())
                    propiedades.add(j);
            }
        }
        
        return propiedades;
    }
    
    public ArrayList obtenerPropiedadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca){
        ArrayList<Integer> propiedades = new ArrayList<>();
        ArrayList<TituloPropiedad> prop = jugadorActual.obtenerPropiedades(estadoHipoteca);
        ArrayList<Casilla> casillas = tablero.getCasillas();
        
        
        for(int i = 0; i < prop.size(); ++i){
            for(int j = 0; j < casillas.size(); ++j){
                if(prop.get(i) == casillas.get(j).getTitulo())
                    propiedades.add(j);
            }
        }
        
        return propiedades;
    }
    
    public void obtenerRanking(){
        Collections.sort(jugadores);
    }
    
    public int obtenerSaldoJugadorActual(){
        return jugadorActual.getSaldo();
    }
    
    private void salidaJugadores(){
        int turno;
        for(int i = 0; i < jugadores.size(); ++i)
            jugadores.get(i).setCasillaActual(tablero.ObtenerCasillaNumero(0));
        Random rndm = new Random();         
        turno = rndm.nextInt(jugadores.size());
        jugadorActual = jugadores.get(turno);
        estado = EstadoJuego.JA_PREPARADO;
    }
    
    private void setCartaActual(Sorpresa cartaActual){
        this.cartaActual = cartaActual;
    }
    
    public void siguienteJugador(){
        int siguiente = (jugadores.indexOf(jugadorActual)+1)%jugadores.size();
        jugadorActual = jugadores.get(siguiente);
        
        if(jugadorActual.getEncarcelado())
            estado = EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD;
        else
            estado = EstadoJuego.JA_PREPARADO;
    }
    
    int tirarDado(){
        return dado.tirar();
    }
    
    public boolean venderPropiedad(int numeroCasilla){
        Casilla casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
        jugadorActual.venderPropiedad(casilla);
        estado = EstadoJuego.JA_PUEDEGESTIONAR;
        return true;
    }
    
    public boolean jugadorActualEnCalleLibre(){
        return jugadorActual.estoyEnCalleLibre();
    }
    
    public boolean jugadorActualEncarcelado(){
        return jugadorActual.getEncarcelado();
    }    
}
