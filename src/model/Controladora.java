import java.util.Scanner;
import java.util.Random;

public class Controladora {
    private char[][] tablero;
    private Random random;

    public Controladora() {
        tablero = new char[3][3];
        random = new Random();
        inicializarTablero();
    }

    public void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void jugadaMaquina() {
        boolean jugadaValida = false;
        while (!jugadaValida) {
            int i = random.nextInt(3);
            int j = random.nextInt(3);
            if (tablero[i][j] == '-') {
                tablero[i][j] = 'X';
                jugadaValida = true;
            }
        }
    }

    public void jugadaHumano() {
        Scanner scanner = new Scanner(System.in);
        boolean jugadaValida = false;

        while (!jugadaValida) {
            System.out.print("Ingrese fila (0-2): ");
            int i = scanner.nextInt();
            System.out.print("Ingrese columna (0-2): ");
            int j = scanner.nextInt();

            if (i >= 0 && i < 3 && j >= 0 && j < 3 && tablero[i][j] == '-') {
                tablero[i][j] = 'O';
                jugadaValida = true;
            } else {
                System.out.println("Jugada no válida. Inténtelo de nuevo.");
            }
        }
    }

    public boolean hayGanador() {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != '-' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                anunciarGanador(tablero[i][0]);
                return true;
            }
            if (tablero[0][i] != '-' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                anunciarGanador(tablero[0][i]);
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            anunciarGanador(tablero[0][0]);
            return true;
        }
        if (tablero[0][2] != '-' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            anunciarGanador(tablero[0][2]);
            return true;
        }

        return false;
    }

    private void anunciarGanador(char ganador) {
        if (ganador == 'X') {
            System.out.println("¡La máquina ha ganado!");
        } else if (ganador == 'O') {
            System.out.println("¡El humano ha ganado!");
        }
    }
}
