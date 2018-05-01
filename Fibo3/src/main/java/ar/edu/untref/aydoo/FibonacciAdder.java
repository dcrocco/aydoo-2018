package ar.edu.untref.aydoo;

public class FibonacciAdder {

    int get_fibonacci_added_sequence(int position, FibonacciCalculator fiboCalculator){
        int result = 0;
        for (int i = 0; i < position; i++){
            result += fiboCalculator.get_fibonacci_number(i);
        }
        return result;
    }

}
