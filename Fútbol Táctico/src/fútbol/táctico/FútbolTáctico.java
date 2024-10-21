/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fútbol.táctico;

/**
 *
 * @author alejo
 */
public class FútbolTáctico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jugador jugador = new Jugador();
        jugador.asignar();

        for (int i = 0; i < 11; i++) {
            System.out.println(jugador.jugadores[i].nombre);

        }

    }

}
