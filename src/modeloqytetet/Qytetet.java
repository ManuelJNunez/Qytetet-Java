package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author manu
 */
public class Qytetet {
    private static final Qytetet instance = new Qytetet();
    public int MAX_JUGADORES = 4;
    int NUM_SORPRESA = 10;
    public int NUM_CASILLAS = 20;
    int PRECIO_LIBERTAR = 200;
    int SALDO_SALIDA = 1000;
    private Sorpresa cartaActual = null;
    private Dado dado = Dado.getInstance();
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private EstadoJuego estado;
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    private Tablero tablero;
    private int iterador = 0;
    private Jugador jugadorActual = jugadores.get(0);
    
    private Qytetet(){
    }
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
        mazo.add(new Sorpresa("El banco se ha equivocado en algunas cuentas y te devuelven dinero. Es que no estudian...", 250, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Te han pillado tus cuentas en el extrangero.", -250, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Tomas el tren que aún no ha llegado a Granada y llegas a la casilla 17.", 17, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Te hemos pillado transportando nesquik y Cola-Cao a la misma vez.", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("El 7 dicen que da suerte. Vamos a comprobarlo mandándote a esa casilla.", 7, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Pagar por el mantenimiento de tus propiedades.", -25, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Tus edificios son muy bonitos. Recibes un premio de arquitectura.", 25, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Los demás se enteran de que tienes cuentas en el extrangero. Mejor sobornarlos para que no hablen, ¿no?", -200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Parece ser que es tu cumpleaños o tal vez los estés engañando, maldito mentiroso, recibes dinero de los demás como regalo.", 200, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Tienes contactos en el gobierno que logran sacarte de la cárcel.", 0, TipoSorpresa.SALIRCARCEL));
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
    
    
    
    }
    
    public void aplicarSorpresa(){}
    
    public boolean cancelarHipoteca(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarCasa(int numneroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");        
    }
    
    private void encarcelarJugador(){
    }
    
    public Sorpresa getCartaActual() {
        return cartaActual;
    }
    
    Dado getDado(){
        return this.dado;
    }
    
    Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public ArrayList getJugadores() {
        return this.jugadores;
    }
    
    public int getValorDado(){
        return dado.getValor();
    }
    
    public void hipotecarPropiedad(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");        
    }
    
    public void inicializarJuego(ArrayList <String> nombres){
        inicializarJugadores(nombres);
        inicializarTablero();
        inicializarCartasSorpresa();
        
    }
    
    private void inicializarJugadores(ArrayList <String> nombres){
        Jugador jugador_aux = null;
        for (int i = 0 ; i < nombres.size(); i++){
            jugador_aux = new Jugador(nombres.get(i));
            jugadores.add(jugador_aux);
        }
    }
    
    public boolean intentarSalirCarcel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void jugar(){
        Casilla casillafinal = tablero.obtenerCasillaFinal(jugadores.get(iterador).getCasillaActual(), this.tirarDado());
        mover(casillafinal.getNumeroCasilla());
    }
    
    void mover(int numCasillaDestino){
        
    }
    
    public Casilla obtenerCasillaJugadorActual(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList obtenerCasillasTablero(){
        throw new UnsupportedOperationException("Sin implementar");
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
    
    public void obtenerRanking(){}
    
    public int obtenerSaldoJugadorActual(){
        return jugadores.get(iterador).getSaldo();
    }
    
    private void salidaJugadores(){
        estado = EstadoJuego.JA_PREPARADO;
        for(int i = 0; i < jugadores.size(); ++i)
            jugadores.get(i).setCasillaActual(tablero.ObtenerCasillaNumero(0));
    }
    
    private void setCartaActual(Sorpresa cartaActual){}
    
    public void siguienteJugador(){
        iterador++;
        
        iterador = iterador%jugadores.size();
        
        if(jugadores.get(iterador).getEncarcelado())
            estado = EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD;
        else
            estado = EstadoJuego.JA_PREPARADO;
    }
    
    int tirarDado(){
        return dado.tirar();
    }
    
    public boolean venderPropiedad(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean jugadorActualEnCalleLibre(){
        return jugadorActual.estoyEnCalleLibre();
    }
    
    public boolean jugadorActualEncarcelado(){
        return jugadorActual.getEncarcelado();
    }    
}
