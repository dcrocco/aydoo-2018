package ar.edu.untref.aydoo;

public class Crucero extends Barco{

    private int disparos;
    private boolean orientacionHorizontal;
    private int longitud;

    Crucero (){
        this.longitud = 2;
        this.disparos = 0;
        this.orientacionHorizontal = true;
    }

    @Override
    public ResultadoDeDisparo recibirDisparo() {
        this.disparos++;

        if (this.disparos == this.longitud){
            return ResultadoDeDisparo.HUNDIDO;
        }
        return ResultadoDeDisparo.TOCADO;
    }

    /**
     * Obtiene los limites del barco en base a su longitud, siendo los limites el valor mas alto de fila y columna.
     * @return Posicion: Posicion de sus limites
     */
    @Override
    Posicion obtenerLimites() {
        int filas = this.getPosicion().getFila();
        int columnas = this.getPosicion().getColumna();

        if (this.isOrientacionHorizontal()){
            filas += this.longitud - 1;
        }else{
            columnas += this.longitud - 1;
        }
        return new Posicion(filas, columnas);
    }

    @Override
    boolean seSuperponeCon(Barco unBarco) {
        int fila = this.getPosicion().getFila();
        int columna = this.getPosicion().getColumna();
        boolean seSuperponen = false;

        if (this.isOrientacionHorizontal()){
            for (int i = 0; i < this.longitud; i++){
                columna += i;

                seSuperponen = unBarco.estaEn(new Posicion(fila, columna));
                if (seSuperponen) break;
            }
        }else{
            for (int i = 0; i < this.longitud; i++){
                fila += i;
                seSuperponen = unBarco.estaEn(new Posicion(fila, columna));
                if (seSuperponen) break;
            }
        }
        return seSuperponen;
    }

    /**
     * Calcula la posición del barco segun la longitud del barco y su orientacion.
     *
     * @param unaPosicion : Posicion a comparar
     * @return boolean: true si está en la posición a comparar.
     */
    @Override
    boolean estaEn(Posicion unaPosicion) {
        boolean estaEnFila = false;
        boolean estaEnColumna = false;

        if (this.isOrientacionHorizontal()){
            estaEnFila = unaPosicion.getFila() == this.getPosicion().getFila();

            // Calculamos la columna en base a la longitud del bote
            int columna_barco = this.getPosicion().getColumna();
            int columna_posicion = unaPosicion.getColumna();
            int longitud = this.longitud;
            while (longitud > 0){
                longitud--;
                estaEnColumna = columna_posicion == columna_barco + longitud;
                if (estaEnColumna) break;
            }
        }else{

            estaEnColumna = unaPosicion.getColumna() == this.getPosicion().getColumna();

            // Calculamos la fila en base a la longitud del bote
            int fila_barco = this.getPosicion().getFila();
            int fila_posicion = unaPosicion.getFila();
            int longitud = this.longitud;
            while (longitud > 0){
                longitud--;
                estaEnFila = fila_posicion == fila_barco + longitud;
                if (estaEnFila){
                    break;
                }
            }
        }

        return estaEnFila && estaEnColumna;
    }

    boolean isOrientacionHorizontal() {
        return orientacionHorizontal;
    }

    void setOrientacionHorizontal(boolean orientacionHorizontal) {
        this.orientacionHorizontal = orientacionHorizontal;
    }
}
