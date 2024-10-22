
package fútbol.táctico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Jugador {

    String nombre;
    int vel;
    int pos;
    int rem;
    Jugador izq;
    Jugador der;

    static Jugador jugadores[] = new Jugador[11];

    public Jugador(String nombre, int vel, int rem, int pos) {
        this.nombre = nombre;
        this.vel = vel;
        this.pos = pos;
        this.rem = rem;
    }

    public Jugador() {
    }

    public void asignar() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\recursos\\infoJugadores.txt"));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < jugadores.length) {

                String[] dataset = line.split(",");

                jugadores[i] = new Jugador(dataset[0], Integer.parseInt(dataset[1]), Integer.parseInt(dataset[2]), Integer.parseInt(dataset[3]));

                i++;

                //yo soy un abogado muy profesional, defiendo a mis clientes con habilidad
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

}
