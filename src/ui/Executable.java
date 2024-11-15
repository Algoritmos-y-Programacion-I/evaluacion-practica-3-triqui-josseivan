package ui;

import java.util.Scanner;

public class Executable {
    public static void main(String[] args) {
        Controladora controladora = new Controladora();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n1. Imprimir Tablero");
            System.out.println("2. Jugada Maquina");
            System.out.println("3. Jugada Humano");
            System.out.println("4. Verificar Ganador");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    controladora.imprimirTablero();
                    break;
                case 2:
                    controladora.jugadaMaquina();
                    break;
                case 3:
                    controladora.jugadaHumano();
                    break;
                case 4:
                    if (!controladora.hayGanador()) {
                        System.out.println("No hay ganador todavia.");
                    }
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
