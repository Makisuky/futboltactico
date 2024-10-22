/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fútbol.táctico;

/**
 *
 * @author alejo
 */
import java.util.ArrayList;
import java.util.List;

public class Campo {

    private Jugador[] jugadores;
    private List<List<Jugador>> adyacencias; // Lista de listas para cada vértice

    public Campo(Jugador[] jugadores, int[][] matrizAdyacencia) {
        this.jugadores = jugadores;
        this.adyacencias = new ArrayList<>();
        crearListasAdyacencia(matrizAdyacencia);
    }

    // Método para crear una lista de adyacencia independiente para cada vértice
    private void crearListasAdyacencia(int[][] matrizAdyacencia) {
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            List<Jugador> listaAdyacentes = new ArrayList<>();
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                if (matrizAdyacencia[i][j] == 1) {
                    listaAdyacentes.add(jugadores[j]);
                }
            }
            adyacencias.add(listaAdyacentes);
        }
    }

    // Método para imprimir las listas de adyacencia de cada vértice
    public void imprimirListasAdyacencia() {
        System.out.println("Listas de adyacencia de cada vértice:");
        for (int i = 0; i < adyacencias.size(); i++) {
            System.out.print(jugadores[i].nombre + ": ");
            List<Jugador> listaAdyacentes = adyacencias.get(i);
            for (Jugador adyacente : listaAdyacentes) {
                System.out.print(adyacente.nombre + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Nombres de los jugadores
        Jugador jugador = new Jugador();
        jugador.asignar();

        // Matriz de adyacencia
        int[][] matrizAdyacencia = {
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
        };

        // Crear el grafo e imprimirlo
        Campo campo = new Campo(jugador.jugadores, matrizAdyacencia);
        campo.imprimirListasAdyacencia();

    }
}
