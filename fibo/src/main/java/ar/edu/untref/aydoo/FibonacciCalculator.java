package ar.edu.untref.aydoo;

public class FibonacciCalculator {

    /**
     * Realiza el calculo de fibonacci para la posicion especificada.
     * @param int posicion: Posicion que se desea calcular.
     * @return int: Valor del numero calculado.
     */
    public int get_fibonacci_number(int position){	
	if (position > 1){
	    return get_fibonacci_number(position-1) + get_fibonacci_number(position-2);
	}            
	else if (position==1) {
	    return 1;
        }
	else if (position==0){
            return 0;
	}
        else {
	    System.out.println("Posición ingresada inválida");
  	    return -1;
	}
    }

    /**
     * Imprime en pantalla separado por espacio la cantidad de posiciones especificadas.
     * @param int position: Cantidad de posiciones a imprimir
     */
    public void show_fibonacci_number(int position){
        String result = "fibo<"+position+">: ";
    	for (int i = 0; i < position; i++){
            result += get_fibonacci_number(i)+ " ";
        }
        System.out.println(result);      
    }
}
