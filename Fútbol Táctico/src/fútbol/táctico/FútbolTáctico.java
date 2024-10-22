
package fútbol.táctico;

public class FútbolTáctico {

    
    public static void main(String[] args) {

        Jugador jugador = new Jugador();
        jugador.asignar();

        for (int i = 0; i < 11; i++) {
            System.out.println(jugador.jugadores[i].nombre);

        }

    }

}
