
package fútbol.táctico;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void moverJugador(int posicionActual) {
        Scanner scanner = new Scanner(System.in);
        
        // Mientras no llegue a la portería (posición 9 o 11 en el campo)
        while (posicionActual != 9 && posicionActual != 11) {
            System.out.println("Jugador actual: " + jugadores[posicionActual].nombre);
            System.out.println("Características disponibles: 1. Velocidad 2. Remates 3. Posesión");
            System.out.print("Elige una característica (1-3): ");
            int caracteristica = scanner.nextInt();

            Jugador siguienteJugador = seleccionarSiguienteJugador(posicionActual, caracteristica);
            if (siguienteJugador != null) {
                System.out.println("Moviendo a " + jugadores[posicionActual].nombre + " hacia " + siguienteJugador.nombre);
                posicionActual = obtenerPosicion(siguienteJugador);
            } else {
                System.out.println("No hay jugadores adyacentes disponibles.");
                break;  // Salir si no hay jugadores adyacentes
            }
        }

        System.out.println("El jugador ha llegado a la portería.");
        scanner.close();
    }

    private Jugador seleccionarSiguienteJugador(int posicionActual, int caracteristica) {
        List<Jugador> adyacentes = adyacencias.get(posicionActual);
        Jugador mejorJugador = null;
        int mejorValor = 0;

        for (Jugador jugador : adyacentes) {
            int valor = obtenerValorCaracteristica(jugador, caracteristica);
            System.out.println(valor);
            if (valor > mejorValor) {
                mejorValor = valor;
                mejorJugador = jugador;
            }
        }

        return mejorJugador;
    }

    // Método para obtener el valor de la característica seleccionada
    private int obtenerValorCaracteristica(Jugador jugador, int caracteristica) {
        switch (caracteristica) {
            case 1: // Velocidad
                return jugador.vel;
            case 2: // Posesión
                return jugador.rem;
            case 3: // Remates
                return jugador.pos;
            default:
                return -1; // Valor no válido
        }
    }

    // Método para obtener la posición de un jugador
    private int obtenerPosicion(Jugador jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == jugador) {
                System.out.println(i);
                return i;
                
            }
        }
        return -1;
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
        Jugador adyacente = campo.adyacencias.get(0).get(0); // Acceder al primer jugador adyacente del primer jugador
        System.out.println("Primer jugador adyacente de Jugador 1: " + adyacente.nombre);
        campo.moverJugador(0);
    }
}
