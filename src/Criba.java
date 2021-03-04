import java.util.Scanner;

public class Criba {
	
    // Generar números primos de 1 a maxNumber
    public static int[] generarPrimos (int maxNumber) {
    	
    	// Declaraciones 
        int arrSize = maxNumber + 1; // Tamaño del array
        boolean[] esPrimo = new boolean[arrSize];
        int cuenta = 0;
        
     // Inicializar el array:
        for (int i = 0; i < arrSize; i++) {
            esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos:
            esPrimo[0] = esPrimo[1] = false;
        }

        if (maxNumber >= 2) {

            // Criba:
            for (int i = 2; i < Math.sqrt(arrSize) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (int j = 2 * i; j < arrSize; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }

            // ¿Cuántos primos hay?:
            for (int i = 0; i < arrSize; i++) {
                if (esPrimo[i]) {
                    cuenta++;
                }
            }

            // Rellenar el vector de números primos:
            int[] primos = new int[cuenta];
            
            for (int i = 0, j = 0; i < arrSize; i++) {
                if (esPrimo[i]) {
                    primos[j++] = i;
                }
            }

            return primos;

        } else { // maxNumber < 2
            return new int[0];
            // Vector vacío.
        }
    }

    public static void main(String[] args) {

        int numMaximo;
        int[] vector;
        Scanner inputValue = new Scanner(System.in);

        System.out.println("Introduce el número máximo para la criba de Erastótenes: ");

        numMaximo = inputValue.nextInt();

        vector = new int[numMaximo];

        System.out.println("\nVector inicial hasta : " + numMaximo);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print((i + 1) + "\t");
        }

        vector = generarPrimos(numMaximo);

        System.out.println("\nVector de primos hasta: " + numMaximo);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}
