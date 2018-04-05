package ar.edu.untref.aydoo;

public class Crucero extends Barco{

    private int disparos = 0;
    private boolean orientacionHorizontal = true;

    public ResultadoDeDisparo recibirDisparo() {
        this.disparos++;
        if (this.disparos == 2){
            return ResultadoDeDisparo.HUNDIDO;
        }
        return ResultadoDeDisparo.TOCADO;
    }

    public boolean isOrientacionHorizontal() {
        return orientacionHorizontal;
    }

    public void setOrientacionHorizontal(boolean orientacionHorizontal) {
        this.orientacionHorizontal = orientacionHorizontal;
    }
}
