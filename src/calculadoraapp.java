import java.util.Scanner;

public class calculadoraapp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("**** Aplicación Calculadora ****");
            System.out.println("""
                    1 - Suma
                    2 - Resta
                    3 - Multiplicación
                    4 - División
                    5 - Salir
                    """);

            System.out.println("Escoja opción:");
            try {
                var operacion = Integer.parseInt(consola.nextLine().trim());

                switch (operacion) {
                    case 1, 2, 3, 4 -> {
                        System.out.println("Ingrese valor 1:");
                        var operando1 = Integer.parseInt(consola.nextLine().trim());
                        System.out.println("Ingrese valor 2:");
                        var operando2 = Integer.parseInt(consola.nextLine().trim());
                        int resultado = 0;

                        switch (operacion) {
                            case 1 -> resultado = operando1 + operando2;
                            case 2 -> resultado = operando1 - operando2;
                            case 3 -> resultado = operando1 * operando2;
                            case 4 -> {
                                if (operando2 == 0) {
                                    System.out.println("No se puede dividir entre cero.");
                                    continue;
                                }
                                resultado = operando1 / operando2;
                            }
                        }
                        System.out.println("El resultado es: " + resultado);
                    }
                    case 5 -> {
                        System.out.println("Saliendo de la aplicación...");
                        continuar = false; // esto rompe el while
                    }
                    default -> System.out.println("La opción es errónea");
                }
            } catch (Exception e){
                System.out.println("ocurrio un error: " + e.getMessage());
            }
        }
    }
}
