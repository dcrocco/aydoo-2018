package ar.edu.untref.aydoo;

class FibonacciCalculator {

    /**
     * Realiza el calculo de fibonacci para la posicion especificada.
     * @param position: Posicion que se desea calcular.
     * @return int: Valor del numero calculado.
     */
    int get_fibonacci_number(int position){
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
     * Forma un string separado por espacio la cantidad de posiciones especificadas.
     * @param position: Cantidad de posiciones a imprimir.
     * @return String: string formado.
     */
    String getFibonacciStringSequence(int position){
        StringBuilder result = new StringBuilder();
    	for (int i = 0; i < position; i++){
            result.append(" ").append(get_fibonacci_number(i));
        }
        return result.toString();
    }
}
