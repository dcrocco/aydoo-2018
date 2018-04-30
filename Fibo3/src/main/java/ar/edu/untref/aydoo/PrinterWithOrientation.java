package ar.edu.untref.aydoo;

public class PrinterWithOrientation extends Printer {

    private char orientation;

    PrinterWithOrientation(char orientation){
        this.orientation = orientation;
    }

    @Override
    public String print(String text_to_print) {
        if (this.orientation == 'v'){
            text_to_print = text_to_print.replace(" ", "\n");
        }
        return text_to_print;
    }
}
