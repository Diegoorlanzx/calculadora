import java.util.Scanner;

public class calculadoraapp {
    private static final Scanner CONSOLA = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();

            int operacion = leerEntero("Escoja opción: ");

            switch (operacion) {
                case 1, 2, 3, 4 -> {
                    double operando1 = leerDouble("Ingrese valor 1: ");
                    double operando2 = leerDouble("Ingrese valor 2: ");

                    try {
                        double resultado = ejecutarOperacion(operacion, operando1, operando2);
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

        CONSOLA.close();
    }

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

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(CONSOLA.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }
    }

    private static double ejecutarOperacion(int op, double a, double b) {
        return switch (op) {
            case 1 -> sumar(a, b);
            case 2 -> restar(a, b);
            case 3 -> multiplicar(a, b);
            case 4 -> dividir(a, b);
            default -> 0.0;
        };
    }

    private static double sumar(double a, double b) {
        return a + b;
    }

    private static double restar(double a, double b) {
        return a - b;
    }

    private static double multiplicar(double a, double b) {
        return a * b;
    }

    private static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }
}
