import java.util.Scanner;

public class Criba {
	
	int maxNumber;
	boolean[] esPrimo = new boolean[maxNumber + 1];
	int [] vector;
    
	public Criba(int num) {
		
		maxNumber = num;
		
		// Inicializar el boolean array:
        for (int i = 0; i < (maxNumber + 1); i++) {
            esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos:
            esPrimo[0] = esPrimo[1] = false;
        }
        
     // Inicializar el int array:
        for (int i = 0; i < (maxNumber + 1); i++) {
           vector[i] = i + 1;
        }
        
        /*
         // Inicializar el int array :
        System.out.println("\nVector inicial hasta : " + maxNumber);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print((i + 1) + "\t");
        }
         */
           
	}
	
	public int cuantosPrimos () {
		int cuenta = 0;
		
		// ¿Cuántos primos hay?:
        for (int i = 0; i < (maxNumber + 1); i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        
        return cuenta;
        
	}
	
	public void ejecutarCriba() {
		
		// Criba:
        for (int i = 2; i < Math.sqrt(maxNumber + 1) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < (maxNumber + 1); j += i) {
                    esPrimo[j] = false;
                }
                
            }
            
        }
        
	}
	
    public int[] generarPrimos() {
    	
    	// Generar números primos de 1 a maxNumber
    	
        if (maxNumber >= 2) {
        	
        	int count = cuantosPrimos();
            
            // Rellenar el vector de números primos:
            int[] primos = new int[count];
            
            for (int i = 0, j = 0; i < (maxNumber + 1); i++) {
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
    	
    	Criba criba1;
    	int size;
        Scanner inputValue = new Scanner(System.in);
        
        System.out.println("Introduce el número máximo para la criba de Erastótenes: ");
        
        size = inputValue.nextInt();
        
        criba1 = new Criba(size);
        
        System.out.println(criba1.generarPrimos());
        
        /*
        System.out.println("\nVector de primos hasta: " + numMaximo);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
        */
        
    }
}
