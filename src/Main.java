import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ubicacionActual = 1;
        String direccion;

        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));

        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("O", 2);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("Q", 0);

        ubicaciones.get(2).addExit("N", 5);
        ubicaciones.get(2).addExit("Q", 0);

        ubicaciones.get(3).addExit("O", 1);
        ubicaciones.get(3).addExit("Q", 0);

        ubicaciones.get(4).addExit("N", 1);
        ubicaciones.get(4).addExit("O", 2);
        ubicaciones.get(4).addExit("Q", 0);

        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);
        ubicaciones.get(5).addExit("Q", 0);

        do {
            moverse(ubicacionActual);
            System.out.print("Elige una dirección: ");
            direccion = sc.nextLine().toUpperCase();

            if (direccion.equals("Q")) {
                System.out.println("Saliendo del juego...");

            }

            Ubicacion ubicacion = ubicaciones.get(ubicacionActual);
            if (ubicacion.getExits().containsKey(direccion)) {
                ubicacionActual = ubicacion.getExits().get(direccion); // Actualizar ubicación
            } else {
                System.out.println("Dirección no válida. Intenta de nuevo.");
            }
        } while (!direccion.equalsIgnoreCase("Q"));
    }

    public static void moverse(int idUbicacion) {
        System.out.println(ubicaciones.get(idUbicacion).getDescripcion());
        printExits(idUbicacion);
    }

    public static void printExits(int idUbicacion) {
            Ubicacion ubicacion2 = ubicaciones.get(idUbicacion);
            if (ubicacion2 != null) {
                System.out.print("Tus salidas válidas son ");
                ubicacion2.printExits();
                System.out.println();
            } else {
                System.out.println("Ubicación no encontrada.");
            }
            System.out.println("----------------------------------------------------");
    }
}