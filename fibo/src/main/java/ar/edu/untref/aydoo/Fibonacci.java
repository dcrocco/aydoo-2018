package ar.edu.untref.aydoo;

public class Fibonacci {


    /**
     * Recibe como parámetro un número y genera por pantalla los correspondientes
     * esa cantidad de números de la seria de Fibonacci 
     * Se presupone que el numero ingresado es válido
     */	
    public static void main(String arg[]) {
        int fibo_number = ((arg.length > 0) ? Integer.parseInt(arg[0]) : 0);
        FibonacciCalculator fibo_calc = new FibonacciCalculator();
        fibo_calc.show_fibonacci_number(fibo_number);
    }

}
