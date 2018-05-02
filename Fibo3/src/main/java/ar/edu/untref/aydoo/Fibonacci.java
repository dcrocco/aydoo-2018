package ar.edu.untref.aydoo;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {


    private static String[] validArguments = new String[]{"-o=[vh][di]", "-m=[ls]", "-f=[^\\s]+"};

    /**
     * Imprime por pantalla la secuencia de fibonacci, con la opción de poder imprimirla vertical u horizontalmente
     * y directa o inversamente.
     * args puede ser solo un entero (5), el cual es la cantidad de valores de la secuencia
     * o contemplar las opciones (v para vertical, h para horizontal, i para inversa o d para directa).
     * Ejemplo de uso con opciones: (-o=vi 8), vertical, inverso y 8 valores de la secuencia.
     */	
    public static void main(String args[]) throws IllegalArgumentException {
        try{
            validateInput(args);
        }catch (Exception IllegalArgumentException){
            System.out.println("Opciones no validas.");
            return;
        }
        int fibo_number = Integer.parseInt(args[args.length -1 ]);
        String stringSequence = getStringSequence(fibo_number, args);
        System.out.println(printFibonacciSequence(stringSequence, fibo_number, args));
    }

    /**
     * Imprime la secuencia de fibonacci decorada con los argumentos especificados
     * @param stringSequence: Secuencia de fibonacci.
     * @param fibo_number: Cantidad de valores de la secuencia a imprimir.
     * @param args: Argumentos para decorar el ouput, ya sea cambiando su orientación, dirección, sumada o en un archivo.
     * @return: Secuencia decorada con los argumentos.
     */
    static String printFibonacciSequence(String stringSequence, int fibo_number, String[] args) {

        String prefix = "fibo<"+fibo_number+">";
        String new_prefix = prefix;
        boolean saveToFile = false;
        String fileName = "";

        if (args.length > 1){

            List argsAsList = Arrays.asList(args);
            if (argsAsList.contains("-m=s")){
                new_prefix += "s";
                stringSequence = " " + stringSequence;
            }

            for (int i = 0; i < args.length - 1; i++){
                if (args[i].matches("-o=[vh][i]")){
                    stringSequence = new PrinterWithDirection('i').print(stringSequence);
                }
                if (args[i].matches("-o=[v][di]")){
                    stringSequence = new PrinterWithOrientation('v').print(stringSequence);
                }
                if (args[i].matches("-f=[^\\s]+")){
                    fileName = args[i].substring(3, args[i].length());
                    saveToFile = true;
                }

            }

        }

        stringSequence = new_prefix+":"+stringSequence;

        if (saveToFile){
            try{
                FileSaver.saveToFile(stringSequence, fileName);
                stringSequence = prefix+" guardado en "+fileName;
            }catch (IOException e){
                stringSequence = "Error al intentar guardar el archivo.";
            }
        }

        return stringSequence;
    }

    /**
     * Valida que el input tenga formato válido. Debe ser un entero en el caso de un argumento,
     * en el caso de dos argumentos tiene que cumplir con el formato de la expresión regular.
     */
    static void validateInput(String[] args) {
        if (args.length > 1){
            boolean legal_arguments;
            for (int i = 0; i < args.length - 1; i++) {
                legal_arguments = false;
                for (String validArgument : validArguments) {
                    if (args[i].matches(validArgument)) {
                        legal_arguments = true;
                    }
                }
                if (!legal_arguments) {
                    throw new IllegalArgumentException("Opción no válida!");
                }
            }
        }
        // El ultimo parámetro debe ser el número de la secuencia de fibonacci
        try{
            Integer.parseInt(args[args.length - 1]);
        }catch (Exception e){
            throw new IllegalArgumentException("Debe ingresar un número entero");
        }
    }

    static String getStringSequence(int fibo_number, String[] args) {

        FibonacciCalculator fibo_calc = new FibonacciCalculator();
        List argsAsList = Arrays.asList(args);

        String stringSequence;
        if (argsAsList.contains("-m=s")){
            FibonacciAdder fiboAdder = new FibonacciAdder();
            int addedSequence = fiboAdder.get_fibonacci_added_sequence(fibo_number, fibo_calc);
            stringSequence = Integer.toString(addedSequence);
        }else{
            stringSequence = fibo_calc.getFibonacciStringSequence(fibo_number);
        }

        return stringSequence;
    }

}
