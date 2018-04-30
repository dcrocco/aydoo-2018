package ar.edu.untref.aydoo;

public class Fibonacci {


    /**
     * Imprime por pantalla la secuencia de fibonacci, con la opción de poder imprimirla vertical u horizontalmente
     * y directa o inversamente.
     * args puede ser solo un entero (5), el cual es la cantidad de valores de la secuencia
     * o contemplar las opciones (v para vertical, h para horizontal, i para inversa o d para directa).
     * Ejemplo de uso con opciones: (-o=vi 8), vertical, inverso y 8 valores de la secuencia.
     */	
    public static void main(String args[]) throws IllegalArgumentException {
        try{
            validate_input(args);
        }catch (Exception IllegalArgumentException){
            System.out.println("Opciones no validas.");
            return;
        }
        int fibo_number = ((args.length > 1) ? Integer.parseInt(args[1]) : Integer.parseInt(args[0]));
        FibonacciCalculator fibo_calc = new FibonacciCalculator();
        String string_sequence = fibo_calc.get_fibonacci_string_sequence(fibo_number);
        System.out.println(print_fibonacci_sequence(string_sequence, fibo_number, args));
    }

    /**
     * Imprime la secuencia de fibonacci decorada con los argumentos especificados
     * @param string_sequence: Secuencia de fibonacci.
     * @param fibo_number: Cantidad de valores de la secuencia a imprimir.
     * @param args: Argumentos para decorar el ouput, ya sea cambiando su orientación o dirección.
     * @return: Secuencia decorada con los argumentos.
     */
    static String print_fibonacci_sequence(String string_sequence, int fibo_number, String[] args) {

        if (args.length > 1){
            string_sequence = new PrinterWithDirection(args[0].charAt(4)).print(string_sequence);
            string_sequence = new PrinterWithOrientation(args[0].charAt(3)).print(string_sequence);
        }

        return "fibo<"+fibo_number+">:"+string_sequence;
    }

    /**
     * Valida que el input tenga formato válido. Debe ser un entero en el caso de un argumento,
     * en el caso de dos argumentos tiene que cumplir con el formato de la expresión regular.
     */
    static void validate_input(String[] args) {
        if (args.length > 1){
            if (! (args[0].matches("-o=[vh][di]") &&  args[1].matches("[0-9]+"))){
                throw new IllegalArgumentException("Opción no válida!");
            }
        }else{
            try{
                Integer.parseInt(args[0]);
            }catch (Exception e){
                throw new IllegalArgumentException("Debe ingresar un número entero");
            }
        }
    }

}
