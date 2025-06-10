import java.util.Scanner;

public class calculadoraapp {

    // Usamos un único Scanner para toda la clase
    private static final Scanner CONSOLA = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int operacion = leerEntero("Escoja opción: ");

            switch (operacion) {
                case 1, 2, 3, 4 -> {
                    int operando1 = leerEntero("Ingrese valor 1: ");
                    int operando2 = leerEntero("Ingrese valor 2: ");

                    try {
                        int resultado = ejecutarOperacion(operacion, operando1, operando2);
                        System.out.println("El resultado es: " + resultado);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("Saliendo de la aplicación...");
                    continuar = false;
                }
                default -> System.out.println("La opción es errónea");
            }
        }
        CONSOLA.close(); // Cerramos el scanner al terminar
    }

    /* ----------  Funciones de dominio ---------- */

    private static int sumar(int a, int b)        { return a + b; }
    private static int restar(int a, int b)       { return a - b; }
    private static int multiplicar(int a, int b)  { return a * b; }

    private static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }

    /**
     * Ejecuta la operación seleccionada.
     * @param op 1-suma, 2-resta, 3-multiplicación, 4-división
     */
    private static int ejecutarOperacion(int op, int a, int b) {
        return switch (op) {
            case 1 -> sumar(a, b);
            case 2 -> restar(a, b);
            case 3 -> multiplicar(a, b);
            case 4 -> dividir(a, b);
            default -> 0; // No debería ocurrir (caso controlado en el switch principal)
        };
    }

    /* ----------  Funciones de interacción ---------- */

    private static void mostrarMenu() {
        System.out.println("""
                **** Aplicación Calculadora ****
                    1 - Suma
                    2 - Resta
                    3 - Multiplicación
                    4 - División
                    5 - Salir
                """);
    }

    /**
     * Lee un entero desde consola mostrando un mensaje al usuario.
     * Repite la petición si el usuario introduce un valor no numérico.
     */
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(CONSOLA.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }
    }
}
