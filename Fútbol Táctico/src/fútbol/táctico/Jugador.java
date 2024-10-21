/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fútbol.táctico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alejo
 */
public class Jugador {

    String nombre;
    int vel;
    int pos;
    int rem;

    public Jugador(String nombre, int vel, int pos, int rem) {
        this.nombre = nombre;
        this.vel = vel;
        this.pos = pos;
        this.rem = rem;
    }

    public void asignar() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\recursos\\infoJugadores.txt"));
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] dataset = line.split(";");
                Jugador plantilla = new Jugador(dataset[0], Integer.parseInt(dataset[1]), Integer.parseInt(dataset[2]), Integer.parseInt(dataset[3]));
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

}
